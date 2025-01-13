@Path("/hello")

public class hello {

    @GET

    public String sayHello() {

        return "Hello World";

    }

}