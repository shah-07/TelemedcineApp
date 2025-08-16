package Tasfia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class ShareAppLinkController {

    @FXML
    private ComboBox<String> sharingMethodComboBox;

    @FXML
    private TextField displayAppLinkTextField;

    @FXML
    public void initialize() {
        // Set default app link
        displayAppLinkTextField.setText("https://www.telemedicineapp.com/download");

        // Setup sharing methods
        sharingMethodComboBox.getItems().addAll("Email", "WhatsApp", "Facebook", "Twitter");
        sharingMethodComboBox.getSelectionModel().selectFirst();
    }

    @FXML
    public void shareNowButtonOnAction(ActionEvent actionEvent) {
        String method = sharingMethodComboBox.getSelectionModel().getSelectedItem();
        String link = displayAppLinkTextField.getText();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Share App Link");
        alert.setHeaderText(null);
        alert.setContentText("App link \"" + link + "\" shared via " + method + "!");
        alert.showAndWait();
    }

    @FXML
    public void copyLinkButtonOnAction(ActionEvent actionEvent) {
        String link = displayAppLinkTextField.getText();

        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(link);
        clipboard.setContent(content);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Copy Link");
        alert.setHeaderText(null);
        alert.setContentText("App link copied to clipboard!");
        alert.showAndWait();
    }
}
