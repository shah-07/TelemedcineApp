package Poran.Doctor;

import Imtia.Appointment;
import Poran.LabTechnician.LabTechnician;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DummyObjectCreator {
    public void createDummyObjects() throws IOException {

        ArrayList<String> medicineList = new ArrayList<>();
        medicineList.add("Napa");
        medicineList.add("Histacin");

        Doctor doc1 = new Doctor("Dr. Alice Smith", 1001, "123456", LocalDate.of(1980, 5, 14), "Cardiologist");
        Doctor doc2 = new Doctor("Dr. Bob Johnson", 1002, "234567", LocalDate.of(1975, 9, 22),"Neurologist");

        LabTechnician lab1 = new LabTechnician("Mr. Anis Mark", 10001, "123456", LocalDate.of(1995, 4, 24), "Manager");
        LabTechnician lab2 = new LabTechnician("Ms. Samira Jahan", 10002, "234567",LocalDate.of(1998, 4, 24), "Cashier");


        Appointment a1 = new Appointment("Poran", "Male", "Headache",152648, 20, 500, LocalDate.of(2025, 8, 20), LocalTime.of(10, 15));
        Appointment a2 = new Appointment("N. N.", "Female", "Pain in Stomach", 252648, 20, 500, LocalDate.of(2025, 8, 18), LocalTime.of(14, 30));
        Appointment a3 = new Appointment("San", "Female", "Pain in hand", 3526489, 18, 500, LocalDate.now(), LocalTime.now().plusMinutes(30));

        Prescription p1 = new Prescription("Poran","Male", 20, medicineList, "Fever", LocalDate.of(2025, 8, 20), LocalTime.of(10, 15), "Nothing");
        //Write them to Prescription.bin
        FileOutputStream fos5 = new FileOutputStream("Prescription.bin");
        ObjectOutputStream oos5 = new ObjectOutputStream(fos5);

        oos5.writeObject(p1);

        oos5.close();

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

        ArrayList<String> testList = new ArrayList<String>();
        testList.add("CBC");
        testList.add("CTR");

        LabTestForm l1 = new LabTestForm("Rifat", "Rabi", "Male", "Fever", testList,"Nothing", 20, LocalDate.of(2025,8, 10), LocalTime.of(10,20));
        LabTestForm l2 = new LabTestForm("Safin", "Kawsar", "Male", "Cold", testList,"Nothing", 20, LocalDate.of(2025,8, 7), LocalTime.of(13,15));

        //Write them to LabTestForm.bin
        FileOutputStream fos4 = new FileOutputStream("LabTestForm.bin");
        ObjectOutputStream oos4 = new ObjectOutputStream(fos4);

        oos4.writeObject(l1);
        oos4.writeObject(l2);
        oos4.close();


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
