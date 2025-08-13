package Poran.Doctor;

import Imtia.Appointment;
import Poran.LabTechnician.LabTechnician;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DummyObjectCreator {
    public void createDummyObjects() throws IOException {

        Doctor doc1 = new Doctor("Dr. Alice Smith", 1001, "123456", LocalDate.of(1980, 5, 14), "Cardiologist");
        Doctor doc2 = new Doctor("Dr. Bob Johnson", 1002, "234567", LocalDate.of(1975, 9, 22),"Neurologist");

        LabTechnician lab1 = new LabTechnician("Mr. Anis Mark", 10001, "123456", LocalDate.of(1995, 4, 24), "Manager");
        LabTechnician lab2 = new LabTechnician("Ms. Samira Jahan", 10002, "234567",LocalDate.of(1998, 4, 24), "Cashier");


        Appointment a1 = new Appointment("Poran", "Male", "Headache",152648, 20, 500, LocalDate.of(2025, 8, 20), LocalTime.of(10, 15));
        Appointment a2 = new Appointment("N. N.", "Female", "Pain in Stomach", 252648, 20, 500, LocalDate.of(2025, 8, 18), LocalTime.of(14, 30));
        Appointment a3 = new Appointment("San", "Female", "Pain in hand", 3526489, 18, 500, LocalDate.now(), LocalTime.now().plusMinutes(30));

        // Write them to Doctor.bin
        FileOutputStream fos1 = new FileOutputStream("Doctor.bin");
        ObjectOutputStream oos1 = new ObjectOutputStream(fos1);

        oos1.writeObject(doc1);
        oos1.writeObject(doc2);
        oos1.close();

        // Write them to Doctor.bin
        FileOutputStream fos2 = new FileOutputStream("LabTechnician.bin");
        ObjectOutputStream oos2 = new ObjectOutputStream(fos2);

        oos2.writeObject(lab1);
        oos2.writeObject(lab2);
        oos2.close();

        //Write them to Appointment.bin
        FileOutputStream fos3 = new FileOutputStream("Appointment.bin");
        ObjectOutputStream oos3 = new ObjectOutputStream(fos3);

        oos3.writeObject(a1);
        oos3.writeObject(a2);
        oos3.writeObject(a3);
        oos3.close();

    }
/*
    public void dummy(){
        Boolean found = false;
        LocalTime fromTime = LocalTime.parse(fromTimeOfAppointment.getText());
        LocalTime toTime = LocalTime.parse(toTimeOfAppointment.getText());
        try{
            FileInputStream fis = new FileInputStream("Appointment.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true){
                Appointment s = (Appointment) ois.readObject();
                if (dateOfThePendingAppointmentDP.getValue().equals(s.getDateOfAppointment()) && ((s.getTimeOfAppointment().equals(fromTime) || s.getTimeOfAppointment().isAfter(fromTime)) && (s.getTimeOfAppointment().equals(toTime) || s.getTimeOfAppointment().isBefore(toTime)))) {
                    pendingAppointmentsTableView.getItems().add(s);
                    found = true;
                }
            }
        }
        catch (EOFException eof) {
            if (found){
                successMessageLabel.setText("Appointment Loaded");
            }
            else {
                errorMessageLabel.setText("No appointments to show");
            }
            ois.close();
        }
        catch (Exception e) {
            e.printStackTrace(); // Helpful for debugging
            errorMessageLabel.setText("Error reading appointment file.");
        }

    }

 */
}
