package Tasfia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DoctorFeeStructureController {

    @FXML
    private TextArea confirmationPreviewTextArea;
    @FXML
    private TextField doctorNameTextField;
    @FXML
    private Label feeUpdatedSuccessfullyLabel;
    @FXML
    private TextField newFeeAmountTextField;

    private String doctorName;
    private double doctorFee;

    @FXML
    public void initialize() {
        feeUpdatedSuccessfullyLabel.setVisible(false); // Label hidden at start
    }

    @FXML
    public void updateButtonOnAction(ActionEvent actionEvent) {
        String name = doctorNameTextField.getText().trim();
        String feeText = newFeeAmountTextField.getText().trim();

        if (name.isEmpty() || feeText.isEmpty()) {
            confirmationPreviewTextArea.setText("Please enter doctor name and fee!");
            return;
        }

        try {
            double fee = Double.parseDouble(feeText);

            doctorName = name;
            doctorFee = fee;

            confirmationPreviewTextArea.setText("Preview:\nDoctor: " + doctorName + "\nFee: " + doctorFee + " BDT");
            feeUpdatedSuccessfullyLabel.setVisible(false); // Hide success message until confirmed

        } catch (NumberFormatException e) {
            confirmationPreviewTextArea.setText("Invalid fee amount! Please enter a number.");
        }
    }

    @FXML
    public void confirmFeeAndDoctorButtonOnAction(ActionEvent actionEvent) {
        if (doctorName != null && !doctorName.isEmpty()) {
            feeUpdatedSuccessfullyLabel.setText("Fee updated successfully for " + doctorName);
            feeUpdatedSuccessfullyLabel.setVisible(true);

            // Optionally clear fields
            doctorNameTextField.clear();
            newFeeAmountTextField.clear();
            confirmationPreviewTextArea.clear();
        } else {
            confirmationPreviewTextArea.setText("Please update doctor info before confirming!");
        }
    }
}


