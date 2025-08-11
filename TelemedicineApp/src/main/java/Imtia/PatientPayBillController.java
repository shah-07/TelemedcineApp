package Imtia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class PatientPayBillController
{
    @javafx.fxml.FXML
    private TableColumn<PatientPayBillModel,Double> amountTC;
    @javafx.fxml.FXML
    private ComboBox<String> paymentMethodCB;
    @javafx.fxml.FXML
    private TextField amountTF;
    @javafx.fxml.FXML
    private TableColumn<PatientPayBillModel,String> pendingbillTC;
    @javafx.fxml.FXML
    private TableView<PatientPayBillModel> paybillTV;

    ArrayList<PatientPayBillModel> payBillModels = new ArrayList<>();
    @javafx.fxml.FXML
    private Label confirmL;

    @javafx.fxml.FXML
    public void initialize() {
        pendingbillTC.setCellValueFactory(new PropertyValueFactory<>("pendingbillName"));
        amountTC.setCellValueFactory(new PropertyValueFactory<>("amount"));
        loadbill();

    }
    public void loadbill(){
        payBillModels.add(new PatientPayBillModel("B001", "X-Ray",500,"Visa"));
        payBillModels.add(new PatientPayBillModel("B002", "ECG",1000,"Mastercard"));

        for (PatientPayBillModel patient : payBillModels){
            paymentMethodCB.getItems().add(patient.getPaymentmethod());
        }
        ObservableList<PatientPayBillModel> observableList = FXCollections.observableArrayList(payBillModels);
        paybillTV.setItems(observableList);
    }

    @javafx.fxml.FXML
    public void paymentOA(ActionEvent actionEvent) {
        PatientPayBillModel selectedBill = paybillTV.getSelectionModel().getSelectedItem();
        if (selectedBill == null) {
            showAlert("Please select a bill to pay.");
            return;
        }
        String paymentMethod = paymentMethodCB.getValue();
        if (paymentMethod == null) {
            showAlert("Please select a payment method.");
            return;
        }
        double amount = selectedBill.getAmount();
        amountTF.setText(String.valueOf(amount));
        showAlert("Payment of " + amount + " using " + paymentMethod + " was successful.");

    }
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Payment Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}