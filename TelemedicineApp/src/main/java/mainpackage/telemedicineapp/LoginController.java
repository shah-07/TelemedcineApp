package mainpackage.telemedicineapp;

import Poran.Doctor.Doctor;
import Poran.Doctor.DoctorDashBoardController;
import Poran.LabTechnician.LabTechnician;
import Poran.LabTechnician.LabTechnicianDashboardController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LoginController
{
    @javafx.fxml.FXML
    private TextField userIdTF;
    @javafx.fxml.FXML
    private Label successMessageLabel;
    @javafx.fxml.FXML
    private Label errorMessageLabel;
    @javafx.fxml.FXML
    private AnchorPane loginAnchor;
    @javafx.fxml.FXML
    private PasswordField passwordPF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loginButtonOA(ActionEvent actionEvent) {

        if ((userIdTF.getText().length() == 4)){
            Doctor foundDoctor = null;
            boolean found = false;
            try {
                FileInputStream fis = new FileInputStream("Doctor.bin");
                ObjectInputStream ois = new ObjectInputStream(fis);

                while (true){
                    Doctor d = (Doctor) ois.readObject();
                    if ((Integer.parseInt(userIdTF.getText()) == d.getId()) && passwordPF.getText().equals(d.getPassword())){
                        found = true;
                        foundDoctor =d;
                        break;
                    }
                }
            }
            catch (EOFException e1){
                errorMessageLabel.setText("User ID and Password Doesn't match");
            }
            catch (Exception e2){
                errorMessageLabel.setText("Error");
                e2.printStackTrace();
            }
            if (found){
                try{

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Poran/Doctor/doctorDashBoardView.fxml"));
                    Node node = loader.load();
                    DoctorDashBoardController nextController = loader.getController();
                    nextController.setDoctorNameAndID(foundDoctor.getName(), foundDoctor.getId());
                    loginAnchor.getChildren().setAll(node);
                }

                catch (Exception e) {
                    //;
                }


            }
        }

        else if ((userIdTF.getText().length() == 5)){
            LabTechnician foundTechnician = null;
            boolean found = false;
            try {
                FileInputStream fis = new FileInputStream("LabTechnician.bin");
                ObjectInputStream ois = new ObjectInputStream(fis);

                while (true){
                    LabTechnician l = (LabTechnician) ois.readObject();
                    if ((Integer.parseInt(userIdTF.getText()) == l.getId()) && passwordPF.getText().equals(l.getPassword())){
                        found = true;
                        foundTechnician = l;
                        break;
                    }
                }
            }
            catch (EOFException e1){
                errorMessageLabel.setText("User ID and Password Doesn't match");
            }
            catch (Exception e2){
                errorMessageLabel.setText("Error");
                e2.printStackTrace();
            }
            if (found){
                try{

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Poran/LabTechnician/labTechnicianDashboardView.fxml"));
                    Node node = loader.load();
                    LabTechnicianDashboardController nextController = loader.getController();
                    nextController.setTechnicianNameAndPosition (foundTechnician.getName(), foundTechnician.getPosition());
                    loginAnchor.getChildren().setAll(node);
                }

                catch (Exception e) {
                    //;
                }


            }
        }


    }
}


