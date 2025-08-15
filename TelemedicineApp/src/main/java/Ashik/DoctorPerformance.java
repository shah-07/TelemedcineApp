package Ashik;

import java.io.Serializable;

public class DoctorPerformance implements Serializable {
    private String doctorName;
    private double avgRating;
    private int feedbackCount;
    private int consultationCount;

    public DoctorPerformance(String doctorName, double avgRating, int feedbackCount, int consultationCount) {
        this.doctorName = doctorName;
        this.avgRating = avgRating;
        this.feedbackCount = feedbackCount;
        this.consultationCount = consultationCount;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public int getFeedbackCount() {
        return feedbackCount;
    }

    public void setFeedbackCount(int feedbackCount) {
        this.feedbackCount = feedbackCount;
    }

    public int getConsultationCount() {
        return consultationCount;
    }

    public void setConsultationCount(int consultationCount) {
        this.consultationCount = consultationCount;
    }
}
