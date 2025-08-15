package Ashik;

import java.time.LocalDate;

public class TrackSystemUptimeAndMajorIssues {
    private LocalDate date;
    private String issueSummary;
    private String details;

    // Constructor
    public TrackSystemUptimeAndMajorIssues(LocalDate date, String issueSummary, String details) {
        this.date = date;
        this.issueSummary = issueSummary;
        this.details = details;
    }

    // Getters and Setters
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getIssueSummary() {
        return issueSummary;
    }

    public void setIssueSummary(String issueSummary) {
        this.issueSummary = issueSummary;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
