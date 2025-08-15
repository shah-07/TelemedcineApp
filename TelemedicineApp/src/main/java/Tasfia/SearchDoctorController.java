package Tasfia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SearchDoctorController {

    @FXML
    private TableColumn<DoctorRecord, String> doctorListTableCol;

    @FXML
    private TableColumn<DoctorRecord, String> departmentTableCol;

    @FXML
    private TableColumn<DoctorRecord, String> timeTableCol;

    @FXML
    private TableColumn<DoctorRecord, Double> feeTableCol;

    @FXML
    private TableView<DoctorRecord> searchDoctorTableView;

    @FXML
    private TextField doctorNameTextField;

    @FXML
    private ComboBox<String> departmentComboBox;

    private ObservableList<DoctorRecord> doctorRecords;

    @FXML
    public void initialize() {
        // TableColumn setup
        doctorListTableCol.setCellValueFactory(new PropertyValueFactory<>("doctorName"));
        departmentTableCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        timeTableCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        feeTableCol.setCellValueFactory(new PropertyValueFactory<>("fee"));

        // Sample doctor records
        doctorRecords = FXCollections.observableArrayList(
                new DoctorRecord("Dr. Tasfia", "Cardiology", "10:00 AM - 2:00 PM", 500),
                new DoctorRecord("Dr. Rahman", "Neurology", "2:00 PM - 6:00 PM", 600),
                new DoctorRecord("Dr. Karim", "Dermatology", "9:00 AM - 1:00 PM", 400)
        );

        searchDoctorTableView.setItems(doctorRecords);

        // ComboBox setup
        departmentComboBox.setItems(FXCollections.observableArrayList(
                "All", "Cardiology", "Neurology", "Dermatology"
        ));
        departmentComboBox.getSelectionModel().selectFirst();
    }

    @FXML
    public void bookButtonOnAction(ActionEvent actionEvent) {
        DoctorRecord selectedDoctor = searchDoctorTableView.getSelectionModel().getSelectedItem();
        if (selectedDoctor != null) {
            System.out.println("Booking appointment with: " + selectedDoctor.getDoctorName());
        }
    }

    @FXML
    public void doctorProfileButtonOnAction(ActionEvent actionEvent) {
        DoctorRecord selectedDoctor = searchDoctorTableView.getSelectionModel().getSelectedItem();
        if (selectedDoctor != null) {
            System.out.println("Opening profile of: " + selectedDoctor.getDoctorName());
        }
    }
}
