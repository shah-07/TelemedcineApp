package Imtia;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PharmacistShareUpdateToDoctorController
{
    @javafx.fxml.FXML
    private TextField notesTF;
    @javafx.fxml.FXML
    private TextField doctorNameTF;
    @javafx.fxml.FXML
    private Label alertL;

    @javafx.fxml.FXML
    public void initialize() {
        alertL.setText("");
    }

    @javafx.fxml.FXML
    public void sendOA(ActionEvent actionEvent) {
        String doctorName = doctorNameTF.getText();
        String notes = notesTF.getText();


        PharmacistShareUpdateToDoctorModel update = new PharmacistShareUpdateToDoctorModel(doctorName, notes);


        alertL.setText("Update sent to Dr. " + update.getDoctorName());
    }
}