package Imtia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PharmacistGetPaymentController
{
    @javafx.fxml.FXML
    private TextField textTF;
    @javafx.fxml.FXML
    private TableColumn<PharmacistGetPaymentModel,String> patientNameTC;
    @javafx.fxml.FXML
    private TableColumn<PharmacistGetPaymentModel,Double> pendingAmountTC;
    @javafx.fxml.FXML
    private TableView<PharmacistGetPaymentModel> pendingBillTV;
    @javafx.fxml.FXML
    private Label alertL;

    private ObservableList<PharmacistGetPaymentModel> billList;

    @javafx.fxml.FXML
    public void initialize() {
        patientNameTC.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        pendingAmountTC.setCellValueFactory(new PropertyValueFactory<>("pendingAmount"));


        billList = FXCollections.observableArrayList(
                new PharmacistGetPaymentModel("Nisha", 500.0, false),
                new PharmacistGetPaymentModel("Imtia", 0.0, true),
                new PharmacistGetPaymentModel("Amir", 250.0, false)
        );

        pendingBillTV.setItems(billList);
        alertL.setText("");
    }

    @javafx.fxml.FXML
    public void sendOA(ActionEvent actionEvent) {
        PharmacistGetPaymentModel selected = pendingBillTV.getSelectionModel().getSelectedItem();

        if (selected != null) {
            if (!selected.isPaid()) {
                alertL.setText("Not paid yet: " + selected.getPatientName());
            } else {
                alertL.setText("Payment received from: " + selected.getPatientName());
            }
        } else {
            alertL.setText("Please select a patient from the table.");
        }
    }
}