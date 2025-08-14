package Tasfia;

import java.time.LocalDate;

    public class DoctorPayoutRecord {

        private String doctorName;
        private double amount;
        private String status;
        private LocalDate date;

        public DoctorPayoutRecord(String doctorName, double amount, String status, LocalDate date) {
            this.doctorName = doctorName;
            this.amount = amount;
            this.status = status;
            this.date = date;
        }

        public String getDoctorName() { return doctorName; }
        public double getAmount() { return amount; }
        public String getStatus() { return status; }
        public LocalDate getDate() { return date; }
    }


