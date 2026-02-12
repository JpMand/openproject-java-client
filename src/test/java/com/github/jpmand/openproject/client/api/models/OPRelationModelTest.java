package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OPRelationModelTest extends OPBaseResourceTest {

    @Test
    void testRelationModelJson() throws Exception {
        final String json = loadTestResource("/models/op_relation.json");
        OPRelationModel model = mapper.readValue(json, OPRelationModel.class);
        assertBaseResource(model, "Relation");
        assertEquals(1L, model.getId(), "ID does not match expected value");
        assertEquals("precedes", model.getName(), "Name does not match");
        assertEquals("precedes", model.getRelationType(), "Type does not match");
        assertEquals("This task precedes the other", model.getDescription(), "Description does not match");
        assertEquals(2, model.getLag(), "Lag does not match");
        assertEquals("follows", model.getReverseType(), "ReverseType does not match");
        assertNotNull(model.getCreatedAt(), "CreatedAt should not be null");
        assertNotNull(model.getUpdatedAt(), "UpdatedAt should not be null");
    }

    @Test
    void testRelationModelCollection() throws Exception {
        final String json = loadTestResource("/models/op_relation_collection.json");
        AbstractOPCollection<? extends OPBaseResource> collection = mapper.readValue(json, new TypeReference<AbstractOPCollection<OPRelationModel>>() {
        });
        assertBaseResource(collection, "Collection");
        assertNotNull(collection.getElements(), "Collection elements should not be null");
        assertNotNull(collection.getCount(), "Collection count should not be null");
        assertEquals(1, collection.getCount(), "Collection count should be 1");
        assertEquals(collection.getElements().size(), collection.getCount(), "Collection size should match count");
        assertInstanceOf(OPRelationModel.class, collection.getElements().get(0), "Embedded resource should be of type OPRelationModel");
        assertBaseResource(collection.getElements().get(0), "Relation");
    }
}
