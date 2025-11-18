package com.github.jpmand.openproject.client.auth;

import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class AnonymousAuth implements AuthProvider {

    public AnonymousAuth() {
    }

    @Override
    public Interceptor getInterceptor() {
        return new AnonymousInterceptor();
    }

    private static class AnonymousInterceptor implements Interceptor {

        AnonymousInterceptor() {
        }

        @NotNull
        @Override
        public Response intercept(@NotNull Chain chain) throws IOException {
            return chain.proceed(chain.request());
        }
    }
}
