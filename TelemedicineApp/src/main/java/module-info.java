module mainpackage.telemedicineapp {
    requires javafx.controls;
    requires javafx.fxml;
<<<<<<< HEAD
    requires jnanoid;
    requires org.apache.commons.lang3;
    requires java.desktop;
    requires kernel;
    requires layout;
=======
    requires jdk.httpserver;
>>>>>>> c99d00133ec932a0543d5f0e074a68e4c0d066a8


    opens mainpackage.telemedicineapp to javafx.fxml;
    exports mainpackage.telemedicineapp;
    exports Imtia;
    opens Imtia to javafx.fxml;
    exports Poran.Doctor;
    opens Poran.Doctor to javafx.fxml;
    exports Poran.LabTechnician;
    opens Poran.LabTechnician to javafx.fxml;
}