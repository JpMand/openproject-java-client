package com.github.jpmand.openproject.client.auth;

import okhttp3.Interceptor;

/**
 * Interface for authentication providers that can be used with the OpenProject client.
 * Implementations should provide OkHttp interceptors that add appropriate authentication headers.
 */
public interface AuthProvider {
    /**
     * Returns an OkHttp interceptor that adds authentication to requests.
     *
     * @return the interceptor for authentication
     */
    Interceptor getInterceptor();
}
