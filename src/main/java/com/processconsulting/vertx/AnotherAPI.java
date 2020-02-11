package com.processconsulting.vertx;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

import java.util.ArrayList;
import java.util.List;


public class AnotherAPI {
    public static void main(String[] arg) {

        List<Employees> employeesList = new ArrayList<>();

        Vertx vertx = Vertx.vertx(); //Instance an obj of Vert.x
        HttpServer sv = vertx.createHttpServer(); //Create a Server HTTP

        Router router = Router.router(vertx); // Create route with instance of vert.x
                //*******************************************************************//
                /////////***********P O S T***************************************/////
        Route postHandler = router.post("/api/addEmployes").handler(BodyHandler.create()).handler(routingContext -> {
            final Employees employees = Json.decodeValue( routingContext.getBody(), Employees.class );
            HttpServerResponse resp = routingContext.response();
            resp.setChunked(true);
            employeesList.add(employees); // Add data from POST to ArrayList.
            resp.end( employeesList.size() + " Employe added successfully. . . " );
        });

        //*****************************************************************//
            /////////*********** G E T **********************************///
            Route getHandler = router.get("/api/getEmployes").produces("*/json").handler( routingContext -> {
            routingContext.response()
                .setChunked(true)
                .end( Json.encodePrettily( employeesList ));
        });
        //*****************************************************************//
        /////////*********** G E T WITH FILTER ******************************///

        Route getFilterHandler = router.get("/api/getEmploye/:id").produces("*/json").handler( routingContext -> {
            String id = routingContext.request().getParam("id"); //Get id from URL.
            routingContext.response()
              .setChunked(true)
              .end( Json.encodePrettily( employeesList.stream().filter( e -> e.getName().equals(id)).findFirst().get() ));

        });

        //Output from Server
        sv.requestHandler( router::accept ).listen(9090);
    }
}
