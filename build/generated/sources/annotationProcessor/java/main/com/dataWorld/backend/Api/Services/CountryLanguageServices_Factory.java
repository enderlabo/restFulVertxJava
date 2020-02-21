package com.dataWorld.backend.Api.Services;

import com.dataWorld.backend.Api.Utils.DBinit;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CountryLanguageServices_Factory implements Factory<CountryLanguageServices> {
  private final Provider<DBinit> dbProvider;

  public CountryLanguageServices_Factory(Provider<DBinit> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public CountryLanguageServices get() {
    return new CountryLanguageServices(dbProvider.get());
  }

  public static CountryLanguageServices_Factory create(Provider<DBinit> dbProvider) {
    return new CountryLanguageServices_Factory(dbProvider);
  }

  public static CountryLanguageServices newInstance(DBinit Db) {
    return new CountryLanguageServices(Db);
  }
}
