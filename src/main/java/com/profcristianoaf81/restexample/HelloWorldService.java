package com.profcristianoaf81.restexample;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author cristianoaf81
 */
@Path("/hello")
public class HelloWorldService {
    
    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg)
    {
        String output = "Jersey says: "+msg;
        
        return Response.status(200).entity(output).build();
    }
    
    @GET
    @Path("/json/metallica")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Track> getJsonTrack()
    {
        List<Track> tracks = new ArrayList<>();
        Track track = new Track();
        track.setTitle("enter sandman");
        track.setSinger("Metallica");
        Track track2 = new Track();
        track2.setTitle("For Whom the bell tolls");
        track2.setSinger("metallica");
        tracks.add(track);
        tracks.add(track2);
           
        return tracks;
        
        
    }
    
    @POST
    @Path("/json/metallica/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNewTrack(Track t){
        String result = "saved : " + t;
        return Response.status(201).entity(result).build();
    }
}
