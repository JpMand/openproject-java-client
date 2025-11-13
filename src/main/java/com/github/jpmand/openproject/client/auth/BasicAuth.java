package com.github.jpmand.openproject.client.auth;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * Authentication provider for HTTP Basic Auth using username and password.
 * This class is package-private as username/password authentication is no longer allowed in OpenProject.
 * It's kept for internal use by ApiKeyAuth.
 */
class BasicAuth implements AuthProvider {
    private final String username;
    private final String password;

    BasicAuth(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Interceptor getInterceptor() {
        return new BasicAuthInterceptor(username, password);
    }

    private static class BasicAuthInterceptor implements Interceptor {
        private final String username;
        private final String password;

        BasicAuthInterceptor(String username, String password) {
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
}
