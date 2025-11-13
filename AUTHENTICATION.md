# Authentication Examples

This document provides examples of how to use different authentication methods with the OpenProject Java Client.

## API Key Authentication

The most common authentication method for OpenProject is using an API key via HTTP Basic Auth:

```java
import com.github.jpmand.openproject.client.api.OpenProjectClient;
import com.github.jpmand.openproject.client.auth.ApiKeyAuth;

// Create client with API key
OpenProjectClient client = new OpenProjectClient(
    "https://your-openproject.com",
    new ApiKeyAuth("your-api-key")
);

// Or use the legacy constructor (deprecated)
OpenProjectClient client = new OpenProjectClient(
    "https://your-openproject.com",
    "your-api-key"
);
```

## Basic Authentication

For username/password authentication:

```java
import com.github.jpmand.openproject.client.api.OpenProjectClient;
import com.github.jpmand.openproject.client.auth.BasicAuth;

OpenProjectClient client = new OpenProjectClient(
    "https://your-openproject.com",
    new BasicAuth("username", "password")
);
```

## Bearer Token Authentication (OIDC JWT)

For OIDC provider generated JWT tokens or any other bearer token:

```java
import com.github.jpmand.openproject.client.api.OpenProjectClient;
import com.github.jpmand.openproject.client.auth.BearerTokenAuth;

OpenProjectClient client = new OpenProjectClient(
    "https://your-openproject.com",
    new BearerTokenAuth("your-jwt-token")
);
```

## OAuth2 Client Credentials

For OAuth2.0 client credentials flow with automatic token refresh:

```java
import com.github.jpmand.openproject.client.api.OpenProjectClient;
import com.github.jpmand.openproject.client.auth.OAuth2ClientCredentialsAuth;

// Without scope
OpenProjectClient client = new OpenProjectClient(
    "https://your-openproject.com",
    new OAuth2ClientCredentialsAuth(
        "https://your-oauth-provider.com/token",
        "client-id",
        "client-secret"
    )
);

// With scope
OpenProjectClient client = new OpenProjectClient(
    "https://your-openproject.com",
    new OAuth2ClientCredentialsAuth(
        "https://your-oauth-provider.com/token",
        "client-id",
        "client-secret",
        "openproject.read openproject.write"
    )
);
```

The OAuth2 implementation automatically:
- Acquires tokens on first request
- Refreshes tokens before expiry
- Handles token management thread-safely

## Custom HTTP Client Factory

For advanced use cases, you can provide a custom HTTP client factory:

```java
import com.github.jpmand.openproject.client.api.OpenProjectClient;
import com.github.jpmand.openproject.client.http.HttpClientFactory;
import com.github.jpmand.openproject.client.http.OkHttpClientFactory;
import com.github.jpmand.openproject.client.auth.ApiKeyAuth;

// Create a custom factory with additional configuration
HttpClientFactory factory = new OkHttpClientFactory(new ApiKeyAuth("api-key"));

OpenProjectClient client = new OpenProjectClient(
    "https://your-openproject.com",
    factory
);
```

## Custom Retrofit Instance

For complete control, you can provide your own Retrofit instance:

```java
import com.github.jpmand.openproject.client.api.OpenProjectClient;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

OkHttpClient httpClient = new OkHttpClient.Builder()
    // Your custom configuration
    .build();

Retrofit retrofit = new Retrofit.Builder()
    .client(httpClient)
    .baseUrl("https://your-openproject.com")
    .addConverterFactory(JacksonConverterFactory.create())
    .build();

OpenProjectClient client = new OpenProjectClient(retrofit);
```
