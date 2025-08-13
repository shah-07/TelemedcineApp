package Poran.Doctor;

import Imtia.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class StartAppointmentController
{
    @javafx.fxml.FXML
    private TableColumn<Appointment, LocalTime> timeTC;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> genderTC;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> nameTC;
    @javafx.fxml.FXML
    private Label errorMessageLabel;
    @javafx.fxml.FXML
    private TableColumn<Appointment, Integer> ageTC;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> reasonTC;
    @javafx.fxml.FXML
    private TableColumn<Appointment, LocalDateTime> dateTC;
    @javafx.fxml.FXML
    private TableView<Appointment> appointmentsTV;
    @javafx.fxml.FXML
    private Label successMessageLabel;
    @javafx.fxml.FXML
    private Button startAppointmentButton;


    ObservableList<Appointment> appointmentList = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    public void initialize() {

        timeTC.setCellValueFactory(new PropertyValueFactory<>("timeOfAppointment"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("dateOfAppointment"));
        ageTC.setCellValueFactory(new PropertyValueFactory<>("age"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        genderTC.setCellValueFactory(new PropertyValueFactory<>("gender"));
        reasonTC.setCellValueFactory(new PropertyValueFactory<>("reason"));

        appointmentsTV.setItems(appointmentList);

    }

    @javafx.fxml.FXML
    public void loadButtonOA(ActionEvent actionEvent) {

        successMessageLabel.setText("");
        errorMessageLabel.setText("");

        appointmentsTV.getItems().clear();
        appointmentList = AppointmentFileManager.readAll();

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneHourLater = now.plusHours(1);

        // Filter: within the next 1 hour
        for (Appointment appt : appointmentList) {
            LocalDateTime apptDateTime = LocalDateTime.of(
                    appt.getDateOfAppointment(),
                    appt.getTimeOfAppointment()
            );

            if (!apptDateTime.isBefore(now) && apptDateTime.isBefore(oneHourLater)) {
                appointmentsTV.getItems().add(appt);
            }
        }

    }

    @javafx.fxml.FXML
    public void startAppointmentButtonOA(ActionEvent actionEvent) throws IOException {

        successMessageLabel.setText("");
        errorMessageLabel.setText("");
        Appointment selectedAppointment = appointmentsTV.getSelectionModel().getSelectedItem();
        if (selectedAppointment == null) {
            errorMessageLabel.setText("Please select an appointment to reschedule");
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Poran/Doctor/notesForPrescriptionView.fxml"));
        Parent root = loader.load();

        NotesForPrescriptionController nextController = loader.getController();

        nextController.setAppointmentList(appointmentList);
        nextController.setAppointmentToMarkAsSeen(selectedAppointment);

        Stage stage = new Stage();
        stage.setTitle("Edit Appointment Seen Status");
        stage.setScene(new Scene(root));
        stage.show();

    }
}