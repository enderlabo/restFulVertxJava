package com.dataWorld.backend.Api.Auth;


import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.KeyStoreOptions;
import io.vertx.ext.auth.User;
import io.vertx.reactivex.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTAuthOptions;
import io.vertx.ext.jwt.JWT;
import io.vertx.ext.jwt.JWTOptions;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.auth.AuthProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Auth {

    Vertx vertx;

     @Inject
    public Auth(Vertx vertx){
         this.vertx = vertx;
         JWTAuthOptions config = new JWTAuthOptions()
                 .setKeyStore(new KeyStoreOptions()
                         .setPath("keystore.jceks")
                         .setPassword("secret"));
         //Create instance of Provider JWTAuth
         JWTAuth jwtAuth = JWTAuth.create(this.vertx, config);
     }



}
