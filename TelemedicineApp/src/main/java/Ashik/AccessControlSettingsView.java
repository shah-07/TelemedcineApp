package Ashik;

import java.io.Serializable;

public class AccessControlSettingsView implements Serializable {
    private String role;
    private boolean canViewReport;
    private boolean canAccessPatientInformation;
    private boolean canUseSymptomChecker;
    private boolean canEditReport;
    private boolean canViewPrescription;
    private boolean others;

    public AccessControlSettingsView(String role, boolean canViewReport, boolean canAccessPatientInformation,
                                     boolean canUseSymptomChecker, boolean canEditReport,
                                     boolean canViewPrescription, boolean others) {
        this.role = role;
        this.canViewReport = canViewReport;
        this.canAccessPatientInformation = canAccessPatientInformation;
        this.canUseSymptomChecker = canUseSymptomChecker;
        this.canEditReport = canEditReport;
        this.canViewPrescription = canViewPrescription;
        this.others = others;
    }

    // Getters and setters
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public boolean isCanViewReport() { return canViewReport; }
    public void setCanViewReport(boolean canViewReport) { this.canViewReport = canViewReport; }

    public boolean isCanAccessPatientInformation() { return canAccessPatientInformation; }
    public void setCanAccessPatientInformation(boolean canAccessPatientInformation) { this.canAccessPatientInformation = canAccessPatientInformation; }

    public boolean isCanUseSymptomChecker() { return canUseSymptomChecker; }
    public void setCanUseSymptomChecker(boolean canUseSymptomChecker) { this.canUseSymptomChecker = canUseSymptomChecker; }

    public boolean isCanEditReport() { return canEditReport; }
    public void setCanEditReport(boolean canEditReport) { this.canEditReport = canEditReport; }

    public boolean isCanViewPrescription() { return canViewPrescription; }
    public void setCanViewPrescription(boolean canViewPrescription) { this.canViewPrescription = canViewPrescription; }

    public boolean isOthers() { return others; }
    public void setOthers(boolean others) { this.others = others; }
}
