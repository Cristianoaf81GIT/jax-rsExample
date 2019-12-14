
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;
import org.junit.Test;

/**
 *
 * @author cristianoaf81
 */
public class TestPost {
    
    @Test
    public void TestPostTrack(){
        try{
            Client c = Client.create();

            String url = "http://localhost:8080/RestExample/api/hello/"
                    + "json/metallica/post";

            String track = "{\"singer\":\"metallica\","
                    + "\"title\":\"Fade to Black\"}";
            
            WebResource wresource = c.resource(url);
            

            ClientResponse response = wresource
                    .type(MediaType.APPLICATION_JSON)
                    .post(ClientResponse.class,track);
            
            
            if(response.getStatus() != 201)
                throw new RuntimeException("Fail to send track, cause: "
                        +response.getStatus());
            
            System.out.println("output from server............");
            System.out.println("------------------------------");
            String output = response.getEntity(String.class);
            System.out.println(output);
                    
                    
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
