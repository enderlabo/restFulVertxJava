package com.dataWorld.backend.Api.Controller;

import com.dataWorld.backend.Api.Services.CountryLanguageServices;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CountryLanguage_Factory implements Factory<CountryLanguage> {
  private final Provider<CountryLanguageServices> countryLanguageProvider;

  public CountryLanguage_Factory(Provider<CountryLanguageServices> countryLanguageProvider) {
    this.countryLanguageProvider = countryLanguageProvider;
  }

  @Override
  public CountryLanguage get() {
    return new CountryLanguage(countryLanguageProvider.get());
  }

  public static CountryLanguage_Factory create(
      Provider<CountryLanguageServices> countryLanguageProvider) {
    return new CountryLanguage_Factory(countryLanguageProvider);
  }

  public static CountryLanguage newInstance(CountryLanguageServices countryLanguage) {
    return new CountryLanguage(countryLanguage);
  }
}
