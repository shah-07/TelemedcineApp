package Tasfia;

import java.time.LocalDate;

    public class PaymentRecord {
        private String patientName;
        private double amount;
        private String status;
        private LocalDate date;

        public PaymentRecord(String patientName, double amount, String status, LocalDate date) {
            this.patientName = patientName;
            this.amount = amount;
            this.status = status;
            this.date = date;
        }

        public String getPatientName() { return patientName; }
        public double getAmount() { return amount; }
        public String getStatus() { return status; }
        public LocalDate getDate() { return date; }
    }


