package com.github.jpmand.openproject.client.api.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OPRevisionModelTest extends OPBaseResourceTest {

    @Test
    void testRevisionModelJson() throws Exception {
        final String json = loadTestResource("/models/op_revision.json");
        OPRevisionModel model = mapper.readValue(json, OPRevisionModel.class);
        assertBaseResource(model, "Revision");
        assertEquals("abc123def456", model.getId(), "ID does not match expected value");
        assertEquals("abc123def456", model.getIdentifier(), "Identifier does not match");
        assertEquals("abc123d", model.getFormattedIdentifier(), "FormattedIdentifier does not match");
        assertEquals("John Doe", model.getAuthorName(), "AuthorName does not match");
        assertNotNull(model.getMessage(), "Message should not be null");
        assertEquals("Fix bug in user authentication", model.getMessage().getRaw(), "Message raw does not match");
        assertNotNull(model.getCreatedAt(), "CreatedAt should not be null");
    }
}
