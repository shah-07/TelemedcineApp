package Ashik;

import javafx.beans.property.*;
import java.time.LocalDate;

public class AuditLog {
    private final ObjectProperty<LocalDate> date;
    private final StringProperty actionType;
    private final StringProperty user;
    private final StringProperty description;

    public AuditLog(LocalDate date, String actionType, String user, String description) {
        this.date = new SimpleObjectProperty<>(date);
        this.actionType = new SimpleStringProperty(actionType);
        this.user = new SimpleStringProperty(user);
        this.description = new SimpleStringProperty(description);
    }

    public ObjectProperty<LocalDate> dateProperty() { return date; }
    public StringProperty actionTypeProperty() { return actionType; }
    public StringProperty userProperty() { return user; }
    public StringProperty descriptionProperty() { return description; }

    public LocalDate getDate() { return date.get(); }
    public String getActionType() { return actionType.get(); }
    public String getUser() { return user.get(); }
    public String getDescription() { return description.get(); }
}

