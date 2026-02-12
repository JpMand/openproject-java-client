package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OPCategoryModelTest extends OPBaseResourceTest {

    @Test
    void testCategoryModelJson() throws Exception {
        final String json = loadTestResource("/models/op_category.json");
        OPCategoryModel model = mapper.readValue(json, OPCategoryModel.class);
        assertBaseResource(model, "Category");
        assertEquals(1L, model.getId(), "ID does not match expected value");
        assertEquals("Bug Category", model.getName(), "Name does not match");
    }

    @Test
    void testCategoryModelCollection() throws Exception {
        final String json = loadTestResource("/models/op_category_collection.json");
        AbstractOPCollection<? extends OPBaseResource> collection = mapper.readValue(json, new TypeReference<AbstractOPCollection<OPCategoryModel>>() {
        });
        assertBaseResource(collection, "Collection");
        assertNotNull(collection.getElements(), "Collection elements should not be null");
        assertNotNull(collection.getCount(), "Collection count should not be null");
        assertEquals(2, collection.getCount(), "Collection count should be 2");
        assertEquals(collection.getElements().size(), collection.getCount(), "Collection size should match count");
        assertInstanceOf(OPCategoryModel.class, collection.getElements().get(0), "Embedded resource should be of type OPCategoryModel");
        assertBaseResource(collection.getElements().get(0), "Category");
    }
}
