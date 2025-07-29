module mainpackage.telemedicineapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens mainpackage.telemedicineapp to javafx.fxml;
    exports mainpackage.telemedicineapp;
}