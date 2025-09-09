package com.github.jpmand.openproject.client.core.transport;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class ApiTokenAuthenticator implements Interceptor {
    private final String username;
    private final String password;

    public ApiTokenAuthenticator(String password) {
        this("apikey", password);
    }

    public ApiTokenAuthenticator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
                .header("Authorization", Credentials.basic(username, password))
                .build();
        return chain.proceed(request);
    }
}
