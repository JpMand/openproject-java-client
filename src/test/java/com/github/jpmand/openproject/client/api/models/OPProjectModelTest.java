package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OPProjectModelTest extends OPBaseResourceTest {

    @Test
    void testProjectModelJson() throws Exception {
        final String json = loadTestResource("/models/op_project.json");
        OPProjectModel model = mapper.readValue(json, OPProjectModel.class);
        assertBaseResource(model, "Project");
        assertEquals(1L, model.getId(), "ID does not match expected value");
        assertEquals("demo-project", model.getIdentifier(), "Identifier does not match");
        assertEquals("Demo project", model.getName(), "Name does not match");
        assertTrue(model.getActive(), "Active should be true");
        assertTrue(model.getPublic(), "Public should be true");
        assertNotNull(model.getDescription(), "Description should not be null");
        assertEquals("markdown", model.getDescription().getFormat(), "Description format should be markdown");
        assertNotNull(model.getCreatedAt(), "CreatedAt should not be null");
        assertNotNull(model.getUpdatedAt(), "UpdatedAt should not be null");
    }

    @Test
    void testProjectModelCollection() throws Exception {
        final String json = loadTestResource("/models/op_project_collection.json");
        AbstractOPCollection<? extends OPBaseResource> collection = mapper.readValue(json, new TypeReference<AbstractOPCollection<OPProjectModel>>() {
        });
        assertBaseResource(collection, "Collection");
        assertNotNull(collection.getElements(), "Collection elements should not be null");
        assertNotNull(collection.getCount(), "Collection count should not be null");
        assertEquals(2, collection.getCount(), "Collection count should be 2");
        assertEquals(collection.getElements().size(), collection.getCount(), "Collection size should match count");
        assertInstanceOf(OPProjectModel.class, collection.getElements().get(0), "Embedded resource should be of type OPProjectModel");
        assertBaseResource(collection.getElements().get(0), "Project");
    }
}
