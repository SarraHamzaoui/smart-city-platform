package com.smartcity.orchestratorservice.service;


import java.util.List;

public class SmartCityRouteResponse {

    private String zone;
    private AirQualitySection airQuality;
    private List<TransportLineDto> transportLines;
    private ZoneOverviewSection analytics;
    private EmergencySection emergency;
    private List<IncidentDto> incidents;

    public SmartCityRouteResponse() {}

    public String getZone() { return zone; }
    public void setZone(String zone) { this.zone = zone; }

    public AirQualitySection getAirQuality() { return airQuality; }
    public void setAirQuality(AirQualitySection airQuality) { this.airQuality = airQuality; }

    public List<TransportLineDto> getTransportLines() { return transportLines; }
    public void setTransportLines(List<TransportLineDto> transportLines) { this.transportLines = transportLines; }

    public ZoneOverviewSection getAnalytics() { return analytics; }
    public void setAnalytics(ZoneOverviewSection analytics) { this.analytics = analytics; }

    public EmergencySection getEmergency() { return emergency; }
    public void setEmergency(EmergencySection emergency) { this.emergency = emergency; }

    public List<IncidentDto> getIncidents() { return incidents; }
    public void setIncidents(List<IncidentDto> incidents) { this.incidents = incidents; }

    // inner classes
    public static class AirQualitySection {
        private String zone;
        private double aqi;
        private double no2;
        private double co2;
        private double o3;
        private String levelLabel;
        private String advisory;

        public AirQualitySection() {}

        public String getZone() { return zone; }
        public void setZone(String zone) { this.zone = zone; }

        public double getAqi() { return aqi; }
        public void setAqi(double aqi) { this.aqi = aqi; }

        public double getNo2() { return no2; }
        public void setNo2(double no2) { this.no2 = no2; }

        public double getCo2() { return co2; }
        public void setCo2(double co2) { this.co2 = co2; }

        public double getO3() { return o3; }
        public void setO3(double o3) { this.o3 = o3; }

        public String getLevelLabel() { return levelLabel; }
        public void setLevelLabel(String levelLabel) { this.levelLabel = levelLabel; }

        public String getAdvisory() { return advisory; }
        public void setAdvisory(String advisory) { this.advisory = advisory; }
    }

    public static class ZoneOverviewSection {
        private long population;
        private int serviceCount;
        private boolean hasHospital;
        private boolean hasMetro;

        public ZoneOverviewSection() {}

        public long getPopulation() { return population; }
        public void setPopulation(long population) { this.population = population; }

        public int getServiceCount() { return serviceCount; }
        public void setServiceCount(int serviceCount) { this.serviceCount = serviceCount; }

        public boolean isHasHospital() { return hasHospital; }
        public void setHasHospital(boolean hasHospital) { this.hasHospital = hasHospital; }

        public boolean isHasMetro() { return hasMetro; }
        public void setHasMetro(boolean hasMetro) { this.hasMetro = hasMetro; }
    }

    public static class EmergencySection {
        private String status;
        private String message;

        public EmergencySection() {}

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
    }
}
