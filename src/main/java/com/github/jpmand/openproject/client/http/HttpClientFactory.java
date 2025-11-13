package com.github.jpmand.openproject.client.http;

import okhttp3.OkHttpClient;

/**
 * Factory interface for creating HTTP clients.
 * This allows for different HTTP client implementations to be plugged in.
 */
public interface HttpClientFactory {
    /**
     * Creates and configures an OkHttpClient instance.
     *
     * @return the configured OkHttpClient
     */
    OkHttpClient createClient();
}
