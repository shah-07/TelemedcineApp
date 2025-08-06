package Poran.LabTechnician;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GenerateReportController
{
    @javafx.fxml.FXML
    private Label successMessageButtonLabel;
    @javafx.fxml.FXML
    private Label errorMessageButtonLabel;
    @javafx.fxml.FXML
    private DatePicker chooseDateDP;
    @javafx.fxml.FXML
    private TextField toTimeTF;
    @javafx.fxml.FXML
    private TextField fromTimeTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void exportAsPDFButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadReportButtonOA(ActionEvent actionEvent) {
    }
}