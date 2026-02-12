package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class OPTimeEntryModelTest extends OPBaseResourceTest {

    @Test
    void testTimeEntryModelJson() throws Exception {
        final String json = loadTestResource("/models/op_time_entry.json");
        OPTimeEntryModel model = mapper.readValue(json, OPTimeEntryModel.class);
        assertBaseResource(model, "TimeEntry");
        assertEquals(1L, model.getId(), "ID does not match expected value");
        assertNotNull(model.getComment(), "Comment should not be null");
        assertEquals("Worked on feature implementation", model.getComment().getRaw(), "Comment raw does not match");
        assertNotNull(model.getHours(), "Hours should not be null");
        assertEquals(Duration.parse("PT5H30M"), model.getHours(), "Hours does not match");
        assertNotNull(model.getSpentOn(), "SpentOn should not be null");
        assertFalse(model.getOngoing(), "Ongoing should be false");
        assertNotNull(model.getStartTime(), "StartTime should not be null");
        assertNotNull(model.getEndTime(), "EndTime should not be null");
        assertNotNull(model.getCreatedAt(), "CreatedAt should not be null");
        assertNotNull(model.getUpdatedAt(), "UpdatedAt should not be null");
    }

    @Test
    void testTimeEntryModelCollection() throws Exception {
        final String json = loadTestResource("/models/op_time_entry_collection.json");
        AbstractOPCollection<? extends OPBaseResource> collection = mapper.readValue(json, new TypeReference<AbstractOPCollection<OPTimeEntryModel>>() {
        });
        assertBaseResource(collection, "Collection");
        assertNotNull(collection.getElements(), "Collection elements should not be null");
        assertNotNull(collection.getCount(), "Collection count should not be null");
        assertEquals(1, collection.getCount(), "Collection count should be 1");
        assertEquals(collection.getElements().size(), collection.getCount(), "Collection size should match count");
        assertInstanceOf(OPTimeEntryModel.class, collection.getElements().get(0), "Embedded resource should be of type OPTimeEntryModel");
        assertBaseResource(collection.getElements().get(0), "TimeEntry");
    }
}
