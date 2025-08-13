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

        // Sample stock data
        stock.add(new ExpMedicineModel("Paracetamol", LocalDate.now().plusDays(5)));
        stock.add(new ExpMedicineModel("Aspirin", LocalDate.now().plusMonths(2)));
        stock.add(new ExpMedicineModel("Amoxicillin", LocalDate.now().plusDays(10)));

        checkTV.setItems(stock);
    }

    @javafx.fxml.FXML
    public void checkExpiryOA(ActionEvent actionEvent) {
        String medName = medicineNameTF.getText().trim();
        ObservableList<ExpMedicineModel> result = FXCollections.observableArrayList();

        if (medName.isEmpty()) {
            checkTV.setItems(stock);
            return;
        }

        for (ExpMedicineModel med : stock) {
            if (med.getName().equalsIgnoreCase(medName)) {
                result.add(med);
                // Near expiry check (less than 15 days from now)
                if (med.getExpiryDate().isBefore(LocalDate.now().plusDays(15))) {
                    System.out.println("⚠ Notification: " + med.getName() + " is nearing expiry!");
                }
            }
        }

        checkTV.setItems(result);
    }

}