package Tasfia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ExploreServicesController {

    @FXML
    private TableColumn<ServiceRecord, String> shortInfoTableCol;

    @FXML
    private TableColumn<ServiceRecord, String> serviceNameTableCol;

    @FXML
    private TextArea shortInfoTextArea;

    @FXML
    private TextField serviceNameTextField;

    @FXML
    private TableView<ServiceRecord> serviceTableView;

    @FXML
    private Label createAccountLabel;

    private ObservableList<ServiceRecord> serviceRecords;

    @FXML
    public void initialize() {
        // TableColumn setup
        serviceNameTableCol.setCellValueFactory(new PropertyValueFactory<>("serviceName"));
        shortInfoTableCol.setCellValueFactory(new PropertyValueFactory<>("shortInfo"));

        // Sample data
        serviceRecords = FXCollections.observableArrayList(
                new ServiceRecord("Telemedicine", "Online consultation with doctors"),
                new ServiceRecord("Lab Test", "Book lab tests from home"),
                new ServiceRecord("Pharmacy", "Order medicines online")
        );

        // Load data into TableView
        serviceTableView.setItems(serviceRecords);

        // Select first item and show info in TextArea
        if (!serviceRecords.isEmpty()) {
            serviceTableView.getSelectionModel().selectFirst();
            shortInfoTextArea.setText(serviceRecords.get(0).getShortInfo());
        }

        // You can also add listener to update TextArea when selection changes
        serviceTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                shortInfoTextArea.setText(newSelection.getShortInfo());
            }
        });
    }
}
