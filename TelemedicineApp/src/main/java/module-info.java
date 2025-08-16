module mainpackage.telemedicineapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires jnanoid;
    requires org.apache.commons.lang3;
    requires java.desktop;
    requires kernel;
    requires layout;
    requires jdk.httpserver;

    opens mainpackage.telemedicineapp to javafx.fxml;
    exports mainpackage.telemedicineapp;
    exports Imtia;
    opens Imtia to javafx.fxml;
    exports Poran.Doctor;
    opens Poran.Doctor to javafx.fxml;
    exports Poran.LabTechnician;
    opens Poran.LabTechnician to javafx.fxml;
}