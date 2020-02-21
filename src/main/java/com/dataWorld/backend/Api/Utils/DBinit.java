package com.dataWorld.backend.Api.Utils;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.sql.ResultSet;
import io.vertx.lang.rx.RxGen;
import io.vertx.mysqlclient.MySQLConnectOptions;
import io.vertx.mysqlclient.MySQLPool;
import io.vertx.reactivex.core.RxHelper;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.core.http.HttpClientResponse;
import io.vertx.reactivex.ext.jdbc.JDBCClient;
import io.vertx.reactivex.ext.sql.SQLClient;
import io.vertx.reactivex.ext.sql.SQLConnection;
import io.vertx.sqlclient.PoolOptions;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.RowSet;
import io.vertx.sqlclient.SqlConnection;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Objects;


@Singleton
public class DBinit {

    public JDBCClient db;

    @Inject
    public DBinit() {
        Vertx vert =  Vertx.currentContext().owner();

        JsonObject config = new JsonObject()
                .put("url", "jdbc:mysql://127.0.0.1:3306/world?autoReconnect=true")
                .put("driver_class", "com.mysql.cj.jdbc.Driver")
                .put("username", "root")
                .put("password", "102030")
                .put("max_pool_size", 30);


        db =
            JDBCClient.createShared(
                Vertx.currentContext().owner(),
                new JsonObject()
                    .put("url","jdbc:mysql://127.0.0.1:3306/world?autoReconnect=true")
                    .put("driver_class", "com.mysql.cj.jdbc.Driver")
                    .put("user", "root")
                    .put("password", "102030")
                    .put("max_pool_size", 30));

//        db = JDBCClient.createShared(vert, JsonObject.mapFrom(config),"world");

        db.rxGetConnection()
                .flatMap(con ->
                    con.rxQuery("select 1").map(ResultSet::getRows)
                        .doAfterTerminate(()-> {con.close();})
                ).subscribe(rows -> {
                    System.out.println(rows.size()>0 ? " good " :  "bad");
        });


    }
}
