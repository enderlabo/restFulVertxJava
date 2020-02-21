package com.dataWorld.backend.Api;

import io.vertx.core.DeploymentOptions;
import io.vertx.reactivex.core.Vertx;

import java.util.Map;

public class ServerHttp {

    public static void main(String[] args) {

        Vertx vert = Vertx.vertx();
        DeploymentOptions options = new DeploymentOptions().setInstances(Runtime.getRuntime().availableProcessors());

        vert.deployVerticle(MainVerticle::new, options); //Deploy main Thread

    }
}
