package com.dataWorld.backend.Api.Controller;

import com.dataWorld.backend.Api.Utils.HandlerHttp;
import com.dataWorld.backend.Api.Services.CountryLanguageServices;
import io.vertx.reactivex.ext.web.Router;
import io.vertx.reactivex.ext.web.RoutingContext;

import javax.inject.Inject;
import javax.inject.Singleton;

public class CountryLanguage extends HandlerHttp {

    private final CountryLanguageServices countryLanguage;

    @Inject
    public CountryLanguage(CountryLanguageServices countryLanguage) {
        this.countryLanguage = countryLanguage;
    }

    @Override
    public void routes(Router router) { router.get("/api/countryLanguage").handler(this::handlerGetCountryL); }

private void handlerGetCountryL(RoutingContext ctx) {
    //Take method from services.
    countryLanguage.getCountryL()
            .subscribe( Object::notify );
    }
}
