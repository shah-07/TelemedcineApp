package Ashik;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BackupAndRestoreData implements Serializable {
    private LocalDateTime lastBackupDateTime;
    private String status; // "Success" or "Failed"

    public BackupAndRestoreData(LocalDateTime lastBackupDateTime, String status) {
        this.lastBackupDateTime = lastBackupDateTime;
        this.status = status;
    }

    public LocalDateTime getLastBackupDateTime() {
        return lastBackupDateTime;
    }

    public void setLastBackupDateTime(LocalDateTime lastBackupDateTime) {
        this.lastBackupDateTime = lastBackupDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
