package Poran.Doctor;

import Imtia.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentFileManager {

    private static final String FILE_NAME = "Appointment.bin";

    // Read all appointments into ObservableList
    public static ObservableList<Appointment> readAll() {
        ObservableList<Appointment> appointments = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            while (true) {
                try {
                    Appointment appt = (Appointment) ois.readObject();
                    appointments.add(appt);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No appointments file yet.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appointments;
    }

    // Write all appointments from ObservableList to file
    public static void writeAll(ObservableList<Appointment> appointments) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            for (Appointment appt : appointments) {
                oos.writeObject(appt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Append a single appointment
    public static void append(Appointment appt) {
        File file = new File(FILE_NAME);
        try (ObjectOutputStream oos = file.exists() && file.length() > 0
                ? new AppendableObjectOutputStream(new FileOutputStream(file, true))
                : new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(appt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}