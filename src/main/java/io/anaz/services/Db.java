package io.anaz.services;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import io.anaz.models.PostResponse;
import io.anaz.models.Sms;
import io.anaz.models.SmsBase;
//import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.HashMap;

//@ApplicationScoped
@Singleton
public class Db {

    // public List<Sms> list;
    public Map<String, Sms> map;

    public Db() {
        // this.list = new ArrayList<>();
        map = new HashMap<>();
    }

    public int countAll() {
        return map.size();
    }

    public Sms get(String id){
        return map.get(id);
    }

    public List<Sms> listAll() {
        return new ArrayList<Sms>(map.values());
    }

    public PostResponse addData(SmsBase data) {
        try {
            var smsId = UUID.randomUUID().toString();
            var sms = new Sms(smsId, data.from, data.to, data.text);
            map.put(smsId, sms);
            return new PostResponse(true, "SMS '" + smsId + "'' added");
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
