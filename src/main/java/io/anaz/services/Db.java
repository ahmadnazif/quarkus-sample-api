package io.anaz.services;

import java.util.List;
import java.util.Map;
import io.anaz.models.PostResponse;
import io.anaz.models.Sms;
import io.anaz.models.SmsBase;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.HashMap;

@Singleton
public class Db {

    public Map<String, Sms> map;

    public Db() {
        map = new HashMap<>();
    }

    public int countAll() {
        return map.size();
    }

    public Sms get(String id) {
        return map.get(id);
    }

    public List<Sms> listAll() {
        return new ArrayList<Sms>(map.values());
    }

    public PostResponse addData(SmsBase data) {
        try {
            var sms = new Sms(data.smsId, data.from, data.to, data.text);
            map.put(data.smsId, sms);
            return new PostResponse(true, "SMS '" + data.smsId + "' added");
        } catch (Exception e) {
            return new PostResponse(false, e.getMessage());
        }
    }

    public PostResponse editData(SmsBase data) {
        try {
            var sms = map.get(data.smsId);
            if (sms == null) {
                return addData(data);
            } else {
                map.remove(data.smsId, sms);
                map.put(sms.smsId, new Sms(sms.smsId, sms.from, sms.to, sms.text, sms.createdTimeUtc));
                return new PostResponse(true, "SMS '" + data.smsId + "' updated");
            }

        } catch (Exception e) {
            return new PostResponse(false, e.getMessage());
        }
    }

    public PostResponse deleteData(String smsId) {
        try {

            var sms = map.get(smsId);
            if (sms == null)
                return new PostResponse(false, "SMS '" + smsId + "' not found");
            else {
                var succ = map.remove(smsId, sms);
                return new PostResponse(succ, "SMS '" + smsId + "' removed");
            }
        } catch (Exception e) {
            return new PostResponse(false, "Exception: " + e.getMessage());
        }
    }
}
