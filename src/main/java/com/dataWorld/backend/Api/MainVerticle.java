package com.dataWorld.backend.Api;

import com.dataWorld.backend.Api.Server.DaggerServerSetupComponent;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import javax.inject.Singleton;

@Singleton
public class MainVerticle extends AbstractVerticle {


    @Override
    public void start(Future<Void> startFuture) {
        DaggerServerSetupComponent.create().get().setup();
    }


}
