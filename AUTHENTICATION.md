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

## Bearer Token Authentication (OIDC JWT)

For OIDC provider generated JWT tokens. This authentication method requires OpenProject to be configured with OIDC/OAuth2 authentication.

### OpenProject Configuration Requirements

Before using JWT bearer token authentication, your OpenProject instance must be properly configured:

1. **OIDC Provider Configuration**: OpenProject must be connected to an OIDC/OAuth2 provider (e.g., Keycloak, Auth0, Azure AD)
2. **JWKS Configuration**: The provider's JSON Web Key Set (JWKS) endpoint must be configured in OpenProject to validate JWT signatures
3. **Token Claims**: The JWT must contain appropriate claims that map to OpenProject users (typically `email` or `sub` claim)

For detailed configuration instructions, refer to the [OpenProject OIDC documentation](https://www.openproject.org/docs/api/introduction/#oidc-provider-generated-jwt-as-a-bearer-token).

### Usage Example

```java
import com.github.jpmand.openproject.client.api.OpenProjectClient;
import com.github.jpmand.openproject.client.auth.BearerTokenAuth;

// Use JWT token obtained from your OIDC provider
OpenProjectClient client = new OpenProjectClient(
    "https://your-openproject.com",
    new BearerTokenAuth("your-jwt-token")
);
```

**Note**: The JWT token must be obtained from your OIDC provider using appropriate OAuth2 flows (e.g., authorization code flow, client credentials flow). The token should be valid and not expired when making API requests.

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

## Custom Retrofit Instance

For advanced use cases, you can provide your own Retrofit instance with custom HTTP client configuration:

```java
import com.github.jpmand.openproject.client.api.OpenProjectClient;
import com.github.jpmand.openproject.client.auth.ApiKeyAuth;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

// Create custom OkHttpClient with your configuration
OkHttpClient httpClient = new OkHttpClient.Builder()
    .addInterceptor(new ApiKeyAuth("your-api-key").getInterceptor())
    // Add your custom configuration (timeouts, interceptors, etc.)
    .connectTimeout(30, TimeUnit.SECONDS)
    .readTimeout(30, TimeUnit.SECONDS)
    .build();

Retrofit retrofit = new Retrofit.Builder()
    .client(httpClient)
    .baseUrl("https://your-openproject.com")
    .addConverterFactory(JacksonConverterFactory.create())
    .build();

OpenProjectClient client = new OpenProjectClient(retrofit);
```
