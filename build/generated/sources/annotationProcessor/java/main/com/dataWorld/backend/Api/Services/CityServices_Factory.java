package com.dataWorld.backend.Api.Services;

import com.dataWorld.backend.Api.Utils.DBinit;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CityServices_Factory implements Factory<CityServices> {
  private final Provider<DBinit> dbProvider;

  public CityServices_Factory(Provider<DBinit> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public CityServices get() {
    return new CityServices(dbProvider.get());
  }

  public static CityServices_Factory create(Provider<DBinit> dbProvider) {
    return new CityServices_Factory(dbProvider);
  }

  public static CityServices newInstance(DBinit Db) {
    return new CityServices(Db);
  }
}
