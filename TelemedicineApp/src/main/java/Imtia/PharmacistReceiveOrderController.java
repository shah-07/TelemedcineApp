package Imtia;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;

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
        successL.setText("");
    }

    @Deprecated

    @javafx.fxml.FXML
    public void deliveryOrderOA(ActionEvent actionEvent) {
        String patientName = patientNameTF.getText().trim();
        String patientId = patientIdTF.getText().trim();
        String time = enterTimeTF.getText().trim();
        LocalDate date = enterDateDP.getValue() ;//!= null);

        if (patientName.isEmpty() || patientId.isEmpty() || time.isEmpty() || date==null) {
            successL.setText("Please fill all fields.");
            return;
        }

        // Simulated fetching of new orders
        String fetchedOrders = "Medicine: Paracetamol, Qty: 2\nMedicine: Aspirin, Qty: 1";

        // Display result
        successL.setText(
                "Order for " + patientName + " (ID: " + patientId + ")\n"
                        + "Date: " + date + " Time: " + time + "\n"
                        + "Orders:\n" + fetchedOrders + "\nDeliveried successfully!"
        );
    }
}
