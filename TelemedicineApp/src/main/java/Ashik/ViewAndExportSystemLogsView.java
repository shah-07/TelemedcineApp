package Ashik;

import java.io.Serializable;
import java.time.LocalDate;

public class ViewAndExportSystemLogsView implements Serializable {
    private LocalDate date;
    private String actionType;
    private String user;
    private String description;

    public ViewAndExportSystemLogsView(LocalDate date, String actionType, String user, String description) {
        this.date = date;
        this.actionType = actionType;
        this.user = user;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
