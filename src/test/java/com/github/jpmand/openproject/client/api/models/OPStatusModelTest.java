package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OPStatusModelTest extends OPBaseResourceTest {

    @Test
    void testStatusModelJson() throws Exception {
        final String json = loadTestResource("/models/op_status.json");
        OPStatusModel model = mapper.readValue(json, OPStatusModel.class);
        assertBaseResource(model, "Status");
        assertEquals(7L, model.getId(), "ID does not match expected value");
        assertEquals("In progress", model.getName(), "Name does not match");
        assertFalse(model.getClosed(), "isClosed should be false");
        assertEquals("#CC5DE8", model.getColor(), "Color does not match");
        assertFalse(model.getDefault(), "isDefault should be false");
        assertFalse(model.getReadonly(), "isReadonly should be false");
        assertEquals(40, model.getDefaultDoneRatio(), "defaultDoneRatio does not match");
        assertEquals(7, model.getPosition(), "Position does not match");
    }

    @Test
    void testStatusModelCollection() throws Exception {
        final String json = loadTestResource("/models/op_status_collection.json");
        AbstractOPCollection<? extends OPBaseResource> collection = mapper.readValue(json, new TypeReference<AbstractOPCollection<OPStatusModel>>() {
        });
        assertBaseResource(collection, "Collection");
        assertNotNull(collection.getElements(), "Collection elements should not be null");
        assertNotNull(collection.getCount(), "Collection count should not be null");
        assertEquals(3, collection.getCount(), "Collection count should be 3");
        assertEquals(collection.getElements().size(), collection.getCount(), "Collection size should match count");
        assertInstanceOf(OPStatusModel.class, collection.getElements().get(0), "Embedded resource should be of type OPStatusModel");
        assertBaseResource(collection.getElements().get(0), "Status");
    }
}
