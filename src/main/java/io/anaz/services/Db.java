package io.anaz.services;

import java.util.List;
import java.util.UUID;

import io.anaz.models.PostResponse;
import io.anaz.models.Sms;
import io.anaz.models.SmsBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class Db {

    public List<Sms> list;

    public Db() {
        this.list = new ArrayList<>();
    }

    public List<Sms> listAll() {
        return list;
    }

    public PostResponse addData(SmsBase data) {
        try {
            var smsId = UUID.randomUUID().toString();
            var sms = new Sms(smsId, data.from, data.to, data.text);
            list.add(sms);
            return new PostResponse(true, "SMS '" + smsId + "'' added");
        } catch (Exception e) {
            return new PostResponse(false, e.getMessage());
        }

    }

    public PostResponse deleteData(String smsId) {
        try {
            var succ = list.removeIf(x -> x.smsId == smsId);
            if (succ)
                return new PostResponse(succ, "SMS '" + smsId + "' removed");
            else
                return new PostResponse(false, "Can't remove");

        } catch (Exception e) {
            return new PostResponse(false, "Exception: " + e.getMessage());
        }
    }
}
