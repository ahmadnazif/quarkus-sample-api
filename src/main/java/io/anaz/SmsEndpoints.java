package io.anaz;

import java.util.List;
import java.util.UUID;

import io.anaz.models.PostResponse;
import io.anaz.models.Sms;
import io.anaz.models.SmsBase;
import io.anaz.services.Db;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/sms")
public class SmsEndpoints {

    @Inject
    Db db;

    @Path("/count-all")
    @GET
    public int countAll() {
        return db.countAll();
    }

    @Path("/get")
    @GET
    public Sms get(@QueryParam("id") String id) {
        return db.get(id);
    }

    @Path("/list-all")
    @GET
    public List<Sms> listAll() {
        return db.listAll();
    }

    @Path("/add")
    @POST
    public PostResponse add(SmsBase sms) {
        sms.smsId = UUID.randomUUID().toString();
        var resp = db.addData(sms);
        return resp;
    }

    @Path("/edit")
    @POST
    public PostResponse edit(SmsBase sms) {
        var resp = db.editData(sms);
        return resp;
    }

    @Path("/delete")
    @DELETE
    public PostResponse delete(@QueryParam("id") String id) {
        return db.deleteData(id);
    }
}
