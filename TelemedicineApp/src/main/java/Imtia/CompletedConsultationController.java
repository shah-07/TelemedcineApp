package Imtia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class CompletedConsultationController
{
    @javafx.fxml.FXML
    private TableView<CompleteConsultationModel> viewPrescriptionTV;
    @javafx.fxml.FXML
    private TableColumn<CompleteConsultationModel,String> patientnameTC;
    @javafx.fxml.FXML
    private TableColumn<CompleteConsultationModel,String> prescriptionfileTC;
    @javafx.fxml.FXML
    private TableColumn<CompleteConsultationModel,String> consultsIDTC;
ArrayList<CompleteConsultationModel> consultationModels = new ArrayList<>();
    @javafx.fxml.FXML
    public void initialize() {
        consultsIDTC.setCellValueFactory(new PropertyValueFactory<>("consultationId"));
        patientnameTC.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        prescriptionfileTC.setCellValueFactory(new PropertyValueFactory<>("prescriptionFile"));

        consultion();

    }
    public void consultion(){
        consultationModels.add(new CompleteConsultationModel("C102","Amey",null,"Napa,Pantonix",true));
        consultationModels.add(new CompleteConsultationModel("C103","korim",null,"Paracitamol",true));
        consultationModels.add(new CompleteConsultationModel("C104","Api",null,"seclo 20",true));
        consultationModels.add(new CompleteConsultationModel("C105","mahim",null,"Zinc",true));
        consultationModels.add(new CompleteConsultationModel("C106","Imtia",null,"Porota",true));
        consultationModels.add(new CompleteConsultationModel("C107","something",null,"Vitamin c,d,e,f,g,h,i",true));
        consultationModels.add(new CompleteConsultationModel("C108","tasfia",null,"Gabarol",true));
        consultationModels.add(new CompleteConsultationModel("C109","poran",null,"Saline",true));
        consultationModels.add(new CompleteConsultationModel("C110","Jobayer",null,"Motie",true));

        ObservableList<CompleteConsultationModel> observableList = FXCollections.observableArrayList(consultationModels);
        viewPrescriptionTV.setItems(observableList);
    }
}