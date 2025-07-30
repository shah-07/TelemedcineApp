package poran_2420181;

import java.time.LocalDate;
import java.time.LocalTime;

public class PendingAppointments {
    private LocalTime timeOfAppointment;
    private LocalDate dateOfAppointment;

    public LocalTime getTimeOfAppointment() {
        return timeOfAppointment;
    }

    public void setTimeOfAppointment(LocalTime timeOfAppointment) {
        this.timeOfAppointment = timeOfAppointment;
    }

    public LocalDate getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(LocalDate dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }
}
