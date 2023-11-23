package io.anaz;

import java.util.ArrayList;

import io.anaz.models.PostResponse;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/sms")
public class SmsEndpoints {

    @Path("count-all")
    @GET
    public int countAll() {
        return 0;
    }

    @Path("/get")
    @GET
    public String get(@QueryParam("id") String id){
        return id;
    }

    @Path("/list-all")
    @GET
    public ArrayList<String> listAll() {
        return new ArrayList<>();
    }

    @Path("/add")
    @POST
    public PostResponse add() {
        var pr = new PostResponse();
        pr.isSuccess = true;
        pr.message = "OK";
        return pr;
    }

    @Path("edit")
    @PUT
    public String edit(){
        return "";
    }

    @Path("delete")
    @DELETE
    public String delete(){
        return "";
    }
}
