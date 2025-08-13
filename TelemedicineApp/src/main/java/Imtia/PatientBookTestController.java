package Imtia;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class PatientBookTestController {
    @javafx.fxml.FXML
    private ComboBox<String> selectTimeSlotCB;
    @javafx.fxml.FXML
    private ComboBox<String> testTypeCB;
    @javafx.fxml.FXML
    private Label alertL;

    @javafx.fxml.FXML
    public void initialize() {
        testTypeCB.getItems().addAll("CBC Test", "Blood Sugar Test", "Lipid Profile Test", "Liver Function Test", "Kidney Function Test", "Thyroid Test");


        selectTimeSlotCB.getItems().addAll("10:00 AM", "11:00 AM", "12:00 PM", "1:00 PM", "2:00 PM");
    }

    @javafx.fxml.FXML
    public void confirmOA(ActionEvent actionEvent) {
        String selectedTestType = testTypeCB.getValue();
        String selectedTimeSlot = selectTimeSlotCB.getValue();
        // Validate selections
        if (selectedTestType == null || selectedTimeSlot == null) {
            showAlert("Error", "Please select both test type and time slot");
            return;
        }

        PatientBookTestModel booking = new PatientBookTestModel(selectedTestType, selectedTimeSlot);

        showAlert("Success", "Booking confirmed for " +
                booking.getTestType() + " at " + booking.getTimeSlot());
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    }

