package com.dataWorld.backend.Api.Utils;

import dagger.internal.Factory;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DBinit_Factory implements Factory<DBinit> {
  private static final DBinit_Factory INSTANCE = new DBinit_Factory();

  @Override
  public DBinit get() {
    return new DBinit();
  }

  public static DBinit_Factory create() {
    return INSTANCE;
  }

  public static DBinit newInstance() {
    return new DBinit();
  }
}
