package com.dataWorld.backend.Api.Controller;

import com.dataWorld.backend.Api.Server.ServerSetup;
import com.dataWorld.backend.Api.Utils.HandlerHttp;
import com.dataWorld.backend.Api.Services.CityServices;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.reactivex.ext.web.Router;
import io.vertx.reactivex.ext.web.RoutingContext;

import javax.inject.Inject;
import javax.inject.Singleton;

public class CityController extends HandlerHttp {

    private static final Logger LOG = LoggerFactory.getLogger(CityController.class);

    private final CityServices cityServices;

    @Inject
    public CityController(CityServices cityServices) {
        this.cityServices = cityServices;
    }


    @Override
    public void routes(Router router) { router.get("/api/city").handler(this::handlerGetCity); }

    private void handlerGetCity(RoutingContext ctx) {


        LOG.info("handlerGetCity match ");

        cityServices.getCity()
                .subscribe(r -> this.ok(ctx, r), e -> {
                    e.printStackTrace();
                    ctx.response().setStatusCode(401).end(e.getMessage());
                });
    }
}
