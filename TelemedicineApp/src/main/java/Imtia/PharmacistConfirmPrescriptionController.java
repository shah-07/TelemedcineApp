package Imtia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class PharmacistConfirmPrescriptionController
{
    @javafx.fxml.FXML
    private TableColumn<PharmacistConfirmPrescriptionModel,String> timeTC;
    @javafx.fxml.FXML
    private TextField timeTF;
    @javafx.fxml.FXML
    private DatePicker dateDP;
    @javafx.fxml.FXML
    private TableColumn<PharmacistConfirmPrescriptionModel,String> dateTC;
    @javafx.fxml.FXML
    private TableView<PharmacistConfirmPrescriptionModel> confirmPrescriptionTV;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TableColumn<PharmacistConfirmPrescriptionModel,String> nameTC;


    private ObservableList<PharmacistConfirmPrescriptionModel> dataList;


    @javafx.fxml.FXML
    public void initialize() {

        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeTC.setCellValueFactory(new PropertyValueFactory<>("time"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));


        dataList = FXCollections.observableArrayList();


        confirmPrescriptionTV.setItems(dataList);

    }

    @javafx.fxml.FXML
    public void confirmOA(ActionEvent actionEvent) {

    }
}