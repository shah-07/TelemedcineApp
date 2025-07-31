package Imtia;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PharmacistManageInventoryController
{
    @javafx.fxml.FXML
    private TableColumn medicineNameTC;
    @javafx.fxml.FXML
    private TextField medicineNameTF;
    @javafx.fxml.FXML
    private TableView medicineExpTV;
    @javafx.fxml.FXML
    private TextField medicineQuantityTF;
    @javafx.fxml.FXML
    private TextField expTF;
    @javafx.fxml.FXML
    private TableColumn quantityTC;
    @javafx.fxml.FXML
    private TableColumn expTC;
    @javafx.fxml.FXML
    private Label successL;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void updateOA(ActionEvent actionEvent) {
    }
}