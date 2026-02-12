package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OPCapabilityModelTest extends OPBaseResourceTest {

    @Test
    void testCapabilityModelJson() throws Exception {
        final String json = loadTestResource("/models/op_capability.json");
        OPCapabilityModel model = mapper.readValue(json, OPCapabilityModel.class);
        assertBaseResource(model, "Capability");
        assertEquals("work_packages/update", model.getId(), "ID does not match expected value");
    }

    @Test
    void testCapabilityModelCollection() throws Exception {
        final String json = loadTestResource("/models/op_capability_collection.json");
        AbstractOPCollection<? extends OPBaseResource> collection = mapper.readValue(json, new TypeReference<AbstractOPCollection<OPCapabilityModel>>() {
        });
        assertBaseResource(collection, "Collection");
        assertNotNull(collection.getElements(), "Collection elements should not be null");
        assertNotNull(collection.getCount(), "Collection count should not be null");
        assertEquals(2, collection.getCount(), "Collection count should be 2");
        assertEquals(collection.getElements().size(), collection.getCount(), "Collection size should match count");
        assertInstanceOf(OPCapabilityModel.class, collection.getElements().get(0), "Embedded resource should be of type OPCapabilityModel");
        assertBaseResource(collection.getElements().get(0), "Capability");
    }
}
