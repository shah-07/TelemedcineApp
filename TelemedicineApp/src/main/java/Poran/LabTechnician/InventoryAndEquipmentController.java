package Poran.LabTechnician;

import Poran.Doctor.GenericFileManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class InventoryAndEquipmentController
{
    @javafx.fxml.FXML
    private TableView<InventoryItem> inventoryTV;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TableColumn<InventoryItem, String> nameTC;
    @javafx.fxml.FXML
    private ComboBox<String> typeCB;
    @javafx.fxml.FXML
    private TableColumn<InventoryItem, Integer> idTC;
    @javafx.fxml.FXML
    private TableColumn<InventoryItem, Integer> quantityTC;
    @javafx.fxml.FXML
    private Label successMessageLabel;
    @javafx.fxml.FXML
    private Label errorMessageLabel;
    @javafx.fxml.FXML
    private TextField updatedQuantityTF;
    @javafx.fxml.FXML
    private ComboBox<String> statusCB;
    @javafx.fxml.FXML
    private ComboBox<String> conditionCB;


    ObservableList<InventoryItem> inventoryItemList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        typeCB.getItems().addAll("All", "Medicine", "Reagent", "Test Kit");
        statusCB.getItems().addAll("In Stock", "Out of Stock", "Low Stock");
        conditionCB.getItems().addAll("Fresh", "Damaged", "Expired");

        nameTC.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        idTC.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        quantityTC.setCellValueFactory(new PropertyValueFactory<>("qunatitiy"));

    }

    @javafx.fxml.FXML
    public void searchButtonOA(ActionEvent actionEvent) {

        inventoryItemList = GenericFileManager.readAll(InventoryItem.class, "InventoryItem.bin");

        inventoryTV.getItems().clear();
        errorMessageLabel.setText("");
        successMessageLabel.setText("");

        if(nameTF.getText().isEmpty() && typeCB.getValue() == null){
            errorMessageLabel.setText("Please select name or name, or both");
            return;
        }

        if(nameTF.getText().isEmpty() && !(typeCB.getValue() == null)){

            for(InventoryItem i : inventoryItemList){
                if (i.getType().equals(typeCB.getValue())){
                    inventoryTV.getItems().add(i);
                }
            }
            successMessageLabel.setText("Items loaded");
            typeCB.setValue(null);
            return;
        }

        if(!(nameTF.getText().isEmpty()) && typeCB.getValue() == null){
            for(InventoryItem i : inventoryItemList){
                if (i.getItemName().equals(nameTF.getText())){
                    inventoryTV.getItems().add(i);
                }
            }
            successMessageLabel.setText("Items loaded");
            typeCB.setValue(null);
            return;
        }
        if(inventoryTV.getItems().isEmpty()){
            errorMessageLabel.setText("No items matched");
        }

    }


    @javafx.fxml.FXML
    public void updateItemButtonOA(ActionEvent actionEvent) {

        errorMessageLabel.setText("");
        successMessageLabel.setText("");

        InventoryItem selectedOne = inventoryTV.getSelectionModel().getSelectedItem();

        if(selectedOne == null){
            errorMessageLabel.setText("Please select an item to update");
            return;
        }

        if(updatedQuantityTF.getText().isEmpty() || statusCB.getValue() == null || conditionCB.getValue() == null){
            errorMessageLabel.setText("Please fill all the fields");
            return;
        }

        for (InventoryItem i : inventoryItemList){
            if(selectedOne.equals(i)){
                Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Press confirm to update");
                if (a.showAndWait().isPresent()) {
                    i.setQuantity(Integer.parseInt(updatedQuantityTF.getText()));
                    i.setStatus(statusCB.getValue());
                    i.setCondition(conditionCB.getValue());
                    successMessageLabel.setText("Item updated successfully");
                    return;
                }

            }
        }

    }
}