package com.github.jpmand.openproject.client.auth;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * Authentication provider for Bearer token authentication.
 * This can be used with OIDC provider generated JWT tokens or any other bearer token.
 */
public class BearerTokenAuth implements AuthProvider {
    private final String token;

    public BearerTokenAuth(String token) {
        this.token = token;
    }

    @Override
    public Interceptor getInterceptor() {
        return new BearerTokenInterceptor(token);
    }

    private static class BearerTokenInterceptor implements Interceptor {
        private final String token;

        BearerTokenInterceptor(String token) {
            this.token = token;
        }

        @NotNull
        @Override
        public Response intercept(@NotNull Chain chain) throws IOException {
            Request request = chain.request()
                    .newBuilder()
                    .header("Authorization", "Bearer " + token)
                    .build();
            return chain.proceed(request);
        }
    }
}
