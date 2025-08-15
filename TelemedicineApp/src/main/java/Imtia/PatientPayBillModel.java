package Imtia;

public class PatientPayBillModel {
    private String pendingbillName;
    private double amount;
    private String paymentmethod;

    public PatientPayBillModel(String pendingbillName, double amount, String paymentmethod) {
        this.pendingbillName = pendingbillName;
        this.amount = amount;
        this.paymentmethod = paymentmethod;
    }

    public String getPendingbillName() {
        return pendingbillName;
    }

    public void setPendingbillName(String pendingbillName) {
        this.pendingbillName = pendingbillName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    @Override
    public String toString() {
        return "PatientPayBillModel{" +
                "pendingbillName='" + pendingbillName + '\'' +
                ", amount=" + amount +
                ", paymentmethod='" + paymentmethod + '\'' +
                '}';
    }
}