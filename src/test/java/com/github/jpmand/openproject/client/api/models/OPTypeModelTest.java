package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OPTypeModelTest extends OPBaseResourceTest {

    @Test
    void testTypeModelJson() throws Exception {
        final String json = loadTestResource("/models/op_type.json");
        OPTypeModel model = mapper.readValue(json, OPTypeModel.class);
        assertBaseResource(model, "Type");
        assertEquals(1L, model.getId(), "ID does not match expected value");
        assertEquals("Task", model.getName(), "Name does not match");
        assertEquals("#3498db", model.getColor(), "Color does not match");
        assertEquals(1, model.getPosition(), "Position does not match");
        assertTrue(model.getIsDefault(), "isDefault should be true");
        assertFalse(model.getIsMilestone(), "isMilestone should be false");
        assertNotNull(model.getCreatedAt(), "CreatedAt should not be null");
        assertNotNull(model.getUpdatedAt(), "UpdatedAt should not be null");
    }

    @Test
    void testTypeModelCollection() throws Exception {
        final String json = loadTestResource("/models/op_type_collection.json");
        AbstractOPCollection<? extends OPBaseResource> collection = mapper.readValue(json, new TypeReference<AbstractOPCollection<OPTypeModel>>() {
        });
        assertBaseResource(collection, "Collection");
        assertNotNull(collection.getElements(), "Collection elements should not be null");
        assertNotNull(collection.getCount(), "Collection count should not be null");
        assertEquals(2, collection.getCount(), "Collection count should be 2");
        assertEquals(collection.getElements().size(), collection.getCount(), "Collection size should match count");
        assertInstanceOf(OPTypeModel.class, collection.getElements().get(0), "Embedded resource should be of type OPTypeModel");
        assertBaseResource(collection.getElements().get(0), "Type");
    }
}
