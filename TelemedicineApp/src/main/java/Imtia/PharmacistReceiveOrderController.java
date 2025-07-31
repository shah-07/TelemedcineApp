package Imtia;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PharmacistReceiveOrderController
{
    @javafx.fxml.FXML
    private TextField patientNameTF;
    @javafx.fxml.FXML
    private Label successL;
    @javafx.fxml.FXML
    private DatePicker enterDateDP;
    @javafx.fxml.FXML
    private TextField enterTimeTF;
    @javafx.fxml.FXML
    private TextField patientIdTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void takeOrderOA(ActionEvent actionEvent) {
    }
}