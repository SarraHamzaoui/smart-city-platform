import React, { useState } from "react";
import api from "./api";
import "./App.css";
import { FaBus, FaWind, FaAmbulance, FaMapMarkedAlt } from "react-icons/fa";

function App() {
    const [zone, setZone] = useState("CENTRE");
    const [data, setData] = useState(null);
    const [loading, setLoading] = useState(false);

    async function fetchData() {
        try {
            setLoading(true);
            const res = await api.get(`/orchestrator/plan-route`, { params: { zone } });
            setData(res.data);
        } catch (err) {
            console.error(err);
            setData(null);
            alert("Erreur de communication avec la plateforme");
        } finally {
            setLoading(false);
        }
    }

    // 🔴 Signaler un incident pour la zone sélectionnée
    async function sendEmergency() {
        try {
            const res = await api.post("/orchestrator/alerts", {
                type: "fire",
                zone,
                description: `Alerte citoyenne déclarée dans la zone ${zone}`
            });

            console.log("Réponse POST /orchestrator/alerts:", res.status, res.data);
            alert("Alerte transmise !");

            // Toujours rafraîchir l'affichage des données (pour voir l'alerte)
            await fetchData();
        } catch (e) {
            console.error("Erreur sendEmergency:", e);
            // si le serveur renvoie un body d'erreur on peut l'afficher :
            if (e.response && e.response.data) {
                console.error("Body erreur serveur:", e.response.data);
            }
            alert("Impossible d'envoyer l'alerte");
        }
    }


    const air = data?.airQuality;
    const analytics = data?.analytics;
    const emergency = data?.emergency;
    const lines = data?.transportLines || [];
    const incidents = data?.incidents || [];

    return (
        <div className="app-root">
            <header className="app-header">
                <div>
                    <div className="app-title">Smart City Dashboard 🌍</div>
                    <div className="app-subtitle">
                        Ville intelligente — Trajets, qualité de l’air & urgences
                    </div>
                </div>

                <div className="app-controls">
                    <select
                        className="app-select"
                        value={zone}
                        onChange={(e) => setZone(e.target.value)}
                    >
                        <option value="CENTRE">CENTRE</option>
                        <option value="UNIVERSITE">UNIVERSITE</option>
                        <option value="ZONE_INDUS">ZONE_INDUS</option>
                    </select>

                    <button className="app-button" onClick={fetchData} disabled={loading}>
                        {loading ? "Chargement..." : "Planifier"}
                    </button>

                    <button
                        className="app-button"
                        style={{ background: "red" }}
                        onClick={sendEmergency}
                    >
                        ⚠️ Signaler un incident
                    </button>
                </div>
            </header>

            {data && (
                <div className="cards-grid">
                    {/* Air Quality */}
                    <Card icon={<FaWind size={22} />} title="Qualité de l’air">
                        {air ? (
                            <>
                                <div style={{ marginBottom: 6 }}>
                                    AQI: <strong>{air.aqi}</strong>{" "}
                                    <span
                                        className={
                                            air.levelLabel === "Mauvaise"
                                                ? "badge badge-danger"
                                                : air.levelLabel === "Modérée"
                                                    ? "badge badge-warn"
                                                    : "badge badge-ok"
                                        }
                                    >
                    {air.levelLabel}
                  </span>
                                </div>
                                <div className="text-muted">{air.advisory}</div>
                                <div className="zone-meta">
                                    NO₂: {air.no2.toFixed(1)} μg/m³ – CO₂: {air.co2.toFixed(1)} ppm – O₃:{" "}
                                    {air.o3.toFixed(1)} μg/m³
                                </div>
                            </>
                        ) : (
                            <div className="text-muted">Données indisponibles.</div>
                        )}
                    </Card>

                    {/* Transport */}
                    <Card icon={<FaBus size={22} />} title="Transports publics">
                        {lines.length > 0 ? (
                            <ul className="lines-list">
                                {lines.map((l) => (
                                    <li key={l.id} className="line-item">
                    <span className="line-name">
                      {l.name} ({l.type})
                    </span>
                                        <span className="line-status">
                      {l.status === "NORMAL" ? "✅" : "⚠️ " + l.status}
                    </span>
                                    </li>
                                ))}
                            </ul>
                        ) : (
                            <div className="text-muted">Aucune ligne disponible.</div>
                        )}
                    </Card>

                    {/* Emergency system status */}
                    <Card icon={<FaAmbulance size={22} />} title="Urgences">
                        {emergency ? (
                            <>
                                <div
                                    className={
                                        emergency.status === "OK" || emergency.status === "RECEIVED"
                                            ? "badge badge-ok"
                                            : "badge badge-danger"
                                    }
                                    style={{ marginBottom: 6 }}
                                >
                                    {emergency.status}
                                </div>
                                <div>{emergency.message}</div>
                            </>
                        ) : (
                            <div className="text-muted">Pas de données d’urgence.</div>
                        )}
                    </Card>

                    {/* Incidents citoyens */}
                    {incidents.length > 0 && (
                        <Card icon={<FaAmbulance size={22} />} title="Alertes citoyennes actives">
                            <ul className="lines-list">
                                {incidents.map((a, i) => (
                                    <li key={i} className="line-item">
                    <span className="line-name">
                      {a.type} signalé dans <strong>{a.zone}</strong>
                    </span>
                                    </li>
                                ))}
                            </ul>
                        </Card>
                    )}

                    {/* Zone Info */}
                    <Card icon={<FaMapMarkedAlt size={22} />} title="Vue zone">
                        {analytics ? (
                            <div className="zone-meta">
                                Population estimée :{" "}
                                <strong>{analytics.population.toLocaleString()}</strong>
                                <br />
                                Services référencés : <strong>{analytics.serviceCount}</strong>
                                <br />
                                Hôpital :{" "}
                                <strong>{analytics.hasHospital ? "Oui" : "Non"}</strong>
                                <br />
                                Métro : <strong>{analytics.hasMetro ? "Oui" : "Non"}</strong>
                            </div>
                        ) : (
                            <div className="text-muted">Aucune information de zone.</div>
                        )}
                    </Card>
                </div>
            )}
        </div>
    );
}

function Card({ icon, title, children }) {
    return (
        <div className="card">
            <div className="card-header">
                {icon}
                <div className="card-title">{title}</div>
            </div>
            {children}
        </div>
    );
}

export default App;
