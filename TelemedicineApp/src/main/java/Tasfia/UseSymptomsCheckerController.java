package Tasfia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;
import java.util.List;

public class UseSymptomsCheckerController {

    @FXML
    private CheckBox painCheckBox;

    @FXML
    private CheckBox coughCheckBox;

    @FXML
    private CheckBox feverCheckBox;

    @FXML
    public void initialize() {
        // Optional initialization
    }

    @FXML
    public void checkButtonOnAction(ActionEvent actionEvent) {
        List<String> selectedSymptoms = new ArrayList<>();

        if (painCheckBox.isSelected()) selectedSymptoms.add("Pain");
        if (coughCheckBox.isSelected()) selectedSymptoms.add("Cough");
        if (feverCheckBox.isSelected()) selectedSymptoms.add("Fever");

        String message;
        if (selectedSymptoms.isEmpty()) {
            message = "No symptoms selected.";
        } else {
            message = "You have selected: " + String.join(", ", selectedSymptoms);
        }

        // Show alert with selected symptoms
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Symptoms Checked");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void findDoctorButtonOnAction(ActionEvent actionEvent) {
        List<String> selectedSymptoms = new ArrayList<>();

        if (painCheckBox.isSelected()) selectedSymptoms.add("Pain");
        if (coughCheckBox.isSelected()) selectedSymptoms.add("Cough");
        if (feverCheckBox.isSelected()) selectedSymptoms.add("Fever");

        // Suggest doctors based on symptoms (simple example)
        String doctorSuggestion;
        if (selectedSymptoms.contains("Cough") || selectedSymptoms.contains("Fever")) {
            doctorSuggestion = "Consult a General Physician or ENT specialist.";
        } else if (selectedSymptoms.contains("Pain")) {
            doctorSuggestion = "Consult an Orthopedic or Pain Specialist.";
        } else {
            doctorSuggestion = "No specific doctor required. Stay healthy!";
        }

        // Show alert with doctor suggestion
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Doctor Suggestion");
        alert.setHeaderText(null);
        alert.setContentText(doctorSuggestion);
        alert.showAndWait();
    }
}
