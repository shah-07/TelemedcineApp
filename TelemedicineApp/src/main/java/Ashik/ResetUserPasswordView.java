package Ashik;

import java.io.Serializable;

public class ResetUserPasswordView implements Serializable {
    private String email;
    private String newPassword;

    public ResetUserPasswordView(String email, String newPassword) {
        this.email = email;
        this.newPassword = newPassword;
    }

    public String getEmail() {
        return email;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
