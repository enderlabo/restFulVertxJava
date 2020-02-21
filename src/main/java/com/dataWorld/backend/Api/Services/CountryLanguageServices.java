package com.dataWorld.backend.Api.Services;

import com.dataWorld.backend.Api.Utils.DBinit;
import com.dataWorld.backend.Api.Model.CountryLanguageModel;
import io.reactivex.Single;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.sql.ResultSet;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class CountryLanguageServices {

    private final DBinit Db;

    @Inject
    CountryLanguageServices(DBinit Db) { this.Db = Db; }

    private static final Logger LOG = LoggerFactory.getLogger(CountryServices.class);

    public Single<List<CountryLanguageModel>> getCountryL() {
        return Db
                .db
                .rxQuery("SELECT * FROM COUNTRYLANGUAGE")
                .map(x -> {
                    LOG.info(" äfter query ");
                    return x;
                })
                .map(ResultSet::getRows)
                .map(
                        rows ->
                                rows.stream()
                                        .map( row -> {
                                            var countryL = new CountryLanguageModel();
                                            countryL.CountryCode = row.getString("CountryCode");
                                            countryL.Language = row.getString("Language");
                                            countryL.IsOfficial = row.getString("IsOfficial");
                                            countryL.Percentage = row.getDouble("Percentage");
                                            return countryL;
                                        })
                                        .collect(Collectors.toList()));
    }
}
