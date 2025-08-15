package Tasfia;

    public class Doctor {
        private String name;
        private String specialist;
        private String details;

        public Doctor(String name, String specialist, String details) {
            this.name = name;
            this.specialist = specialist;
            this.details = details;
        }

        public String getName() { return name; }
        public String getSpecialist() { return specialist; }
        public String getDetails() { return details; }
    }



