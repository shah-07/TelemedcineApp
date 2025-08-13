package Imtia;

public class PharmacistGetPaymentModel {
    private String patientName;
    private double pendingAmount;
    private boolean paid;

    public PharmacistGetPaymentModel(String patientName, double pendingAmount, boolean paid) {
        this.patientName = patientName;
        this.pendingAmount = pendingAmount;
        this.paid = paid;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public double getPendingAmount() {
        return pendingAmount;
    }

    public void setPendingAmount(double pendingAmount) {
        this.pendingAmount = pendingAmount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
