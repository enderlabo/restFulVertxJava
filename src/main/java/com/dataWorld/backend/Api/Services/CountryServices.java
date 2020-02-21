package com.dataWorld.backend.Api.Services;

import com.dataWorld.backend.Api.Model.CountryModel;
import com.dataWorld.backend.Api.Utils.DBinit;
import io.reactivex.Single;
import io.vertx.core.json.JsonArray;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.sql.ResultSet;
import io.vertx.reactivex.ext.sql.SQLConnection;
import io.reactivex.Single;
import io.vertx.core.json.JsonArray;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class CountryServices {

    private static final Logger LOG = LoggerFactory.getLogger(CountryServices.class);
    private final DBinit Db;

    @Inject
    CountryServices(DBinit Db) { this.Db = Db; }

    public Single<List<CountryModel>> getCountry() {
        LOG.info( " on country service " );
        return Db
                .db
                .rxQuery("SELECT * FROM COUNTRY" )
                .map(x -> {
                    LOG.info(" äfter query ");
                    return x;
                })
                .map(ResultSet::getRows)
                .map(
                    rows ->
                    rows.stream()
                        .map(row -> {
                            var country = new CountryModel();
                            country.Code = row.getString("Code");
                            country.Name = row.getString("Name");
                            country.Continent = row.getString("Continent");
                            country.Region = row.getString("Region");
                            country.SurfaceArea = row.getDouble("SurfaceArea");
                            country.IndepYear = row.getInteger("IndepYear");
                            country.Population = row.getInteger("Population");
                            country.LifeExpectancy = row.getDouble("LifeExpectancy");
                            country.GNP = row.getDouble("GNP");
                            country.GNPOld = row.getDouble("GNPOld");
                            country.LocalName = row.getString("LocalName");
                            country.GovernmentForm = row.getString("GovernmentForm");
                            country.HeadOfState = row.getString("HeadOfState");
                            country.Capital = row.getInteger("Capital");
                            country.Code2 = row.getString("Code2");
                            return country;
                        })
                        .collect(Collectors.toList())
                );
                    }

}

