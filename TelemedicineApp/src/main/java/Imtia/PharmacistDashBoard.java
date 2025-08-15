package Imtia;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class PharmacistDashBoard
{

    @javafx.fxml.FXML
    private AnchorPane dashBoardAnchorPane;
    @javafx.fxml.FXML
    private AnchorPane anchorPaneForPartialWindows;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void updatePriceButton(ActionEvent actionEvent) throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("/Imtia/PharmacistUpdatePrice.fxml"));
        anchorPaneForPartialWindows.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void contectDoctorButton(ActionEvent actionEvent) throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("/Imtia/PharmacistShareUpdateToDoctor.fxml"));
        anchorPaneForPartialWindows.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void deliveryOrderButton(ActionEvent actionEvent) throws IOException{
        Node node = FXMLLoader.load(getClass().getResource("/Imtia/PharmacistReceiveOrder.fxml"));
        anchorPaneForPartialWindows.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void updateStockButton(ActionEvent actionEvent) throws IOException{
        Node node = FXMLLoader.load(getClass().getResource("/Imtia/PharmacistManageInventory.fxml"));
        anchorPaneForPartialWindows.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void communicateButton(ActionEvent actionEvent) throws IOException{
        Node node = FXMLLoader.load(getClass().getResource("/Imtia/PharmacistCommunication.fxml"));
        anchorPaneForPartialWindows.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void checkExpButton(ActionEvent actionEvent) throws IOException{
        Node node = FXMLLoader.load(getClass().getResource("/Imtia/PharmacistExpMedicine.fxml"));
        anchorPaneForPartialWindows.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void takeOrderButton(ActionEvent actionEvent)throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("/Imtia/PharmacistConfirmPrescription.fxml"));
        anchorPaneForPartialWindows.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void showBillButton(ActionEvent actionEvent)throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("/Imtia/PharmacistGetPayment.fxml"));
        anchorPaneForPartialWindows.getChildren().setAll(node);
    }
}