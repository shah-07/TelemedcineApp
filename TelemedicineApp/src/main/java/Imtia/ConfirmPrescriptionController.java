package Imtia;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ConfirmPrescriptionController
{
    @javafx.fxml.FXML
    private TableColumn timeTC;
    @javafx.fxml.FXML
    private TableColumn orderTC;
    @javafx.fxml.FXML
    private TextField timeTF;
    @javafx.fxml.FXML
    private DatePicker dateDP;
    @javafx.fxml.FXML
    private TableColumn dateTC;
    @javafx.fxml.FXML
    private TableView confirmPrescriptionTV;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void confirmOA(ActionEvent actionEvent) {
    }
}