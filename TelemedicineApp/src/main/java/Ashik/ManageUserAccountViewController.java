package Ashik;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManageUserAccountViewController {

    @FXML
    private TableColumn<ManageUserAccountView, Integer> idCol;
    @FXML
    private TableView<ManageUserAccountView> userManagementTableView;
    @FXML
    private TableColumn<ManageUserAccountView, Boolean> statusCol;
    @FXML
    private TableColumn<ManageUserAccountView, String> nameCol;
    @FXML
    private Label statusMessageLabel;

    private ObservableList <ManageUserAccountView> userList;

    @FXML
    public void initialize() {
        // Setup columns
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        statusCol.setCellValueFactory(new PropertyValueFactory<>("active"));
        statusCol.setCellFactory(CheckBoxTableCell.forTableColumn(statusCol));

        // Dummy data
        userList = FXCollections.observableArrayList(
                new ManageUserAccountView(1, "Dr. X", true),
                new ManageUserAccountView(2, "Patient SKd", false),
                new ManageUserAccountView(3, "Accountant Tanzil", true)
        );

        userManagementTableView.setItems(userList);
    }

    @FXML
    public void itAdminButtonOnAction(ActionEvent actionEvent) {
        loadUsersForRole("IT Admin");
    }

    @FXML
    public void pharmacistButtonOnAction(ActionEvent actionEvent) {
        loadUsersForRole("Pharmacist");
    }

    @FXML
    public void onlineDoctorButtonOnAction(ActionEvent actionEvent) {
        loadUsersForRole("Online Doctor");
    }

    @FXML
    public void patientButtonOnAction(ActionEvent actionEvent) {
        loadUsersForRole("Patient");
    }

    @FXML
    public void accountantButtonOnAction(ActionEvent actionEvent) {
        loadUsersForRole("Accountant");
    }

    @FXML
    public void labTechnicianButtonOnAction(ActionEvent actionEvent) {
        loadUsersForRole("Lab Technician");
    }

    private void loadUsersForRole(String role) {
        // Simulate fetching users for the selected role
        userList.clear();
        userList.addAll(
                new ManageUserAccountView(101, role + " User1", true),
                new ManageUserAccountView (102, role + " User2", false)
        );
        statusMessageLabel.setText("Loaded " + role + " users.");
    }

    @FXML
    public void toggleUserStatus(ActionEvent actionEvent) {
        ManageUserAccountView selectedUser = userManagementTableView.getSelectionModel().getSelectedItem();
        if (selectedUser == null) {
            statusMessageLabel.setText("Please select a user first.");
            return;
        }

        selectedUser.setActive(!selectedUser.isActive());
        statusMessageLabel.setText("User " + selectedUser.getName() +
                " is now " + (selectedUser.isActive() ? "Active" : "Deactivated"));
        userManagementTableView.refresh();
    }
}
