package Ashik;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ResetUserPasswordViewController {

    @FXML
    private Label successfulLabel;
    @FXML
    private TextField newPasswordTextField;
    @FXML
    private TextField emailTextField;

    @FXML
    public void initialize() {
        successfulLabel.setText("");
    }

    @FXML
    public void resetPasswordButtonOnAction(ActionEvent actionEvent) {
        String email = emailTextField.getText().trim();
        String newPassword = newPasswordTextField.getText().trim();

        // Basic validation
        if (email.isEmpty() || newPassword.isEmpty()) {
            successfulLabel.setText("Email and new password cannot be empty.");
            return;
        }

        if (!isValidEmail(email)) {
            successfulLabel.setText("Invalid email format.");
            return;
        }

        if (newPassword.length() < 6) {
            successfulLabel.setText("Password must be at least 6 characters.");
            return;
        }

        // Simulate database update
        boolean success = updatePasswordInDatabase(email, newPassword);

        if (success) {
            successfulLabel.setText("Password reset successfully for " + email);
            sendPasswordResetNotification(email);
        } else {
            successfulLabel.setText("Failed to reset password. User not found.");
        }
    }

    // Dummy email validation
    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    private boolean updatePasswordInDatabase(String email, String newPassword) {
        return email.endsWith("@mail.com");
    }


    private void sendPasswordResetNotification(String email) {
        System.out.println("Notification sent to " + email + " about password reset.");
    }
}
