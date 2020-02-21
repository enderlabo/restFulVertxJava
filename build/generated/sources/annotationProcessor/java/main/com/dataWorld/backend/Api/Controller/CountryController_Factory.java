package com.dataWorld.backend.Api.Controller;

import com.dataWorld.backend.Api.Services.CountryServices;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CountryController_Factory implements Factory<CountryController> {
  private final Provider<CountryServices> countryServicesProvider;

  public CountryController_Factory(Provider<CountryServices> countryServicesProvider) {
    this.countryServicesProvider = countryServicesProvider;
  }

  @Override
  public CountryController get() {
    return new CountryController(countryServicesProvider.get());
  }

  public static CountryController_Factory create(
      Provider<CountryServices> countryServicesProvider) {
    return new CountryController_Factory(countryServicesProvider);
  }

  public static CountryController newInstance(CountryServices countryServices) {
    return new CountryController(countryServices);
  }
}
