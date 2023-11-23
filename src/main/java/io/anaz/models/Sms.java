package io.anaz.models;

import java.time.Instant;

public class Sms extends SmsBase {
    public Sms(String smsId, String from, String to, String text) {
        super(from, to, text);
        this.smsId = smsId;
        this.createdTimeUtc = Instant.now();
    }
    public String smsId;
    public Instant createdTimeUtc;
}
