package com.processconsulting.vertx;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

public class App {
    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();
        HttpServer resp = vertx.createHttpServer();

        //Create routes for some API
        Router router = Router.router(vertx);
        router
                .get("/api/:id")
                .handler( routingContext -> {
                    String id = routingContext.request().getParam("id"); //Get variable/data from URL.
                    System.out.println("Building WebServices with Java/Vert.x");

                    HttpServerResponse response = routingContext.response();
                    response.setChunked(true);
                    response.write("Working with Java/Vert.x" + " " + id);
                    response.end();
                });

        //Create routes for some API
        Router handler1 = router;
                router
                .get("/api/file")
                .handler( routingContext -> {
                    System.out.println("Choose your Files");
                    HttpServerResponse response = routingContext.response();
                    response.setChunked(true);
                    response.write("Choose your Files");

                    response.end();
                });

        //Create routes for some API
        Router handler2 = router;
            router
                .get("/api/photos")
                .handler( routingContext -> {
                    System.out.println("Pick a Photo");
                    HttpServerResponse response = routingContext.response();
                    response.setChunked(true);
                    response.write("Pick a Photo");
                    response.end();
                });

        //Create routes for some API
        Router handler3 = router;
            router
                .post("/api/Pphotos")
                .consumes("*/json") //Especify typedata.
                .handler( routingContext -> {
                    System.out.println("Pick a Photo from POST.");
                    HttpServerResponse response = routingContext.response();
                    response.setChunked(true);
                    response.write("Pick a Photo from POST.");
                    response.end();
                });

            //Resquest Accept - Handler
            resp
                .requestHandler(router::accept)
                .listen(8091);
    }
}
