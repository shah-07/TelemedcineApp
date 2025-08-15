package Ashik;

import java.io.Serializable;

public class RevenueGenerated implements Serializable {
    private String username;
    private String password;
    private double totalRevenue;

    public RevenueGenerated(String username, String password, double totalRevenue) {
        this.username = username;
        this.password = password;
        this.totalRevenue = totalRevenue;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
