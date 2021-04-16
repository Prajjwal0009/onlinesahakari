import com.google.gson.Gson;
import controller.*;
import model.AreaModel;

import static spark.Spark.*;

public class Entry {
    public static void main(String[] args) {

        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request
                    .headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders
                    != null) {
                response.header("Access-Control-Allow-Headers",
                        accessControlRequestHeaders); }

            String accessControlRequestMethod = request
                    .headers("Access-Control-Request-Method"); if (accessControlRequestMethod !=
                    null) { response.header("Access-Control-Allow-Methods",
                    accessControlRequestMethod); }

            return "OK"; });

        before((request, response) -> response.header("Access-Control-Allow-Origin",
                "*"));

        port(1234);
        Utility.Register(new CollectorController());
        Utility.Register(new CustomerController());
        Utility.Register(new CollectionController());
        Utility.Register(new CollectorAreaMappingController());
        Utility.Register(new AreaModelController());
        Utility.Register(new UserController());


    }
}