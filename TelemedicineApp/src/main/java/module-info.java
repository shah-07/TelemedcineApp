module mainpackage.telemedicineapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens mainpackage.telemedicineapp to javafx.fxml;
    exports mainpackage.telemedicineapp;
    exports Poran_2420181;
    opens Poran_2420181 to javafx.fxml;
}