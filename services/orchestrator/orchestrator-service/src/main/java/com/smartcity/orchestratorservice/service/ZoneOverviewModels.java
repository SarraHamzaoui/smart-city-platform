package com.smartcity.orchestratorservice.service;

public class ZoneOverviewModels {

    public static class GraphqlResponse {
        private Data data;

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }
    }

    public static class Data {
        private ZoneOverview zoneOverview;

        public ZoneOverview getZoneOverview() {
            return zoneOverview;
        }

        public void setZoneOverview(ZoneOverview zoneOverview) {
            this.zoneOverview = zoneOverview;
        }
    }

    public static class ZoneOverview {
        private String zone;
        private int population;
        private int serviceCount;
        private boolean hasHospital;
        private boolean hasMetro;

        public String getZone() {
            return zone;
        }

        public void setZone(String zone) {
            this.zone = zone;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public int getServiceCount() {
            return serviceCount;
        }

        public void setServiceCount(int serviceCount) {
            this.serviceCount = serviceCount;
        }

        public boolean isHasHospital() {
            return hasHospital;
        }

        public void setHasHospital(boolean hasHospital) {
            this.hasHospital = hasHospital;
        }

        public boolean isHasMetro() {
            return hasMetro;
        }

        public void setHasMetro(boolean hasMetro) {
            this.hasMetro = hasMetro;
        }
    }
}