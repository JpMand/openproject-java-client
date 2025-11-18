package com.github.jpmand.openproject.client.http.serialization;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class HalObjectMapper {
    private static final ObjectMapper MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

    public static ObjectMapper get() {
        return MAPPER;
    }
}
