package Tasfia;

    public class DoctorFee {
        private String name;
        private String details;
        private double fee;

        public DoctorFee(String name, String details, double fee) {
            this.name = name;
            this.details = details;
            this.fee = fee;
        }

        public String getName() { return name; }
        public String getDetails() { return details; }
        public double getFee() { return fee; }
    }



