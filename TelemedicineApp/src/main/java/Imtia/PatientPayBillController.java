package Imtia;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PatientPayBillController
{
    @javafx.fxml.FXML
    private TableColumn amountTC;
    @javafx.fxml.FXML
    private TableColumn pendingBillTC;
    @javafx.fxml.FXML
    private ComboBox paymentMethodCB;
    @javafx.fxml.FXML
    private TextField amountTF;
    @javafx.fxml.FXML
    private TableView paymentTV;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void paymentOA(ActionEvent actionEvent) {
    }
}