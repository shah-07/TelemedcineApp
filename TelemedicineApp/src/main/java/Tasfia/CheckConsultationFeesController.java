package Tasfia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CheckConsultationFeesController {

    @FXML
    private TableView<DoctorFee> consultationFeeTableView;

    @FXML
    private TableColumn<DoctorFee, String> doctorListTableColumn;

    @FXML
    private TableColumn<DoctorFee, String> doctorDetailsTableColumn;

    @FXML
    private TableColumn<DoctorFee, Double> doctorFeeTableColumn;

    @FXML
    private TextField doctorNameTextField;

    @FXML
    private TextField doctorFeeTextField;

    @FXML
    private TextArea doctorDetailsTextArea;

    private ObservableList<DoctorFee> doctorFeeList;

    @FXML
    public void initialize() {
        // TableColumn setup
        doctorListTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        doctorDetailsTableColumn.setCellValueFactory(new PropertyValueFactory<>("details"));
        doctorFeeTableColumn.setCellValueFactory(new PropertyValueFactory<>("fee"));

        // Sample data
        doctorFeeList = FXCollections.observableArrayList(
                new DoctorFee("Dr. Khan", "Cardiologist, heart specialist", 1500),
                new DoctorFee("Dr. Rahman", "Dermatologist, skin specialist", 1200),
                new DoctorFee("Dr. Roy", "General Physician", 1000)
        );

        consultationFeeTableView.setItems(doctorFeeList);

        // Show details & fee on row selection
        consultationFeeTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if(newSelection != null) {
                doctorDetailsTextArea.setText(newSelection.getDetails());
                doctorFeeTextField.setText(String.valueOf(newSelection.getFee()));
            }
        });
    }
}
