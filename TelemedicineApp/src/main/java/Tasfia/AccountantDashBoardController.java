package Tasfia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class AccountantDashBoardController {

    @FXML
    private ImageView doctorProfileImage;
    @FXML
    private Label loginSuccessLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Button paymentButton;
    @FXML
    private Button refundRequestButton;
    @FXML
    private Button transactionDataButton;
    @FXML
    private Button feeManagerButton;
    @FXML
    private Button logOutButton;
    @FXML
    private Button doctorPayoutButton;
    @FXML
    private Button generateReportButton;
    @FXML
    private Button paymentHistoryButton;
    @FXML
    private Button generateInvoiceButton;
    @FXML
    private Label welcomeLabel;

    @FXML
    public void initialize() {
        welcomeLabel.setText("Welcome, Accountant!");
        nameLabel.setText("Accountant Name");
    }

    @FXML
    public void paymentButtonOnAction(ActionEvent actionEvent) {
        System.out.println("Payment button clicked");
    }

    @FXML
    public void feeManagerButtonOnAction(ActionEvent actionEvent) {
        System.out.println("Fee Manager button clicked");
    }

    @FXML
    public void generateInvoiceButtonOnAction(ActionEvent actionEvent) {
        System.out.println("Generate Invoice button clicked");
    }

    @FXML
    public void payemtHistoryButtonOnAction(ActionEvent actionEvent) {  // spelling as you requested
        System.out.println("Payemt History button clicked");
    }

    @FXML
    public void refundRequestButtonOnAction(ActionEvent actionEvent) {
        System.out.println("Refund Request button clicked");
    }

    @FXML
    public void transactionDataButtonOnAction(ActionEvent actionEvent) {
        System.out.println("Transaction Data button clicked");
    }

    @FXML
    public void logOutButtonOnAction(ActionEvent actionEvent) {
        System.out.println("Log Out button clicked");
    }

    @FXML
    public void doctorPayoutButtonOnAction(ActionEvent actionEvent) {
        System.out.println("Doctor Payout button clicked");
    }

    @FXML
    public void generateReportButtonOnAction(ActionEvent actionEvent) {
        System.out.println("Generate Report button clicked");
    }
}
