package com.github.jpmand.openproject.client.api.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OPActivityModelTest extends OPBaseResourceTest {

    @Test
    void testActivityModelJson() throws Exception {
        final String json = loadTestResource("/models/op_activity.json");
        OPActivityModel model = mapper.readValue(json, OPActivityModel.class);
        assertBaseResource(model, "Activity");
        assertEquals(1L, model.getId(), "ID does not match expected value");
        assertNotNull(model.getComment(), "Comment should not be null");
        assertEquals("This is a comment", model.getComment().getRaw(), "Comment raw does not match");
        assertNotNull(model.getDetails(), "Details should not be null");
        assertFalse(model.getDetails().isEmpty(), "Details should not be empty");
        assertEquals(2, model.getVersion(), "Version does not match");
        assertFalse(model.getInternal(), "Internal should be false");
        assertNotNull(model.getCreatedAt(), "CreatedAt should not be null");
        assertNotNull(model.getUpdatedAt(), "UpdatedAt should not be null");
    }
}
