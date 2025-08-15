package Ashik;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProfileCreateForUserViewController {

    @FXML
    private Label successfulLabel;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private ComboBox<String> roleComboBox;
    @FXML
    private TableColumn<ProfileCreateForUserView, Double> feesCol;
    @FXML
    private TextField liscenceTextField;
    @FXML
    private TextField numberTextField;
    @FXML
    private TextField feesTextField;
    @FXML
    private TableColumn<ProfileCreateForUserView, String> nameCol;
    @FXML
    private TableColumn<ProfileCreateForUserView, String> emailCol;
    @FXML
    private ComboBox<String> specialistComboBox;
    @FXML
    private TableColumn<ProfileCreateForUserView, String> roleCol;
    @FXML
    private TableColumn<ProfileCreateForUserView, String> specialistCol;
    @FXML
    private TableView<ProfileCreateForUserView> createProfileforUserTableView;
    @FXML
    private ComboBox<String> statusComboBox;

    private ObservableList<ProfileCreateForUserView> pendingRequests;
    private TableColumn<Object, Object> statusCol;

    @FXML
    public void initialize() {
        // Table column setup
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        roleCol.setCellValueFactory(new PropertyValueFactory<>("role"));
        specialistCol.setCellValueFactory(new PropertyValueFactory<>("specialist"));
        feesCol.setCellValueFactory(new PropertyValueFactory<>("fees"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Role and specialist options
        roleComboBox.getItems().addAll("Doctor", "Pharmacist", "Lab Technician");
        specialistComboBox.getItems().addAll("Cardiologist", "Dermatologist", "Pathologist");

        // Status options
        statusComboBox.getItems().addAll("Pending", "Approved", "Rejected");
        statusComboBox.setValue("Pending");

        // Dummy data
        pendingRequests = FXCollections.observableArrayList(
                new ProfileCreateForUserView ( "Dr. John", "john@mail.com", "Doctor", "Cardiologist", 500, "Pending"),
                new ProfileCreateForUserView("Alex", "alex@mail.com", "Pharmacist", null, 0, "Pending")
        );
        createProfileforUserTableView.setItems(pendingRequests);
    }

    @FXML
    public void createProfileButtonOnAction(ActionEvent actionEvent) {
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String role = roleComboBox.getValue();
        String specialist = specialistComboBox.getValue();
        String status = statusComboBox.getValue();
        double fees = 0;

        if (name.isEmpty() || email.isEmpty() || role == null || status == null) {
            successfulLabel.setText("Please fill all required fields");
            return;
        }

        if ("Doctor".equals(role)) {
            if (specialist == null || liscenceTextField.getText().isEmpty() || numberTextField.getText().isEmpty()) {
                successfulLabel.setText("Please provide all doctor details");
                return;
            }
            try {
                fees = Double.parseDouble(feesTextField.getText());
            } catch (NumberFormatException e) {
                successfulLabel.setText("Invalid fees value");
                return;
            }
        }

        ProfileCreateForUserView newProfile =
                new ProfileCreateForUserView(name, email, role, specialist, (int) fees, status);
        pendingRequests.add(newProfile);
        createProfileforUserTableView.refresh();
        successfulLabel.setText("Profile request created successfully for " + role);
    }

    @Deprecated
    public void approveUser(ActionEvent actionEvent) {
        ProfileCreateForUserView selected = createProfileforUserTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            successfulLabel.setText("Select a user to approve");
            return;
        }
        selected.setStatus("Approved");
        createProfileforUserTableView.refresh();
        successfulLabel.setText("User approved successfully");
    }

    @Deprecated
    public void rejectUser(ActionEvent actionEvent) {
        ProfileCreateForUserView selected = createProfileforUserTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            successfulLabel.setText("Select a user to reject");
            return;
        }
        selected.setStatus("Rejected");
        createProfileforUserTableView.refresh();
        successfulLabel.setText("User rejected successfully");
    }
}
