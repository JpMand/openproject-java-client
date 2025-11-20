package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OPActionModelTest extends OPBaseResourceTest {

    @Test
    void testActionModelJson() throws Exception {
        final String json = loadTestResource("/models/op_action.json");
        OPActionModel model = mapper.readValue(json, OPActionModel.class);
        assertBaseResource(model, "Action");
        assertEquals("calendars/update", model.getId(), "ID does not match expected value");
    }

    @Test
    void testActionModelCollection() throws Exception {
        final String json = loadTestResource("/models/op_action_collection.json");
        AbstractOPCollection<? extends OPBaseResource> collection = mapper.readValue(json, new TypeReference<AbstractOPCollection<OPActionModel>>() {
        });
        assertBaseResource(collection, "Collection");
        assertNotNull(collection.getElements(), "Collection elements should not be null");
        assertNotNull(collection.getCount(), "Collection count should not be null");
        assertEquals(collection.getElements().size(), collection.getCount(), "Collection size should match count");
        assertInstanceOf(OPActionModel.class, collection.getElements().get(0), "Embedded resource should be of type OPActionModel");
        assertBaseResource(collection.getElements().get(0), "Action");
    }
}
