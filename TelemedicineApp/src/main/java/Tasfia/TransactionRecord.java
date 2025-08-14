package Tasfia;

import java.time.LocalDate;

    public class TransactionRecord {
        private String id;
        private String type;
        private double amount;
        private LocalDate date;

        public TransactionRecord(String id, String type, double amount, LocalDate date) {
            this.id = id;
            this.type = type;
            this.amount = amount;
            this.date = date;
        }

        public String getId() { return id; }
        public String getType() { return type; }
        public double getAmount() { return amount; }
        public LocalDate getDate() { return date; }
    }



