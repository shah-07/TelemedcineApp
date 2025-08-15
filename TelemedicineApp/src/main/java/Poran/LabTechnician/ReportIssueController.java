package Poran.LabTechnician;


import Poran.Doctor.GenericFileManager;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.apache.commons.lang3.RandomStringUtils;

public class ReportIssueController
{
    @javafx.fxml.FXML
    private TextArea descriptionIssueTA;
    @javafx.fxml.FXML
    private ComboBox<String> urgencyLevelCB;
    @javafx.fxml.FXML
    private Label errorMessageLabel;
    @javafx.fxml.FXML
    private Label successMessageLabel;
    @javafx.fxml.FXML
    private TextField reporterNameTF;
    @javafx.fxml.FXML
    private TextField reporterIdTf;

    @javafx.fxml.FXML
    public void initialize() {

        urgencyLevelCB.getItems().addAll("High", "Medium", "Low");

    }
    public String generateToken () {
        return RandomStringUtils.randomAlphanumeric(8).toUpperCase();
    }

    @javafx.fxml.FXML
    public void reportButtonOA (ActionEvent actionEvent) {

        ObservableList<Issue> issueList = GenericFileManager.readAll(Issue.class, "Issue.bin");

        String token = "";
        boolean alreadyExists = true;

        while (alreadyExists) {
            token = generateToken();
            alreadyExists = false;

            for (Issue i : issueList) {
                if (token.equals(i.getToken())) {
                    alreadyExists = true;
                    break;
                }
            }
        }

        issueList.add(new Issue(
                reporterNameTF.getText(),
                token,
                Integer.parseInt(reporterIdTf.getText()),
                urgencyLevelCB.getValue(),
                descriptionIssueTA.getText()
                                )
        );

        Alert a = new Alert(Alert.AlertType.INFORMATION, "Your token is: "+token);
        a.setHeaderText("Token");
        a.showAndWait();
        successMessageLabel.setText("Report filed");
        GenericFileManager.writeAll(issueList, "Issue.bin");
    }
}