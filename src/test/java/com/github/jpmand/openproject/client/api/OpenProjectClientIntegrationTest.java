package com.github.jpmand.openproject.client.api;

import com.github.jpmand.openproject.client.auth.ApiKeyAuth;
import com.github.jpmand.openproject.client.auth.BasicAuth;
import com.github.jpmand.openproject.client.auth.BearerTokenAuth;
import com.github.jpmand.openproject.client.http.HttpClientFactory;
import com.github.jpmand.openproject.client.http.OkHttpClientFactory;
import org.junit.jupiter.api.Test;

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
    void testCreateClientWithBasicAuth() {
        OpenProjectClient client = new OpenProjectClient(BASE_URL, new BasicAuth("username", "password"));
        assertNotNull(client, "Client should be created with basic auth");
    }

    @Test
    void testCreateClientWithBearerToken() {
        OpenProjectClient client = new OpenProjectClient(BASE_URL, new BearerTokenAuth("jwt-token"));
        assertNotNull(client, "Client should be created with bearer token");
    }

    @Test
    void testCreateClientWithCustomHttpClientFactory() {
        HttpClientFactory factory = new OkHttpClientFactory(new ApiKeyAuth("test-key"));
        OpenProjectClient client = new OpenProjectClient(BASE_URL, factory);
        assertNotNull(client, "Client should be created with custom factory");
    }

    @Test
    void testBackwardCompatibility() {
        // Legacy constructor still works
        OpenProjectClient client = new OpenProjectClient(BASE_URL, "api-token");
        assertNotNull(client, "Client should be created with legacy constructor");
    }
}
