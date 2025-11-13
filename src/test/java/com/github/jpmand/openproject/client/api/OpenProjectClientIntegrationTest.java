package com.github.jpmand.openproject.client.api;

import com.github.jpmand.openproject.client.auth.ApiKeyAuth;
import com.github.jpmand.openproject.client.auth.BearerTokenAuth;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Integration tests demonstrating different ways to create an OpenProjectClient
 * with various authentication methods.
 */
class OpenProjectClientIntegrationTest {

    private static final String BASE_URL = "https://example.openproject.com";

    @Test
    void testCreateClientWithApiKey() {
        OpenProjectClient client = new OpenProjectClient(BASE_URL, new ApiKeyAuth("my-api-key"));
        assertNotNull(client, "Client should be created with API key auth");
    }

    @Test
    void testCreateClientWithBearerToken() {
        OpenProjectClient client = new OpenProjectClient(BASE_URL, new BearerTokenAuth("jwt-token"));
        assertNotNull(client, "Client should be created with bearer token");
    }

    @Test
    void testCreateClientWithCustomRetrofit() {
        // Create custom Retrofit instance for advanced use cases
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new ApiKeyAuth("test-key").getInterceptor())
                .build();
        
        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient)
                .baseUrl(BASE_URL)
                .build();
        
        OpenProjectClient client = new OpenProjectClient(retrofit);
        assertNotNull(client, "Client should be created with custom Retrofit");
    }

    @Test
    void testBackwardCompatibility() {
        // Legacy constructor still works
        OpenProjectClient client = new OpenProjectClient(BASE_URL, "api-token");
        assertNotNull(client, "Client should be created with legacy constructor");
    }
}
