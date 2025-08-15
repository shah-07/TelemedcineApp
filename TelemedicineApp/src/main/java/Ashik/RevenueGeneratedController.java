package Ashik;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RevenueGeneratedController {

    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextArea revenueSummaryTA;
    @FXML
    private TextField viewRevenueFromConsultationTextField;

    private RevenueGenerated revenueGenerated;

    @FXML
    public void initialize() {
        revenueSummaryTA.setEditable(false);
        viewRevenueFromConsultationTextField.setEditable(false);
    }

    @FXML
    public void loginButtonOnAction(ActionEvent actionEvent) {
        String username = usernameTextField.getText().trim();
        String password = passwordTextField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            revenueSummaryTA.setText("Please enter username and password.");
            return;
        }

        if (!authenticateCEO(username, password)) {
            revenueSummaryTA.setText("Invalid username or password.");
            return;
        }

        revenueSummaryTA.setText("Login successful! You can now view revenue.");
    }

    @FXML
    public void viewRevenueButtonOnAction(ActionEvent actionEvent) {
        if (!isLoggedIn()) {
            revenueSummaryTA.setText("Please login first.");
            return;
        }

        double totalRevenue = calculateTotalRevenue();
        revenueGenerated = new RevenueGenerated(usernameTextField.getText(), passwordTextField.getText(), totalRevenue);

        viewRevenueFromConsultationTextField.setText(String.format("%.2f", totalRevenue));
        revenueSummaryTA.setText("Total revenue generated from consultations: $" + totalRevenue + "\nGraph representation can be shown here.");
    }

    // Dummy CEO authentication
    private boolean authenticateCEO(String username, String password) {
        // In real app, validate from DB
        return username.equals("ceo") && password.equals("ceo123");
    }

    // Dummy login check
    private boolean isLoggedIn() {
        return usernameTextField.getText().equals("ceo") && passwordTextField.getText().equals("ceo123");
    }

    // Dummy revenue calculation
    private double calculateTotalRevenue() {
        // In real app, fetch from DB and sum fees
        return 12500.75; // Example revenue
    }
}
