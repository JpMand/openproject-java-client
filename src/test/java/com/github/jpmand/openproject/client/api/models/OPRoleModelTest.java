package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OPRoleModelTest extends OPBaseResourceTest {

    @Test
    void testRoleModelJson() throws Exception {
        final String json = loadTestResource("/models/op_role.json");
        OPRoleModel model = mapper.readValue(json, OPRoleModel.class);
        assertBaseResource(model, "Role");
        assertEquals(4L, model.getId(), "ID does not match expected value");
        assertEquals("Member", model.getName(), "Name does not match");
        assertEquals("Project Member", model.getTitle(), "Title does not match");
    }

    @Test
    void testRoleModelCollection() throws Exception {
        final String json = loadTestResource("/models/op_role_collection.json");
        AbstractOPCollection<? extends OPBaseResource> collection = mapper.readValue(json, new TypeReference<AbstractOPCollection<OPRoleModel>>() {
        });
        assertBaseResource(collection, "Collection");
        assertNotNull(collection.getElements(), "Collection elements should not be null");
        assertNotNull(collection.getCount(), "Collection count should not be null");
        assertEquals(2, collection.getCount(), "Collection count should be 2");
        assertEquals(collection.getElements().size(), collection.getCount(), "Collection size should match count");
        assertInstanceOf(OPRoleModel.class, collection.getElements().get(0), "Embedded resource should be of type OPRoleModel");
        assertBaseResource(collection.getElements().get(0), "Role");
    }
}
