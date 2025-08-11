package Imtia;

public class PatientPayBillModel {
    private String billId,pendingbillName;
    private double amount;
    private String paymentmethod;

    public PatientPayBillModel(String billId, String pendingbillName, double amount, String paymentmethod) {
        this.billId = billId;
        this.pendingbillName = pendingbillName;
        this.amount = amount;
        this.paymentmethod = paymentmethod;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
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
                "billId='" + billId + '\'' +
                ", pendingbillName='" + pendingbillName + '\'' +
                ", amount=" + amount +
                ", paymentmethod='" + paymentmethod + '\'' +
                '}';
    }
}