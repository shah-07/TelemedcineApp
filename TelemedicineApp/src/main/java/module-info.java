module mainpackage.telemedicineapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens mainpackage.telemedicineapp to javafx.fxml;
    exports mainpackage.telemedicineapp;
    exports poran_2420181;
    opens poran_2420181 to javafx.fxml;
}