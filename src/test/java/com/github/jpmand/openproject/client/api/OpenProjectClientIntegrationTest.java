package com.github.jpmand.openproject.client.api;

import com.github.jpmand.openproject.client.auth.ApiKeyAuth;
import com.github.jpmand.openproject.client.auth.BearerTokenAuth;
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
    void testCreateClientWithBearerToken() {
        OpenProjectClient client = new OpenProjectClient(BASE_URL, new BearerTokenAuth("jwt-token"));
        assertNotNull(client, "Client should be created with bearer token");
    }
}
