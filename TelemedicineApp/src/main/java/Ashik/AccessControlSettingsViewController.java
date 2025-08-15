package Ashik;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class AccessControlSettingsViewController {

    @FXML
    private CheckBox othersCheckBox;
    @FXML
    private Label successfulLabel;
    @FXML
    private CheckBox viewReportCheckBox;
    @FXML
    private CheckBox accessPatientInformationCheckBox;
    @FXML
    private CheckBox editReportCheckBox;
    @FXML
    private CheckBox symptomCheckerCheckBox;
    @FXML
    private CheckBox viewPrescriptionCheckBox;
    @FXML
    private ComboBox<String> roleComboBox;

    @FXML
    public void initialize() {
        roleComboBox.getItems().addAll("Doctor", "Lab Technician", "Pharmacist", "Patient", "CEO", "Accountant", "Guest User");
    }

    @FXML
    public void saveChangesButtonOnAction(ActionEvent actionEvent) {
        String selectedRole = roleComboBox.getValue();
        if (selectedRole == null) {
            successfulLabel.setText("Please select a role");
            return;
        }

        AccessControlSettingsView settings = new AccessControlSettingsView(
                selectedRole,
                viewReportCheckBox.isSelected(),
                accessPatientInformationCheckBox.isSelected(),
                symptomCheckerCheckBox.isSelected(),
                editReportCheckBox.isSelected(),
                viewPrescriptionCheckBox.isSelected(),
                othersCheckBox.isSelected()
        );

        boolean success = savePermissionsToDatabase(settings);

        if (success) {
            successfulLabel.setText("Access control setting updated successfully");
        } else {
            successfulLabel.setText("Failed to update access control setting");
        }
    }

    private boolean savePermissionsToDatabase(AccessControlSettingsView settings) {
        System.out.println("Saving settings for role: " + settings.getRole());
        return true;
    }
}




