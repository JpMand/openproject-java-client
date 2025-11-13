package com.github.jpmand.openproject.client.http;

import com.github.jpmand.openproject.client.auth.AuthProvider;
import okhttp3.OkHttpClient;

/**
 * Default implementation of HttpClientFactory that creates OkHttpClient instances.
 */
public class OkHttpClientFactory implements HttpClientFactory {
    private final AuthProvider authProvider;

    public OkHttpClientFactory(AuthProvider authProvider) {
        this.authProvider = authProvider;
    }

    @Override
    public OkHttpClient createClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        
        if (authProvider != null) {
            builder.addInterceptor(authProvider.getInterceptor());
        }
        
        return builder.build();
    }
}
