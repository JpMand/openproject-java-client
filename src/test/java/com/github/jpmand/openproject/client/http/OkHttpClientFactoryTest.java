package com.github.jpmand.openproject.client.http;

import com.github.jpmand.openproject.client.auth.ApiKeyAuth;
import com.github.jpmand.openproject.client.auth.AuthProvider;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OkHttpClientFactoryTest {

    @Test
    void testCreateClientWithAuthProvider() {
        AuthProvider authProvider = new ApiKeyAuth("test-key");
        OkHttpClientFactory factory = new OkHttpClientFactory(authProvider);

        OkHttpClient client = factory.createClient();

        assertNotNull(client, "Client should not be null");
        assertFalse(client.interceptors().isEmpty(), "Client should have interceptors");
    }

    @Test
    void testCreateClientWithoutAuthProvider() {
        OkHttpClientFactory factory = new OkHttpClientFactory(null);

        OkHttpClient client = factory.createClient();

        assertNotNull(client, "Client should not be null");
        assertTrue(client.interceptors().isEmpty(), "Client should not have interceptors when auth is null");
    }

    @Test
    void testFactoryCreatesNewInstances() {
        AuthProvider authProvider = new ApiKeyAuth("test-key");
        OkHttpClientFactory factory = new OkHttpClientFactory(authProvider);

        OkHttpClient client1 = factory.createClient();
        OkHttpClient client2 = factory.createClient();

        assertNotSame(client1, client2, "Factory should create new instances");
    }
}
