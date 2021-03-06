package com.dataWorld.backend.Api.Services;

import com.dataWorld.backend.Api.Utils.DBinit;
import com.dataWorld.backend.Api.Model.CityModel;
import io.reactivex.Single;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.sql.ResultSet;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class CityServices {

    private final DBinit Db;
    private static final Logger LOG = LoggerFactory.getLogger(CountryServices.class);

    @Inject
    CityServices(DBinit Db) { this.Db = Db; }

public Single<List<CityModel>> getCity() {
    return Db
        .db
        .rxQuery("SELECT * FROM CITY")
            .map(x -> {
                LOG.info(" After query ");
                return x;
            })
        .map(ResultSet::getRows)
        .map(
            rows ->
                rows.stream()
                    .map( row -> {
                        var city = new CityModel();
                        city.Id = row.getInteger("Id");
                        city.Name = row.getString("Name");
                        city.CountryCode = row.getString("CountryCode");
                        city.District = row.getString("District");
                        return city;
                    })
                    .collect(Collectors.toList()));
                }
            }





