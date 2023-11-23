package io.anaz;

import java.util.ArrayList;
import java.util.List;

import io.anaz.models.PostResponse;
import io.anaz.models.Sms;
import io.anaz.models.SmsBase;
import io.anaz.services.Db;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/sms")
public class SmsEndpoints {

    @Inject
    Db db;

    @Path("count-all")
    @GET
    public int countAll() {
        return db.countAll();
    }

    @Path("/get")
    @GET
    public String get(@QueryParam("id") String id) {
        return id;
    }

    @Path("/list-all")
    @GET
    public List<Sms> listAll() {
        return db.listAll();
    }

    @Path("/add")
    @POST
    public PostResponse add(SmsBase sms) {
        var resp = db.addData(sms);        
        return resp;
    }

    @Path("delete")
    @DELETE
    public PostResponse delete(@QueryParam("id") String id) {
        return db.deleteData(id);
    }
}
