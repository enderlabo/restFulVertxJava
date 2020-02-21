package com.dataWorld.backend.Api.Controller;

import com.dataWorld.backend.Api.Services.CityServices;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CityController_Factory implements Factory<CityController> {
  private final Provider<CityServices> cityServicesProvider;

  public CityController_Factory(Provider<CityServices> cityServicesProvider) {
    this.cityServicesProvider = cityServicesProvider;
  }

  @Override
  public CityController get() {
    return new CityController(cityServicesProvider.get());
  }

  public static CityController_Factory create(Provider<CityServices> cityServicesProvider) {
    return new CityController_Factory(cityServicesProvider);
  }

  public static CityController newInstance(CityServices cityServices) {
    return new CityController(cityServices);
  }
}
