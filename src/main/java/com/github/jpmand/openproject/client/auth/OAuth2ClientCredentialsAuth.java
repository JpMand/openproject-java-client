package com.github.jpmand.openproject.client.auth;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Authentication provider for OAuth2 Client Credentials flow.
 * Automatically handles token acquisition and refresh.
 */
public class OAuth2ClientCredentialsAuth implements AuthProvider {
    private final String tokenUrl;
    private final String clientId;
    private final String clientSecret;
    private final String scope;
    
    private String accessToken;
    private long tokenExpiresAt;
    private final Lock tokenLock = new ReentrantLock();

    public OAuth2ClientCredentialsAuth(String tokenUrl, String clientId, String clientSecret) {
        this(tokenUrl, clientId, clientSecret, null);
    }

    public OAuth2ClientCredentialsAuth(String tokenUrl, String clientId, String clientSecret, String scope) {
        this.tokenUrl = tokenUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.scope = scope;
    }

    @Override
    public Interceptor getInterceptor() {
        return new OAuth2Interceptor(this);
    }

    private void ensureValidToken() throws IOException {
        tokenLock.lock();
        try {
            if (accessToken == null || System.currentTimeMillis() >= tokenExpiresAt) {
                refreshToken();
            }
        } finally {
            tokenLock.unlock();
        }
    }

    private void refreshToken() throws IOException {
        OkHttpClient client = new OkHttpClient();
        
        FormBody.Builder formBuilder = new FormBody.Builder()
                .add("grant_type", "client_credentials")
                .add("client_id", clientId)
                .add("client_secret", clientSecret);
        
        if (scope != null && !scope.isEmpty()) {
            formBuilder.add("scope", scope);
        }

        Request request = new Request.Builder()
                .url(tokenUrl)
                .post(formBuilder.build())
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Failed to obtain OAuth2 token: " + response.code());
            }

            ResponseBody body = response.body();
            if (body != null) {
                String responseBody = body.string();
                accessToken = parseAccessToken(responseBody);
                int expiresIn = parseExpiresIn(responseBody);
                tokenExpiresAt = System.currentTimeMillis() + (expiresIn - 60) * 1000L;
            }
        }
    }

    private String parseAccessToken(String json) {
        int start = json.indexOf("\"access_token\":\"");
        if (start == -1) return null;
        start += 16;
        int end = json.indexOf("\"", start);
        return json.substring(start, end);
    }

    private int parseExpiresIn(String json) {
        int start = json.indexOf("\"expires_in\":");
        if (start == -1) return 3600;
        start += 13;
        int end = json.indexOf(",", start);
        if (end == -1) end = json.indexOf("}", start);
        String value = json.substring(start, end).trim();
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 3600;
        }
    }

    private static class OAuth2Interceptor implements Interceptor {
        private final OAuth2ClientCredentialsAuth auth;

        OAuth2Interceptor(OAuth2ClientCredentialsAuth auth) {
            this.auth = auth;
        }

        @NotNull
        @Override
        public Response intercept(@NotNull Chain chain) throws IOException {
            auth.ensureValidToken();
            Request request = chain.request()
                    .newBuilder()
                    .header("Authorization", "Bearer " + auth.accessToken)
                    .build();
            return chain.proceed(request);
        }
    }
}
