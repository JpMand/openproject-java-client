package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OPAttachmentTest extends OPBaseResourceTest {

    @Test
    void testAttachmentModelJson() throws Exception {
        final String json = loadTestResource("/models/op_attachment.json");
        OPAttachmentModel model = mapper.readValue(json, OPAttachmentModel.class);
        assertBaseResource(model, "Attachment");
        assertEquals(1612L, model.getId(), "ID does not match expected value");
        assertNotNull(model.getDownloadLocationLink(), "Download location should not be null");
    }

    @Test
    void testAttachmentModelCollection() throws Exception {
        final String json = loadTestResource("/models/op_attachment_collection.json");
        AbstractOPCollection<? extends OPBaseResource> collection = mapper.readValue(json, new TypeReference<AbstractOPCollection<OPAttachmentModel>>() {
        });
        assertBaseResource(collection, "Collection");
        assertNotNull(collection.getElements(), "Collection elements should not be null");
        assertNotNull(collection.getCount(), "Collection count should not be null");
        assertEquals(collection.getElements().size(), collection.getCount(), "Collection size should match count");
        assertInstanceOf(OPAttachmentModel.class, collection.getElements().get(0), "Embedded resource should be of type OPAttachmentModel");
        assertBaseResource(collection.getElements().get(0), "Attachment");
    }
}
