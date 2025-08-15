package Imtia;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class PharmacistUpdatePriceController
{
    @javafx.fxml.FXML
    private Label successL;
    @javafx.fxml.FXML
    private TextField medicineTF;
    @javafx.fxml.FXML
    private TextField updatedPriceTF;

    ArrayList<PharmacistUpdatePriceControllerModel> medicines = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        medicines.add(new PharmacistUpdatePriceControllerModel("Paracetamol", 10.0));
        medicines.add(new PharmacistUpdatePriceControllerModel("Aspirin", 15.0));
        medicines.add(new PharmacistUpdatePriceControllerModel("Amoxicillin", 25.0));
        medicines.add(new PharmacistUpdatePriceControllerModel("Napa", 12.0));

    }

    @javafx.fxml.FXML
    public void saveOA(ActionEvent actionEvent) {
        String medName = medicineTF.getText().trim();
        String priceText = updatedPriceTF.getText().trim();

        if (medName.isEmpty() || priceText.isEmpty()) {
            successL.setText("Please enter medicine name and price.");
            return;
        }

        double newPrice = Double.parseDouble(priceText); // No try-catch

        boolean found = false;
        for (PharmacistUpdatePriceControllerModel med : medicines) {
            if (med.getName().equalsIgnoreCase(medName)) {
                med.setPrice(newPrice);
                found = true;
                break;
            }
        }

        if (found) {
            successL.setText("Updated successfully!");
        } else {
            successL.setText("Medicine not found.");
        }

    }

}

