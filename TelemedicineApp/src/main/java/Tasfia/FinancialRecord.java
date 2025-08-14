package Tasfia;

public class FinancialRecord {

        private String date;
        private double totalIncome;
        private double payout;
        private double refund;

    public FinancialRecord(String date, double totalIncome, double payout, double refund) {
        this.date = date;
        this.totalIncome = totalIncome;
        this.payout = payout;
        this.refund = refund;
    }

    public String getDate() {
        return date;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public double getPayout() {
        return payout;
    }

    public double getRefund() {
        return refund;
    }
}
