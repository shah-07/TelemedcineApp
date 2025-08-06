module mainpackage.telemedicineapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens mainpackage.telemedicineapp to javafx.fxml;
    exports mainpackage.telemedicineapp;
    exports Imtia;
    opens Imtia to javafx.fxml;
    exports Poran.Doctor;
    opens Poran.Doctor to javafx.fxml;
    exports Poran.LabTechnician;
    opens Poran.LabTechnician to javafx.fxml;
}