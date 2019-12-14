

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.Test;

/**
 *
 * @author cristianoaf81
 */
public class TestGet {
    @Test
    public void testGetTrack(){
        
        try{
            Client client = Client.create();

            String url = "http://localhost:8080/RestExample/api"
                    + "/hello/json/metallica";

            WebResource webres = client.resource(url);

            ClientResponse response = webres.accept("application/json")
                    .get(ClientResponse.class);

            if(response.getStatus() != 200)
                throw new RuntimeException("Fail to get Resource, cause: "
                        +response.getStatus());

            String output = response.getEntity(String.class);
            System.out.println(output.getClass()==String.class);
            System.out.println(output);
        }catch(RuntimeException t){
            t.printStackTrace();
        }    
    }
}
