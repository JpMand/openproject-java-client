package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OPPriorityModelTest extends OPBaseResourceTest {

    @Test
    void testPriorityModelJson() throws Exception {
        final String json = loadTestResource("/models/op_priority.json");
        OPPriorityModel model = mapper.readValue(json, OPPriorityModel.class);
        assertBaseResource(model, "Priority");
        assertEquals(8L, model.getId(), "ID does not match expected value");
        assertEquals("Normal", model.getName(), "Name does not match");
        assertEquals(2, model.getPosition(), "Position does not match");
        assertTrue(model.getDefault(), "isDefault should be true");
        assertTrue(model.getActive(), "isActive should be true");
    }

    @Test
    void testPriorityModelCollection() throws Exception {
        final String json = loadTestResource("/models/op_priority_collection.json");
        AbstractOPCollection<? extends OPBaseResource> collection = mapper.readValue(json, new TypeReference<AbstractOPCollection<OPPriorityModel>>() {
        });
        assertBaseResource(collection, "Collection");
        assertNotNull(collection.getElements(), "Collection elements should not be null");
        assertNotNull(collection.getCount(), "Collection count should not be null");
        assertEquals(3, collection.getCount(), "Collection count should be 3");
        assertEquals(collection.getElements().size(), collection.getCount(), "Collection size should match count");
        assertInstanceOf(OPPriorityModel.class, collection.getElements().get(0), "Embedded resource should be of type OPPriorityModel");
        assertBaseResource(collection.getElements().get(0), "Priority");
    }
}
