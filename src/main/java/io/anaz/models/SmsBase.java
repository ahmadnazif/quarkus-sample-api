package io.anaz.models;

public class SmsBase {
    public String from;
    public String to;
    public String text;

    public SmsBase(String from, String to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
    }
}
