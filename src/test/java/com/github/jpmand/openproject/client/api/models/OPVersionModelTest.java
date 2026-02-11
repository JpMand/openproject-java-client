package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OPVersionModelTest extends OPBaseResourceTest {

    @Test
    void testVersionModelJson() throws Exception {
        final String json = loadTestResource("/models/op_version.json");
        OPVersionModel model = mapper.readValue(json, OPVersionModel.class);
        assertBaseResource(model, "Version");
        assertEquals(1L, model.getId(), "ID does not match expected value");
        assertEquals("Version 1.0", model.getName(), "Name does not match");
        assertNotNull(model.getDescription(), "Description should not be null");
        assertEquals("Initial Release", model.getDescription().getRaw(), "Description raw does not match");
        assertNotNull(model.getStartDate(), "StartDate should not be null");
        assertNotNull(model.getEndDate(), "EndDate should not be null");
        assertEquals("open", model.getStatus(), "Status does not match");
        assertEquals("system", model.getSharing(), "Sharing does not match");
        assertNotNull(model.getCreatedAt(), "CreatedAt should not be null");
        assertNotNull(model.getUpdatedAt(), "UpdatedAt should not be null");
    }

    @Test
    void testVersionModelCollection() throws Exception {
        final String json = loadTestResource("/models/op_version_collection.json");
        AbstractOPCollection<? extends OPBaseResource> collection = mapper.readValue(json, new TypeReference<AbstractOPCollection<OPVersionModel>>() {
        });
        assertBaseResource(collection, "Collection");
        assertNotNull(collection.getElements(), "Collection elements should not be null");
        assertNotNull(collection.getCount(), "Collection count should not be null");
        assertEquals(2, collection.getCount(), "Collection count should be 2");
        assertEquals(collection.getElements().size(), collection.getCount(), "Collection size should match count");
        assertInstanceOf(OPVersionModel.class, collection.getElements().get(0), "Embedded resource should be of type OPVersionModel");
        assertBaseResource(collection.getElements().get(0), "Version");
    }
}
