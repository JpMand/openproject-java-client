package com.github.jpmand.openproject.client.auth;

/**
 * Authentication provider for API Key authentication using HTTP Basic Auth.
 * The API key is sent as the password with "apikey" as the username.
 */
public class ApiKeyAuth extends BasicAuth {
    
    public ApiKeyAuth(String apiKey) {
        super("apikey", apiKey);
    }
}
