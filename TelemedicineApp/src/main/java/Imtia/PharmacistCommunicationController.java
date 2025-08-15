package Imtia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class PharmacistCommunicationController
{
    @javafx.fxml.FXML
    private TableColumn<PharmacistCommunicationModel,String> patientTC;
    @javafx.fxml.FXML
    private TableColumn<PharmacistCommunicationModel,Boolean> isCompleteTC;
    @javafx.fxml.FXML
    private TableView<PharmacistCommunicationModel> chatCompleteTV;

    ArrayList<PharmacistCommunicationModel> PharmacyList= new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        patientTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        isCompleteTC.setCellValueFactory(new PropertyValueFactory<>("isComplete"));

        PharmacyList.add(new PharmacistCommunicationModel("Mahin",true));
        PharmacyList.add(new PharmacistCommunicationModel("Nisha",true));

        ObservableList <PharmacistCommunicationModel> observableList= FXCollections.observableArrayList(PharmacyList);

    }

    @javafx.fxml.FXML
    public void videoCallOA(ActionEvent actionEvent) {


    }

    @javafx.fxml.FXML
    public void startChatOA(ActionEvent actionEvent) {


    }
}
