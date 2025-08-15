package Imtia;

public class PatientBookTestModel {
    private String testType;
    private String timeSlot;

    public PatientBookTestModel(String testType, String timeSlot) {
        this.testType = testType;
        this.timeSlot = timeSlot;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }
}
