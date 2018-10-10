package com.virus_men.androidrecyclerviewscrollingexample.rv_vertical;

public class VerticalModel {
    private String emailSender;
    private String emailTitle;
    private String emailDetails;
    private String emailDate;

    public VerticalModel() {
    }

    public VerticalModel(String emailSender, String emailTitle, String emailDetails, String emailDate) {
        this.emailSender = emailSender;
        this.emailTitle = emailTitle;
        this.emailDetails = emailDetails;
        this.emailDate = emailDate;
    }

    public String getEmailSender() {
        return emailSender;
    }

    public String getEmailTitle() {
        return emailTitle;
    }

    public String getEmailDetails() {
        return emailDetails;
    }

    public String getEmailDate() {
        return emailDate;
    }
}
