package Imtia;

import java.time.LocalDate;

public class CompleteConsultationModel {
    private  String consultationId;
    private  String patientName;
    private LocalDate consultationDate;
    private  String medicineName;
    private  boolean hasPrescription;

    public CompleteConsultationModel(String consultationId, String patientName, LocalDate consultationDate, String medicineName, boolean hasPrescription) {
        this.consultationId = consultationId;
        this.patientName = patientName;
        this.consultationDate = consultationDate;
        this.medicineName = medicineName;
        this.hasPrescription = hasPrescription;
    }

    public String getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(String consultationId) {
        this.consultationId = consultationId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public LocalDate getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(LocalDate consultationDate) {
        this.consultationDate = consultationDate;
    }

    public String getPrescriptionFile() {
        return medicineName;
    }

    public void setPrescriptionFile(String medicineName) {
        this.medicineName = medicineName;
    }

    public boolean isHasPrescription() {
        return hasPrescription;
    }

    public void setHasPrescription(boolean hasPrescription) {
        this.hasPrescription = hasPrescription;
    }

    @Override
    public String toString() {
        return "ConsultationModel{" +
                "consultationId='" + consultationId + '\'' +
                ", patientName='" + patientName + '\'' +
                ", consultationDate='" + consultationDate + '\'' +
                ", medicineName='" + medicineName + '\'' +
                ", hasPrescription=" + hasPrescription +
                '}';
    }
}
