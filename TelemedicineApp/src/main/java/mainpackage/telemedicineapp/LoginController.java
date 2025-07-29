package mainpackage.telemedicineapp;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController
{
    @javafx.fxml.FXML
    private TextField userIdTF;
    @javafx.fxml.FXML
    private TextField passwordTF;
    @javafx.fxml.FXML
    private Label loggedInSuccessMessageLabel;
    @javafx.fxml.FXML
    private Label loggedInFailMessageLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loginButtonOA(ActionEvent actionEvent) {
        if (User.verifyLogin(userIdTF.getText(), passwordTF.getText())){
            loggedInSuccessMessageLabel.setText("Login Successful");
            //Proceed to Dashboard
        }
        else{
            loggedInFailMessageLabel.setText("Login Failed");
        }
    }
}