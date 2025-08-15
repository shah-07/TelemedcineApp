package Tasfia;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class GuestUserDashboardController {

    @javafx.fxml.FXML
    private Button searchDoctorButton;
    @javafx.fxml.FXML
    private ImageView doctorProfileImage;
    @javafx.fxml.FXML
    private Label welcomeLabel;
    @javafx.fxml.FXML
    private Button faqButton;
    @javafx.fxml.FXML
    private Button symptomsCheckButton;
    @javafx.fxml.FXML
    private Button dashBoardButton;
    @javafx.fxml.FXML
    private Button shareThisAppButton;
    @javafx.fxml.FXML
    private Button servicesButton;
    @javafx.fxml.FXML
    private Button privacyPolicyButton;
    @javafx.fxml.FXML
    private Button consultationFessButton; // spelling matches your FXML
    @javafx.fxml.FXML
    private Button doctorListButton;

    @javafx.fxml.FXML
    public void initialize() {
        welcomeLabel.setText("Welcome, Guest!");
    }

    private void loadScene(String fxmlFile, ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void shareThisAppButtonOnAction(ActionEvent actionEvent) {
        System.out.println("Share link copied!");
        // You can implement sharing logic here (like copying link to clipboard)
    }

    @javafx.fxml.FXML
    public void symptomsCheckButtonOnAction(ActionEvent actionEvent) {
        loadScene("SymptomsCheck.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void searchDoctorButtonOnAction(ActionEvent actionEvent) {
        loadScene("SearchDoctor.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void faqButtonOnAction(ActionEvent actionEvent) {
        loadScene("FAQ.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void consultationFeesButtonOnAction(ActionEvent actionEvent) {
        loadScene("ConsultationFees.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void privacyPolicyButtonOnAction(ActionEvent actionEvent) {
        loadScene("PrivacyPolicy.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void servicesButtonOnAction(ActionEvent actionEvent) {
        loadScene("Services.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void dashBoardButtonOnAction(ActionEvent actionEvent) {
        loadScene("GuestDashboard.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void doctorListButtonOnAction(ActionEvent actionEvent) {
        loadScene("DoctorList.fxml", actionEvent);
    }
}
