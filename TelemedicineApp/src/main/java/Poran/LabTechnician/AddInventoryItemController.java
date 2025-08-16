package Poran.LabTechnician;

import Poran.Doctor.GenericFileManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddInventoryItemController
{
    @javafx.fxml.FXML
    private Label successMessageButtonLabel;
    @javafx.fxml.FXML
    private Label errorMessageButtonLabel;
    @javafx.fxml.FXML
    private TextField itemId;
    @javafx.fxml.FXML
    private TextField itemName;
    @javafx.fxml.FXML
    private TextField itemQuantity;
    @javafx.fxml.FXML
    private ComboBox<String> itemConditionCB;
    @javafx.fxml.FXML
    private ComboBox<String> itemStatusCB;
    @javafx.fxml.FXML
    private TextField personNameTF;
    @javafx.fxml.FXML
    private TextField personIDTF;
    @javafx.fxml.FXML
    private ComboBox<String> personPositionCB;
    @javafx.fxml.FXML
    private ComboBox<String> typeCB;

    @javafx.fxml.FXML
    public void initialize() {

        itemConditionCB.getItems().addAll("Fresh", "Damaged", "Expired");
        itemStatusCB.getItems().addAll("In Stock", "Out of Stock", "Low Stock");
        personPositionCB.getItems().addAll("Manager", "Cashier", "Staff", "Others");
        typeCB.getItems().addAll("Medicine", "Reagents", "Test Kit");

    }


    @javafx.fxml.FXML
    public void addItemButtonOA(ActionEvent actionEvent) {

        ObservableList<InventoryItem> inventoryItemList = FXCollections.observableArrayList();

        if (itemName.getText().isEmpty() || itemId.getText().isEmpty() || itemStatusCB.getValue() == null ||
                itemQuantity.getText().isEmpty() || personPositionCB.getValue() == null || personIDTF.getText().isEmpty()
                || personNameTF.getText().isEmpty() && typeCB.getValue() == null) {
            errorMessageButtonLabel.setText("Please fill all the field");
            return;
        }

        inventoryItemList.add( new InventoryItem(
                itemName.getText(),
                personNameTF.getText(),
                Integer.parseInt(itemId.getText()),
                Integer.parseInt(personIDTF.getText()),
                itemConditionCB.getValue(),
                personPositionCB.getValue(),
                itemStatusCB.getValue(),
                Integer.parseInt(itemQuantity.getText()),
                typeCB.getValue())
        );

        GenericFileManager.writeAll(inventoryItemList, "InventoryItems.bin");
        successMessageButtonLabel.setText("Item successfully added");

        itemName.clear(); personNameTF.clear(); itemId.clear();personIDTF.clear(); itemConditionCB.setValue(null);
        personPositionCB.setValue(null); itemStatusCB.setValue(null); itemQuantity.clear();
    }

}