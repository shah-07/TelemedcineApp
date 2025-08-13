package Imtia;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

public class ConsultNow
{
    @javafx.fxml.FXML
    private ComboBox<String> consultTypeCB;
    @javafx.fxml.FXML
    private ComboBox<String> typeOfDoctorCB;

    @javafx.fxml.FXML
    public void initialize() {
        typeOfDoctorCB.getItems().addAll(
                "General Practitioner (Cold, Fever, Flu)",
                "Dermatologist (Skin, Hair Issues)",
                "Cardiologist (Heart and Blood Vessel Diseases)"
        );
        consultTypeCB.getItems().addAll("Audio Call", "Video Call");
    }

    @javafx.fxml.FXML
    public void consultTypeOA(ActionEvent actionEvent) {
        String doctorType = typeOfDoctorCB.getValue();
        String consultationType = consultTypeCB.getValue();

        if (doctorType == null || consultationType == null) {
            showAlert("Selection Required",
                    "Please select both:\n• Type of doctor\n• Consultation method");
            return;
        }

        ConsultNowModel consultation = new ConsultNowModel(doctorType, consultationType);

        showAlert("On Call",
                "You are now on a " + consultation.getConsultationType() +
                        " with a " + consultation.getDoctorType() + ".");

    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}