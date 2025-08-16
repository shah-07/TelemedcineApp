
package Tasfia;

import java.time.LocalDate;

    public class RefundRecord {
        private String patientName;
        private double amount;
        private LocalDate date;
        private String reason;
        private String status;

        public RefundRecord(String patientName, double amount, LocalDate date, String reason, String status) {
            this.patientName = patientName;
            this.amount = amount;
            this.date = date;
            this.reason = reason;
            this.status = status;
        }

        public String getPatientName() { return patientName; }
        public double getAmount() { return amount; }
        public LocalDate getDate() { return date; }
        public String getReason() { return reason; }
        public String getStatus() { return status; }

        public void setStatus(String status) { this.status = status; }
    }




