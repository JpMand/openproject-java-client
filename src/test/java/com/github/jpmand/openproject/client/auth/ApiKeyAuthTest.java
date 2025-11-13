package com.github.jpmand.openproject.client.auth;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ApiKeyAuthTest {

    @Test
    void testApiKeyAuthAddsBasicAuthHeader() throws IOException {
        ApiKeyAuth auth = new ApiKeyAuth("test-api-key");
        Interceptor interceptor = auth.getInterceptor();

        TestChain chain = new TestChain();
        interceptor.intercept(chain);

        String authHeader = chain.processedRequest.header("Authorization");
        assertNotNull(authHeader, "Authorization header should be present");
        assertTrue(authHeader.startsWith("Basic "), "Should use Basic authentication");
        
        String expectedCredentials = Credentials.basic("apikey", "test-api-key");
        assertEquals(expectedCredentials, authHeader);
    }

    @Test
    void testApiKeyAuthWithEmptyKey() throws IOException {
        ApiKeyAuth auth = new ApiKeyAuth("");
        Interceptor interceptor = auth.getInterceptor();

        TestChain chain = new TestChain();
        interceptor.intercept(chain);

        String authHeader = chain.processedRequest.header("Authorization");
        assertNotNull(authHeader, "Authorization header should be present even with empty key");
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
