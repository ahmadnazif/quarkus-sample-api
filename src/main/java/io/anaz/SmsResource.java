package io.anaz;

import java.util.ArrayList;

import io.quarkus.arc.lookup.LookupIfProperty.List;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/sms")
public class SmsResource {
    
    @GET
    public String get(){
        return "/";
    }

    @GET
    @Path("/list-all")
    public ArrayList<String> listAll(){
        return new ArrayList<>();
    }
}
