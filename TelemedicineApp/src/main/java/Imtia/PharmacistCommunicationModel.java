package Imtia;

public class PharmacistCommunicationModel {
    String name;
    boolean isComplete;

    public PharmacistCommunicationModel(String name, boolean isComplete) {
        this.name = name;
        this.isComplete = isComplete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
