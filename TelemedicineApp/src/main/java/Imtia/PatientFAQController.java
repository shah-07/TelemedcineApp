package Imtia;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PatientFAQController
{
    @javafx.fxml.FXML
    private TextField howDoTF;
    @javafx.fxml.FXML
    private TextField canIResTF;
    @javafx.fxml.FXML
    private TextField whereCanTF;
    @javafx.fxml.FXML
    private TextField askQuestionTF;
    @javafx.fxml.FXML
    private Label alertL;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void canIResOA(ActionEvent actionEvent) {
        canIResTF.setText(
                "Yes, go to your appointment list, select the appointment, and choose reschedule or cancel."
        );
    }

    @javafx.fxml.FXML
    public void howDoOA(ActionEvent actionEvent) {
        howDoTF.setText(
                "Open the app or website, select a doctor, give necessary info, choose a time, and confirm your booking."
        );
    }

    @javafx.fxml.FXML
    public void whereCanOA(ActionEvent actionEvent) {
        whereCanTF.setText(
                "You can check your lab results in the ‘Reports’ section of the app or website."
        );
    }

    @javafx.fxml.FXML
    public void sendOA(ActionEvent actionEvent) {
        String userQuestion = askQuestionTF.getText().trim();

        if (!userQuestion.isEmpty()) {
            alertL.setText(
                    "Your issue has been submitted. Ticket ID: #" + (1000 + (int)(Math.random() * 9000))
            );
        } else {
            alertL.setText("Please enter a question first.");
        }
    }
}