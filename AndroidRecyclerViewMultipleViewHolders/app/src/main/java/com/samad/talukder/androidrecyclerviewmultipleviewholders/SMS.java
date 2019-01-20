package com.samad.talukder.androidrecyclerviewmultipleviewholders;

public class SMS {
    private String senderName, smsContent, smsTime;

    public SMS(String senderName, String smsContent, String smsTime) {
        this.senderName = senderName;
        this.smsContent = smsContent;
        this.smsTime = smsTime;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getSmsContent() {
        return smsContent;
    }

    public String getSmsTime() {
        return smsTime;
    }
}
