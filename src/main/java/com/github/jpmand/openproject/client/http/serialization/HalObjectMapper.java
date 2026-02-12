package com.github.jpmand.openproject.client.http.serialization;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Provides a configured ObjectMapper for HAL+JSON serialization/deserialization.
 */
public class HalObjectMapper {
    private static final ObjectMapper MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

    /**
     * Gets the shared ObjectMapper instance configured for HAL+JSON.
     * @return the configured ObjectMapper
     */
    public static ObjectMapper get() {
        return MAPPER;
    }
}
