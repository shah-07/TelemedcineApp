package Poran.Doctor;

import Poran.LabTechnician.LabTechnician;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class DummyObjectCreator {
    public void createDoctors(){
        try {
            Doctor doc1 = new Doctor("Dr. Alice Smith", 1001, "123456", LocalDate.of(1980, 5, 14), "Cardiology");
            Doctor doc2 = new Doctor("Dr. Bob Johnson", 1002, "234567", LocalDate.of(1975, 9, 22),"Neurology");

            LabTechnician lab1 = new LabTechnician("Mr. Anis", 10001, "123456", LocalDate.of(1995, 4, 24), "Manager");
            LabTechnician lab2 = new LabTechnician("Ms. Samira", 10002, "234567",LocalDate.of(1998, 4, 24), "Cashier");

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

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
