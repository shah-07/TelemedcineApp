package Ashik;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.stream.Collectors;


public class AuditLogsController
{
    @javafx.fxml.FXML
    private ComboBox <String > typeComboBox;
    @javafx.fxml.FXML
    private TableColumn <AuditLog, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn <AuditLog,String> actionTypeCol;
    @javafx.fxml.FXML
    private TableColumn <AuditLog, String > userCol;
    @javafx.fxml.FXML
    private TableColumn <AuditLog, String > descriptionCol;
    @javafx.fxml.FXML
    private TableView < AuditLog> auditLogsTableView;
    @javafx.fxml.FXML
    private DatePicker toDateDP;
    @javafx.fxml.FXML
    private DatePicker fromDateDP;
    @javafx.fxml.FXML
    private Label downloadLabel;

    @javafx.fxml.FXML
    public void initialize() {
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        userCol.setCellValueFactory(new PropertyValueFactory(" user"));
        actionTypeCol.setCellValueFactory(new PropertyValueFactory<>("actionType"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        typeComboBox.getItems().addAll("Login" , "Error", "Transaction");

    }

    @javafx.fxml.FXML
    public void pdfButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void csvButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void filterButton(ActionEvent actionEvent) {
    }

}