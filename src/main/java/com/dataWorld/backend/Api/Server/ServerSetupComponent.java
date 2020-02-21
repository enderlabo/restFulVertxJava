package com.dataWorld.backend.Api.Server;

import dagger.Component;

import javax.inject.Singleton;

@Component
@Singleton
public interface ServerSetupComponent {
    ServerSetup get();
}
