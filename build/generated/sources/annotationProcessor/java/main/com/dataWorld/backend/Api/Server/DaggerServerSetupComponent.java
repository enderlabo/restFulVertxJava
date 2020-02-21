package com.dataWorld.backend.Api.Server;

import com.dataWorld.backend.Api.Controller.CityController;
import com.dataWorld.backend.Api.Controller.CityController_Factory;
import com.dataWorld.backend.Api.Controller.CountryController;
import com.dataWorld.backend.Api.Controller.CountryController_Factory;
import com.dataWorld.backend.Api.Controller.CountryLanguage;
import com.dataWorld.backend.Api.Controller.CountryLanguage_Factory;
import com.dataWorld.backend.Api.Services.CityServices;
import com.dataWorld.backend.Api.Services.CityServices_Factory;
import com.dataWorld.backend.Api.Services.CountryLanguageServices;
import com.dataWorld.backend.Api.Services.CountryLanguageServices_Factory;
import com.dataWorld.backend.Api.Services.CountryServices;
import com.dataWorld.backend.Api.Services.CountryServices_Factory;
import com.dataWorld.backend.Api.Utils.DBinit;
import com.dataWorld.backend.Api.Utils.DBinit_Factory;
import dagger.internal.DoubleCheck;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerServerSetupComponent implements ServerSetupComponent {
  private Provider<DBinit> dBinitProvider;

  private Provider<CityServices> cityServicesProvider;

  private Provider<CityController> cityControllerProvider;

  private Provider<CountryServices> countryServicesProvider;

  private Provider<CountryController> countryControllerProvider;

  private Provider<CountryLanguageServices> countryLanguageServicesProvider;

  private Provider<CountryLanguage> countryLanguageProvider;

  private Provider<ServerSetup> serverSetupProvider;

  private DaggerServerSetupComponent() {

    initialize();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static ServerSetupComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize() {
    this.dBinitProvider = DoubleCheck.provider(DBinit_Factory.create());
    this.cityServicesProvider = DoubleCheck.provider(CityServices_Factory.create(dBinitProvider));
    this.cityControllerProvider = CityController_Factory.create(cityServicesProvider);
    this.countryServicesProvider =
        DoubleCheck.provider(CountryServices_Factory.create(dBinitProvider));
    this.countryControllerProvider = CountryController_Factory.create(countryServicesProvider);
    this.countryLanguageServicesProvider =
        DoubleCheck.provider(CountryLanguageServices_Factory.create(dBinitProvider));
    this.countryLanguageProvider = CountryLanguage_Factory.create(countryLanguageServicesProvider);
    this.serverSetupProvider =
        DoubleCheck.provider(
            ServerSetup_Factory.create(
                cityControllerProvider, countryControllerProvider, countryLanguageProvider));
  }

  @Override
  public ServerSetup get() {
    return serverSetupProvider.get();
  }

  public static final class Builder {
    private Builder() {}

    public ServerSetupComponent build() {
      return new DaggerServerSetupComponent();
    }
  }
}
