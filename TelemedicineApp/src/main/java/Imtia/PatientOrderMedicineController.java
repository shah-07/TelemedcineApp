package Imtia;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PatientOrderMedicineController {
    @javafx.fxml.FXML
    private TextField inputMedicineNameTF;
    @javafx.fxml.FXML
    private TextField addressTF;
    @javafx.fxml.FXML
    private TextField phoneNumberTF;
    @javafx.fxml.FXML
    private Label alertL;

    @javafx.fxml.FXML
    public void initialize() {
    }


    @javafx.fxml.FXML
    public void oderOA(ActionEvent actionEvent) {
        String medicine = inputMedicineNameTF.getText();
        String address = addressTF.getText();
        String phone = phoneNumberTF.getText();
        if(medicine.isEmpty() || address.isEmpty() || phone.isEmpty()) {
            showAlert("Error", "Please fill all fields");
            return;
        }

        showAlert("Success", "Order placed for: " + medicine);


        inputMedicineNameTF.clear();
        addressTF.clear();
        phoneNumberTF.clear();
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    }
