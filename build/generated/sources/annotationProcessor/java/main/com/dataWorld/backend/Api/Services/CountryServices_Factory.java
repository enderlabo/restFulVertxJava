package com.dataWorld.backend.Api.Services;

import com.dataWorld.backend.Api.Utils.DBinit;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CountryServices_Factory implements Factory<CountryServices> {
  private final Provider<DBinit> dbProvider;

  public CountryServices_Factory(Provider<DBinit> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public CountryServices get() {
    return new CountryServices(dbProvider.get());
  }

  public static CountryServices_Factory create(Provider<DBinit> dbProvider) {
    return new CountryServices_Factory(dbProvider);
  }

  public static CountryServices newInstance(DBinit Db) {
    return new CountryServices(Db);
  }
}
