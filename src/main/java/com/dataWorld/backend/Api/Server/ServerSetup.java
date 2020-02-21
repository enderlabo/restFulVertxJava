package com.dataWorld.backend.Api.Server;

import com.dataWorld.backend.Api.Controller.CityController;
import com.dataWorld.backend.Api.Controller.CountryController;
import com.dataWorld.backend.Api.Controller.CountryLanguage;
import com.dataWorld.backend.Api.Services.CountryServices;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.Router;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ServerSetup {

    private static final Logger LOG = LoggerFactory.getLogger(ServerSetup.class);

    private final CityController cityController;
    private final CountryController countryController;
    private final CountryLanguage countryLanguage;


    @Inject
    public ServerSetup(CityController cityController, CountryController countryController, CountryLanguage countryLanguage) {
        this.cityController = cityController;
        this.countryController = countryController;
        this.countryLanguage = countryLanguage;

    }

    public void setup(){
//Init configuration server
        Vertx vert = Vertx.currentContext().owner(); //Declared Main Thread.

        var server = vert.createHttpServer();
        Router router = Router.router(vert);

 //logg error
//        router
//        .route("/*")
//        .produces("application/json")
//        .consumes("application/json")
//        .failureHandler(
//                ctx -> {
//                    final JsonObject json =
//                            new JsonObject()
//                                    .put("timestamp", System.nanoTime())
//                                    .put("status", ctx.statusCode())
//                                    .put("error", HttpResponseStatus.valueOf(ctx.statusCode()).reasonPhrase())
//                                    .put("path", ctx.request().path());
//
//                    final String message = ctx.get("message");
//
//                    if (message != null) {
//                        json.put("message", message);
//                        LOG.error(message);
//                    }
//
//                    var final_msg = json.encodePrettily();
//
//                    ctx.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
//                    ctx.response().end(final_msg);
//                });



        //Controllers
        this.countryController.routes(router);
        this.cityController.routes(router);
        this.countryLanguage.routes(router);



        int port = 8081;
        server.requestHandler(router).rxListen(port)
                .subscribe(
                        s -> {
                            LOG.info("Server listening on port " + port);
                        },
                        failure -> {
                            LOG.error(failure.getMessage());
                            System.exit(0);
                        });

    }

}
