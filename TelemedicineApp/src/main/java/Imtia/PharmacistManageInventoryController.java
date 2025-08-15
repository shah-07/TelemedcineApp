package Imtia;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;



public class PharmacistManageInventoryController
{
    @javafx.fxml.FXML
    private TextField medicineNameTF;
    @javafx.fxml.FXML
    private TextField medicineQuantityTF;
    @javafx.fxml.FXML
    private TextField expTF;
    @javafx.fxml.FXML
    private Label successL;

    @javafx.fxml.FXML
    public void initialize() {
        successL.setText("");
    }

    @javafx.fxml.FXML
    public void updateOA(ActionEvent actionEvent) {

    }
}
