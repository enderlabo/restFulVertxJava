package com.dataWorld.backend.Api.Auth;

import dagger.internal.Factory;
import io.vertx.reactivex.core.Vertx;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Auth_Factory implements Factory<Auth> {
  private final Provider<Vertx> vertxProvider;

  public Auth_Factory(Provider<Vertx> vertxProvider) {
    this.vertxProvider = vertxProvider;
  }

  @Override
  public Auth get() {
    return new Auth(vertxProvider.get());
  }

  public static Auth_Factory create(Provider<Vertx> vertxProvider) {
    return new Auth_Factory(vertxProvider);
  }

  public static Auth newInstance(Vertx vertx) {
    return new Auth(vertx);
  }
}
