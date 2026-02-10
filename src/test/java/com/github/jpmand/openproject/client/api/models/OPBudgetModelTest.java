package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OPBudgetModelTest extends OPBaseResourceTest {

    @Test
    void testBudgetModelJson() throws Exception {
        final String json = loadTestResource("/models/op_budget.json");
        OPBudgetModel model = mapper.readValue(json, OPBudgetModel.class);
        assertBaseResource(model, "Budget");
        assertEquals(1L, model.getId(), "ID does not match expected value");
        assertEquals("Q1 Budget 2025", model.getSubject(), "Subject does not match");
    }

    @Test
    void testBudgetModelCollection() throws Exception {
        final String json = loadTestResource("/models/op_budget_collection.json");
        AbstractOPCollection<? extends OPBaseResource> collection = mapper.readValue(json, new TypeReference<AbstractOPCollection<OPBudgetModel>>() {
        });
        assertBaseResource(collection, "Collection");
        assertNotNull(collection.getElements(), "Collection elements should not be null");
        assertNotNull(collection.getCount(), "Collection count should not be null");
        assertEquals(2, collection.getCount(), "Collection count should be 2");
        assertEquals(collection.getElements().size(), collection.getCount(), "Collection size should match count");
        assertInstanceOf(OPBudgetModel.class, collection.getElements().get(0), "Embedded resource should be of type OPBudgetModel");
        assertBaseResource(collection.getElements().get(0), "Budget");
    }
}
