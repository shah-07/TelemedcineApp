package Imtia;

import java.time.LocalDate;

public class PharmacistReceiveOrderModel {
    private String patientName;
    private String patientId;
    private LocalDate orderDate;
    private String orderTime;

    public PharmacistReceiveOrderModel(String patientName, String patientId, LocalDate orderDate, String orderTime) {
        this.patientName = patientName;
        this.patientId = patientId;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        return "PharmacistReceiveOrderModel{" +
                "patientName='" + patientName + '\'' +
                ", patientId='" + patientId + '\'' +
                ", orderDate=" + orderDate +
                ", orderTime='" + orderTime + '\'' +
                '}';
    }
}
