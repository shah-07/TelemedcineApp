package Tasfia;

import java.time.LocalDate;

    public class PaymentHistoryRecord {
        private int patientId;
        private String patientName;
        private double amount;
        private String status;
        private LocalDate date;

        public PaymentHistoryRecord(int patientId, String patientName, double amount, String status, LocalDate date) {
            this.patientId = patientId;
            this.patientName = patientName;
            this.amount = amount;
            this.status = status;
            this.date = date;
        }

        public int getPatientId() { return patientId; }
        public String getPatientName() { return patientName; }
        public double getAmount() { return amount; }
        public String getStatus() { return status; }
        public LocalDate getDate() { return date; }
    }


