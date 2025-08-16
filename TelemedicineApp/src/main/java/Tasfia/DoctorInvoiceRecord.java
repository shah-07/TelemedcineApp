

package Tasfia;

import java.time.LocalDate;

    public class DoctorInvoiceRecord {
        private String doctorName;
        private LocalDate date;
        private double amount;

        public DoctorInvoiceRecord(String doctorName, LocalDate date, double amount) {
            this.doctorName = doctorName;
            this.date = date;
            this.amount = amount;
        }

        public String getDoctorName() { return doctorName; }
        public LocalDate getDate() { return date; }
        public double getAmount() { return amount; }
    }



