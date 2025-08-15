package Imtia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class PatientHealthCampaignInfoController
{
    @javafx.fxml.FXML
    private TableView<PatientHealthCampaignInfoModel> healthTV;
    @javafx.fxml.FXML
    private TableColumn<PatientHealthCampaignInfoModel,String> dateTC;
    @javafx.fxml.FXML
    private TableColumn<PatientHealthCampaignInfoModel,String> newHealthTC;

    private ObservableList<PatientHealthCampaignInfoModel> campaignList;

    @javafx.fxml.FXML
    public void initialize() {

        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        newHealthTC.setCellValueFactory(new PropertyValueFactory<>("campaignDescription"));

        loadHealthCampaignInfo();

    }
    private void loadHealthCampaignInfo() {

        campaignList = FXCollections.observableArrayList(
                new PatientHealthCampaignInfoModel("2023-10-01", "Flu Vaccination Campaign"),
                new PatientHealthCampaignInfoModel("2023-11-15", "COVID-19 Booster Shots")
        );

        healthTV.setItems(campaignList);
    }




}