
package com.smartcity.orchestrator.soapclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour airQualityData complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="airQualityData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="zone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="aqi" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="no2" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="co2" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="o3" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "airQualityData", propOrder = {
    "zone",
    "aqi",
    "no2",
    "co2",
    "o3"
})
public class AirQualityData {

    protected String zone;
    protected int aqi;
    protected double no2;
    protected double co2;
    protected double o3;

    /**
     * Obtient la valeur de la propriété zone.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZone() {
        return zone;
    }

    /**
     * Définit la valeur de la propriété zone.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZone(String value) {
        this.zone = value;
    }

    /**
     * Obtient la valeur de la propriété aqi.
     * 
     */
    public int getAqi() {
        return aqi;
    }

    /**
     * Définit la valeur de la propriété aqi.
     * 
     */
    public void setAqi(int value) {
        this.aqi = value;
    }

    /**
     * Obtient la valeur de la propriété no2.
     * 
     */
    public double getNo2() {
        return no2;
    }

    /**
     * Définit la valeur de la propriété no2.
     * 
     */
    public void setNo2(double value) {
        this.no2 = value;
    }

    /**
     * Obtient la valeur de la propriété co2.
     * 
     */
    public double getCo2() {
        return co2;
    }

    /**
     * Définit la valeur de la propriété co2.
     * 
     */
    public void setCo2(double value) {
        this.co2 = value;
    }

    /**
     * Obtient la valeur de la propriété o3.
     * 
     */
    public double getO3() {
        return o3;
    }

    /**
     * Définit la valeur de la propriété o3.
     * 
     */
    public void setO3(double value) {
        this.o3 = value;
    }

}
