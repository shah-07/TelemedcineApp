package Poran.LabTechnician;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LabTechnicianDashboardController
{
    @javafx.fxml.FXML
    private ImageView doctorProfileImage;
    @javafx.fxml.FXML
    private Button dashBoardButton;
    @javafx.fxml.FXML
    private Button inventoryAndEquipmentsButton;
    @javafx.fxml.FXML
    private Button manageBookingButton;
    @javafx.fxml.FXML
    private Label haveAGreatDayLabel;
    @javafx.fxml.FXML
    private AnchorPane dashBoardAnchorPane;
    @javafx.fxml.FXML
    private AnchorPane anchorPaneForPartialWindow;
    @javafx.fxml.FXML
    private Button completedLabTestsButton;
    @javafx.fxml.FXML
    private Label welcomeLabel;
    @javafx.fxml.FXML
    private Button logOutButton;
    @javafx.fxml.FXML
    private Button labTestRequestButton;
    @javafx.fxml.FXML
    private Label technicianNameLabel;
    @javafx.fxml.FXML
    private Button uploadReportsButton;
    @javafx.fxml.FXML
    private Button generateReportButton;
    @javafx.fxml.FXML
    private Button reportIssueButton;
    @javafx.fxml.FXML
    private Label technicianPositionLabel;

    @javafx.fxml.FXML
    public void initialize() {

        setupHoverEffect(dashBoardButton);
        setupHoverEffect(labTestRequestButton);
        setupHoverEffect(uploadReportsButton);
        setupHoverEffect(generateReportButton);
        setupHoverEffect(reportIssueButton);
        setupHoverEffect(completedLabTestsButton);
        setupHoverEffect(inventoryAndEquipmentsButton);
        setupHoverEffect(manageBookingButton);
        setupHoverEffect(logOutButton);

    }

    private void setupHoverEffect(Button button) {
        if (button == null) return; // in case any button wasn't properly injected

        button.setStyle("-fx-background-color: transparent; -fx-text-fill: black;");

        button.setOnMouseEntered(e ->
                button.setStyle("-fx-background-color: transparent; -fx-text-fill: grey;")
        );

        button.setOnMouseExited(e ->
                button.setStyle("-fx-background-color: transparent; -fx-text-fill: black;")
        );
    }


    public void setTechnicianNameAndPosition (String str, String str2){
        technicianNameLabel.setText(str);
        technicianPositionLabel.setText(str2);
    }

    @javafx.fxml.FXML
    public void reportIssueButtonOA(ActionEvent actionEvent) throws IOException {

        Node node = FXMLLoader.load(getClass().getResource("/Poran/LabTechnician/reportIssueView.fxml"));
        anchorPaneForPartialWindow.getChildren().setAll(node);

    }

    @javafx.fxml.FXML
    public void completedLabTestsButtonOA(ActionEvent actionEvent) throws IOException{

        Node node = FXMLLoader.load(getClass().getResource("/Poran/LabTechnician/completedTestTypeView.fxml"));
        anchorPaneForPartialWindow.getChildren().setAll(node);

    }

    @javafx.fxml.FXML
    public void generateReportButtonOA(ActionEvent actionEvent) throws IOException{

        Node node = FXMLLoader.load(getClass().getResource("/Poran/LabTechnician/generateReportView.fxml"));
        anchorPaneForPartialWindow.getChildren().setAll(node);

    }

    @javafx.fxml.FXML
    public void dashBoardButtonOA(ActionEvent actionEvent) {

        anchorPaneForPartialWindow.getChildren().setAll(welcomeLabel, haveAGreatDayLabel);

    }

    @javafx.fxml.FXML
    public void inventoryAndEquipmentsButtonOA(ActionEvent actionEvent) throws IOException{

        Node node = FXMLLoader.load(getClass().getResource("/Poran/LabTechnician/inventoryAndEquipmentView.fxml"));
        anchorPaneForPartialWindow.getChildren().setAll(node);

    }

    @javafx.fxml.FXML
    public void manageBookingButtonOA(ActionEvent actionEvent) throws IOException{

        Node node = FXMLLoader.load(getClass().getResource("/Poran/LabTechnician/manageBookingView.fxml"));
        anchorPaneForPartialWindow.getChildren().setAll(node);

    }

    @javafx.fxml.FXML
    public void uploadReportsButtonOA(ActionEvent actionEvent) throws IOException{

        Node node = FXMLLoader.load(getClass().getResource("/Poran/LabTechnician/uploadReportsView.fxml"));
        anchorPaneForPartialWindow.getChildren().setAll(node);

    }

    @javafx.fxml.FXML
    public void labTestRequestButtonOA(ActionEvent actionEvent) throws IOException{

        Node node = FXMLLoader.load(getClass().getResource("/Poran/LabTechnician/labTestRequestView.fxml"));
        anchorPaneForPartialWindow.getChildren().setAll(node);

    }

    @javafx.fxml.FXML
    public void logOutButtonOA(ActionEvent actionEvent) throws IOException{

        Node node = FXMLLoader.load(getClass().getResource("/mainpackage/telemedicineapp/loginView.fxml"));
        dashBoardAnchorPane.getChildren().setAll(node);

    }
}