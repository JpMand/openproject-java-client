package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;
import com.github.jpmand.openproject.client.http.serialization.HalObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OPBaseResourceTest {

    protected final ObjectMapper mapper = HalObjectMapper.get();

    public void assertBaseResource(OPBaseResource resource, String expectedResourceType){
        assertNotNull(resource, "Resource should not be null");
        assertEquals(expectedResourceType, resource.getType(), "Resource type must be match expected");
        assertNotNull(resource.getSingleLink(OPBaseResource.SELF_LINK), "Self link should not be null");
    }


    protected String loadTestResource(String resourcePath) throws IOException {
        try (InputStream is = getClass().getResourceAsStream(resourcePath)) {
            assertNotNull(is, "Test resource not found: " + resourcePath);
            final String data = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            assertNotNull(data);
            return data;
        }
    }
}
