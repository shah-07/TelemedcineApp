package Imtia;

import java.time.LocalDate;

public class ExpMedicineModel {
    private String name;
    private LocalDate expiryDate;

    public ExpMedicineModel(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "ExpMedicineModel{" +
                "name='" + name + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
