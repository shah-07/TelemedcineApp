package Tasfia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class GetPrivacyInfoController {

    @FXML
    private TextArea privacyDocTextArea;

    // Sample privacy policy text
    private final String privacyPolicyText = "Privacy Policy:\n\n" +
            "1. We value your privacy and do not share your personal information.\n" +
            "2. All user data is securely stored and encrypted.\n" +
            "3. Transactions and medical records are confidential.\n" +
            "4. You have the right to request data deletion at any time.\n" +
            "5. For more details, contact support@telemedicineapp.com.";

    @FXML
    public void initialize() {
        // Optional: show a default message
        privacyDocTextArea.setText("Click the 'Privacy Policy' button to view details.");
    }

    @FXML
    public void privacyPolicyButtonOnAction(ActionEvent actionEvent) {
        // Display the privacy policy in the TextArea
        privacyDocTextArea.setText(privacyPolicyText);
    }
}
