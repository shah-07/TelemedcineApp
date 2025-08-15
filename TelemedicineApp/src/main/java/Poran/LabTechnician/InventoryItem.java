package Poran.LabTechnician;

import java.io.Serializable;

public class InventoryItem implements Serializable {

    private final String itemName, personName;
    private final int itemId, personId;
    private int quantity;
    private String status, personPosition, condition, type;

    public InventoryItem(String itemName, String personName, int itemId, int personId, String condition, String personPosition, String status, int quantity, String type) {
        this.itemName = itemName;
        this.personName = personName;
        this.itemId = itemId;
        this.personId = personId;
        this.condition = condition;
        this.personPosition = personPosition;
        this.status = status;
        this.quantity = quantity;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPersonPosition() {
        return personPosition;
    }

    public void setPersonPosition(String personPosition) {
        this.personPosition = personPosition;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPersonId() {
        return personId;
    }

    public int getItemId() {
        return itemId;
    }

    public String getPersonName() {
        return personName;
    }
}
