package io.anaz.models;

public class SmsBase {
    public String smsId;
    public String from;
    public String to;
    public String text;

    public SmsBase(String smsId, String from, String to, String text) {
        this.smsId = smsId;
        this.from = from;
        this.to = to;
        this.text = text;
    }
}
