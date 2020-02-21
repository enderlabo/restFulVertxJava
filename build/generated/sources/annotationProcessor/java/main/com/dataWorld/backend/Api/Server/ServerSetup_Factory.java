package com.dataWorld.backend.Api.Server;

import com.dataWorld.backend.Api.Controller.CityController;
import com.dataWorld.backend.Api.Controller.CountryController;
import com.dataWorld.backend.Api.Controller.CountryLanguage;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ServerSetup_Factory implements Factory<ServerSetup> {
  private final Provider<CityController> cityControllerProvider;

  private final Provider<CountryController> countryControllerProvider;

  private final Provider<CountryLanguage> countryLanguageProvider;

  public ServerSetup_Factory(
      Provider<CityController> cityControllerProvider,
      Provider<CountryController> countryControllerProvider,
      Provider<CountryLanguage> countryLanguageProvider) {
    this.cityControllerProvider = cityControllerProvider;
    this.countryControllerProvider = countryControllerProvider;
    this.countryLanguageProvider = countryLanguageProvider;
  }

  @Override
  public ServerSetup get() {
    return new ServerSetup(
        cityControllerProvider.get(),
        countryControllerProvider.get(),
        countryLanguageProvider.get());
  }

  public static ServerSetup_Factory create(
      Provider<CityController> cityControllerProvider,
      Provider<CountryController> countryControllerProvider,
      Provider<CountryLanguage> countryLanguageProvider) {
    return new ServerSetup_Factory(
        cityControllerProvider, countryControllerProvider, countryLanguageProvider);
  }

  public static ServerSetup newInstance(
      CityController cityController,
      CountryController countryController,
      CountryLanguage countryLanguage) {
    return new ServerSetup(cityController, countryController, countryLanguage);
  }
}
