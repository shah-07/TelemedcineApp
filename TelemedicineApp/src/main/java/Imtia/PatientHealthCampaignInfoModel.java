package Imtia;

public class PatientHealthCampaignInfoModel {
    private String date;
    private String campaignDescription;

    public PatientHealthCampaignInfoModel(String date, String campaignDescription) {
        this.date = date;
        this.campaignDescription = campaignDescription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCampaignDescription() {
        return campaignDescription;
    }

    public void setCampaignDescription(String campaignDescription) {
        this.campaignDescription = campaignDescription;
    }
}
