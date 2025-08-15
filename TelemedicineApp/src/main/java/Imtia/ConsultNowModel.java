package Imtia;

public class ConsultNowModel {
    private String doctorType;
    private String consultationType;

    public ConsultNowModel(String doctorType, String consultationType) {
        this.doctorType = doctorType;
        this.consultationType = consultationType;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public String getConsultationType() {
        return consultationType;
    }

    public void setConsultationType(String consultationType) {
        this.consultationType = consultationType;
    }
}
