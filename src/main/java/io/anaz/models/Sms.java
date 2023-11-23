package io.anaz.models;

import java.time.Instant;

public class Sms extends SmsBase {
    public Sms(String smsId, String from, String to, String text) {
        super(smsId, from, to, text);
        this.smsId = smsId;
        this.createdTimeUtc = Instant.now();
    }

    public Sms(String smsId, String from, String to, String text, Instant createdTimeUtc) {
        super(smsId, from, to, text);
        this.smsId = smsId;
        this.createdTimeUtc = createdTimeUtc;
    }
    public String smsId;
    public Instant createdTimeUtc;
}
