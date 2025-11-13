package com.github.jpmand.openproject.client.auth;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * Authentication provider for API Key authentication using HTTP Basic Auth.
 * The API key is sent as the password with "apikey" as the username.
 */
public class ApiKeyAuth implements AuthProvider {
    private final String apiKey;

    public ApiKeyAuth(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public Interceptor getInterceptor() {
        return new ApiKeyInterceptor(apiKey);
    }

    private static class ApiKeyInterceptor implements Interceptor {
        private final String apiKey;

        ApiKeyInterceptor(String apiKey) {
            this.apiKey = apiKey;
        }

        @NotNull
        @Override
        public Response intercept(@NotNull Chain chain) throws IOException {
            Request request = chain.request()
                    .newBuilder()
                    .header("Authorization", Credentials.basic("apikey", apiKey))
                    .build();
            return chain.proceed(request);
        }
    }
}
