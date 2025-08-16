package Imtia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class ExpMedicineController
{
    @javafx.fxml.FXML
    private TextField medicineNameTF;
    @javafx.fxml.FXML
    private TableView<ExpMedicineModel> checkTV;
    @javafx.fxml.FXML
    private TableColumn<ExpMedicineModel,String> medicineTC;
    @javafx.fxml.FXML
    private TableColumn<ExpMedicineModel,LocalDate> expTC;

    ObservableList<ExpMedicineModel> stock = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    public void initialize() {   medicineTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        expTC.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));

    }

    @javafx.fxml.FXML
    public void checkExpiryOA(ActionEvent actionEvent) {

    }

}