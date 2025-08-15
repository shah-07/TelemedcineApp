package Tasfia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.stream.Collectors;

public class ViewDoctorListController {

    @FXML
    private TableView<Doctor> doctorListTableView;

    @FXML
    private TableColumn<Doctor, String> doctorNameTableCol;

    @FXML
    private TableColumn<Doctor, String> specialistTableCol;

    @FXML
    private TableColumn<Doctor, String> detailsTableCol;

    @FXML
    private TextArea detailsTextArea;

    @FXML
    private ComboBox<String> specialistComboBox;

    @FXML
    private TextField doctorNameTextField;

    private ObservableList<Doctor> doctorList;

    @FXML
    public void initialize() {
        // TableColumn setup
        doctorNameTableCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        specialistTableCol.setCellValueFactory(new PropertyValueFactory<>("specialist"));
        detailsTableCol.setCellValueFactory(new PropertyValueFactory<>("details"));

        // Sample data
        doctorList = FXCollections.observableArrayList(
                new Doctor("Dr. Rakin Abser", "Cardiologist", "Expert in heart diseases."),
                new Doctor("Dr. Boshir", "Dermatologist", "Skin specialist."),
                new Doctor("Dr. Chonchol", "General Physician", "Covers general health issues."),
                new Doctor("Dr. Dipok", "ENT", "Ear, Nose, Throat specialist.")
        );

        doctorListTableView.setItems(doctorList);

        // ComboBox setup
        specialistComboBox.setItems(FXCollections.observableArrayList("All", "Cardiologist", "Dermatologist", "General Physician", "ENT"));
        specialistComboBox.getSelectionModel().selectFirst();

        // Show details when row is selected
        doctorListTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                detailsTextArea.setText(newSelection.getDetails());
            }
        });
    }

    @FXML
    public void searchButtonOnAction(ActionEvent actionEvent) {
        String nameFilter = doctorNameTextField.getText().trim().toLowerCase();
        String specialistFilter = specialistComboBox.getSelectionModel().getSelectedItem();

        ObservableList<Doctor> filtered = FXCollections.observableArrayList(
                doctorList.stream()
                        .filter(d -> (nameFilter.isEmpty() || d.getName().toLowerCase().contains(nameFilter)) &&
                                (specialistFilter.equals("All") || d.getSpecialist().equalsIgnoreCase(specialistFilter)))
                        .collect(Collectors.toList())
        );

        doctorListTableView.setItems(filtered);
    }
}
