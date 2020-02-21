package com.dataWorld.backend.Api.Controller;

import com.dataWorld.backend.Api.Utils.HandlerHttp;
import com.dataWorld.backend.Api.Services.CountryServices;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.reactivex.ext.web.Router;
import io.vertx.reactivex.ext.web.RoutingContext;

import javax.inject.Inject;
import javax.inject.Singleton;

public class CountryController extends HandlerHttp {

    private static final Logger LOG = LoggerFactory.getLogger(CountryController.class);

    private final CountryServices countryServices;

    @Inject
    public CountryController(CountryServices countryServices) {
        this.countryServices = countryServices;
    }

    @Override
    public void routes(Router router) {
        LOG.info(  "routing");
        router.get("/api/country").handler(this::handlerGetCountry);
    }

    private void handlerGetCountry(RoutingContext ctx) {

        LOG.info(" match");
        //Take method from services.
        countryServices.getCountry().subscribe(r -> this.ok(ctx, r), e -> {
            e.printStackTrace();
            ctx.response().setStatusCode(401).end(e.getMessage());
        });
    }
}
