package com.github.jpmand.openproject.client.auth;

/**
 * Authentication provider for API Key authentication using HTTP Basic Auth.
 * The API key is sent as the password with "apikey" as the username.
 */
public class ApiKeyAuth extends BasicAuth {
    
    /**
     * Constructs an API key auth provider.
     * @param apiKey the API key
     */
    public ApiKeyAuth(String apiKey) {
        super("apikey", apiKey);
    }
}
