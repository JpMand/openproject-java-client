package com.github.jpmand.openproject.client.auth;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BearerTokenAuthTest {

    @Test
    void testBearerTokenAuthAddsAuthorizationHeader() throws IOException {
        BearerTokenAuth auth = new BearerTokenAuth("test-jwt-token");
        Interceptor interceptor = auth.getInterceptor();

        TestChain chain = new TestChain();
        interceptor.intercept(chain);

        String authHeader = chain.processedRequest.header("Authorization");
        assertNotNull(authHeader, "Authorization header should be present");
        assertEquals("Bearer test-jwt-token", authHeader);
    }

    @Test
    void testBearerTokenAuthWithJWT() throws IOException {
        String jwtToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
        BearerTokenAuth auth = new BearerTokenAuth(jwtToken);
        Interceptor interceptor = auth.getInterceptor();

        TestChain chain = new TestChain();
        interceptor.intercept(chain);

        String authHeader = chain.processedRequest.header("Authorization");
        assertNotNull(authHeader, "Authorization header should be present");
        assertEquals("Bearer " + jwtToken, authHeader);
    }

    private static class TestChain implements Interceptor.Chain {
        private final Request originalRequest = new Request.Builder()
                .url("https://example.com/api/test")
                .build();
        private Request processedRequest;

        @NotNull
        @Override
        public Request request() {
            return originalRequest;
        }

        @NotNull
        @Override
        public Response proceed(@NotNull Request request) throws IOException {
            this.processedRequest = request;
            return new Response.Builder()
                    .request(request)
                    .protocol(Protocol.HTTP_1_1)
                    .code(200)
                    .message("OK")
                    .body(ResponseBody.create("", null))
                    .build();
        }

        @NotNull
        @Override
        public Connection connection() {
            return null;
        }

        @NotNull
        @Override
        public Call call() {
            return null;
        }

        @Override
        public int connectTimeoutMillis() {
            return 0;
        }

        @NotNull
        @Override
        public Interceptor.Chain withConnectTimeout(int timeout, @NotNull java.util.concurrent.TimeUnit unit) {
            return this;
        }

        @Override
        public int readTimeoutMillis() {
            return 0;
        }

        @NotNull
        @Override
        public Interceptor.Chain withReadTimeout(int timeout, @NotNull java.util.concurrent.TimeUnit unit) {
            return this;
        }

        @Override
        public int writeTimeoutMillis() {
            return 0;
        }

        @NotNull
        @Override
        public Interceptor.Chain withWriteTimeout(int timeout, @NotNull java.util.concurrent.TimeUnit unit) {
            return this;
        }
    }
}
