module mainpackage.telemedicineapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens mainpackage.telemedicineapp to javafx.fxml;
    exports mainpackage.telemedicineapp;
    exports Poran;
    opens Poran to javafx.fxml;
    exports Imtia;
    opens Imtia to javafx.fxml;
}