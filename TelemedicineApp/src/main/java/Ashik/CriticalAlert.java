package Ashik;

import java.time.LocalDate;

public class CriticalAlert {
    private LocalDate date;
    private String alertType;
    private String descriptionSummary;
    private String fullDescription;

    public CriticalAlert(LocalDate date, String alertType, String descriptionSummary, String fullDescription) {
        this.date = date;
        this.alertType = alertType;
        this.descriptionSummary = descriptionSummary;
        this.fullDescription = fullDescription;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getDescriptionSummary() {
        return descriptionSummary;
    }

    public void setDescriptionSummary(String descriptionSummary) {
        this.descriptionSummary = descriptionSummary;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }
}
