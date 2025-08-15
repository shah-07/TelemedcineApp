package Poran.LabTechnician;

import java.io.Serializable;

public class Issue implements Serializable {

    private final String reporterName, token;
    private final int reporterId;
    private String urgencyLevel, description;

    public Issue(String reporterName, String token, int reporterId, String urgencyLevel, String description) {
        this.reporterName = reporterName;
        this.token = token;
        this.reporterId = reporterId;
        this.urgencyLevel = urgencyLevel;
        this.description = description;
    }

    public String getToken() {
        return token;
    }

    public String getReporterName() {
        return reporterName;
    }

    public int getReporterId() {
        return reporterId;
    }

    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
