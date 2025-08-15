package Tasfia;

    public class ServiceRecord {
        private String serviceName;
        private String shortInfo;

        public ServiceRecord(String serviceName, String shortInfo) {
            this.serviceName = serviceName;
            this.shortInfo = shortInfo;
        }

        public String getServiceName() { return serviceName; }
        public String getShortInfo() { return shortInfo; }
    }


