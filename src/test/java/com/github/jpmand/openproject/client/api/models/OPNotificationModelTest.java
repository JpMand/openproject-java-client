package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OPNotificationModelTest extends OPBaseResourceTest {

    @Test
    void testNotificationModelJson() throws Exception {
        final String json = loadTestResource("/models/op_notification.json");
        OPNotificationModel model = mapper.readValue(json, OPNotificationModel.class);
        assertBaseResource(model, "Notification");
        assertEquals(1L, model.getId(), "ID does not match expected value");
        assertEquals("New work package created", model.getSubject(), "Subject does not match");
        assertEquals("mentioned", model.getReason(), "Reason does not match");
        assertFalse(model.getReadIAN(), "readIAN should be false");
    }

    @Test
    void testNotificationModelCollection() throws Exception {
        final String json = loadTestResource("/models/op_notification_collection.json");
        AbstractOPCollection<? extends OPBaseResource> collection = mapper.readValue(json, new TypeReference<AbstractOPCollection<OPNotificationModel>>() {
        });
        assertBaseResource(collection, "Collection");
        assertNotNull(collection.getElements(), "Collection elements should not be null");
        assertNotNull(collection.getCount(), "Collection count should not be null");
        assertEquals(2, collection.getCount(), "Collection count should be 2");
        assertEquals(collection.getElements().size(), collection.getCount(), "Collection size should match count");
        assertInstanceOf(OPNotificationModel.class, collection.getElements().get(0), "Embedded resource should be of type OPNotificationModel");
        assertBaseResource(collection.getElements().get(0), "Notification");
    }
}
