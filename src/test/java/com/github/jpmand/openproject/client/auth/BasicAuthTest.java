package com.github.jpmand.openproject.client.auth;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BasicAuthTest {

    @Test
    void testBasicAuthAddsAuthorizationHeader() throws IOException {
        BasicAuth auth = new BasicAuth("username", "password");
        Interceptor interceptor = auth.getInterceptor();

        TestChain chain = new TestChain();
        interceptor.intercept(chain);

        String authHeader = chain.processedRequest.header("Authorization");
        assertNotNull(authHeader, "Authorization header should be present");
        assertTrue(authHeader.startsWith("Basic "), "Should use Basic authentication");
        
        String expectedCredentials = Credentials.basic("username", "password");
        assertEquals(expectedCredentials, authHeader);
    }

    @Test
    void testBasicAuthWithSpecialCharacters() throws IOException {
        BasicAuth auth = new BasicAuth("user@domain.com", "p@ssw0rd!");
        Interceptor interceptor = auth.getInterceptor();

        TestChain chain = new TestChain();
        interceptor.intercept(chain);

        String authHeader = chain.processedRequest.header("Authorization");
        assertNotNull(authHeader, "Authorization header should be present");
        
        String expectedCredentials = Credentials.basic("user@domain.com", "p@ssw0rd!");
        assertEquals(expectedCredentials, authHeader);
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
