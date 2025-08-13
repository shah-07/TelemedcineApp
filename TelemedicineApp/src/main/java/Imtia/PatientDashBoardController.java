package Imtia;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;


public class PatientDashBoardController
{
    @javafx.fxml.FXML
    private Label idL;
    @javafx.fxml.FXML
    private Label nameL;
    @javafx.fxml.FXML
    private AnchorPane dashBoardAnchorPane;
    @javafx.fxml.FXML
    private AnchorPane anchorPaneForPartialWindows;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void bookTextButtonOA(ActionEvent actionEvent) throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("/Imtia/PatientBookTest.fxml"));
        anchorPaneForPartialWindows.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void getLatestButtonOA(ActionEvent actionEvent) throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("/Imtia/PatientHealthCampaignInfo.fxml"));
        anchorPaneForPartialWindows.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void completedConsultationButtonOA(ActionEvent actionEvent) throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("/Imtia/CompletedConsultation.fxml"));
        anchorPaneForPartialWindows.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void consultNowButtonOA(ActionEvent actionEvent) throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("/Imtia/ConsultNow.fxml"));
        anchorPaneForPartialWindows.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void orderMedicineButtonOA(ActionEvent actionEvent) throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("/Imtia/PatientOrderMedicine.fxml"));
        anchorPaneForPartialWindows.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void viewDoctorButtonOA(ActionEvent actionEvent) throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("/Imtia/PatientCreateAppointment .fxml"));
        anchorPaneForPartialWindows.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void faqButtonOA(ActionEvent actionEvent) throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("/Imtia/PatientFAQ.fxml"));
        anchorPaneForPartialWindows.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void paymentButtonOA(ActionEvent actionEvent) throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("/Imtia/PatientPayBill.fxml"));
        anchorPaneForPartialWindows.getChildren().setAll(node);
    }
}