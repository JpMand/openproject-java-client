package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OPUserModelTest extends OPBaseResourceTest {

    @Test
    void testUserModelJson() throws Exception {
        final String json = loadTestResource("/models/op_user.json");
        OPUserModel model = mapper.readValue(json, OPUserModel.class);
        assertBaseResource(model, "User");
        assertEquals(1L, model.getId(), "ID does not match expected value");
        assertEquals("OpenProject Admin", model.getName(), "Name does not match");
        assertEquals("admin@example.com", model.getEmail(), "Email does not match");
        assertEquals("active", model.getStatus(), "Status does not match");
        assertTrue(model.getAdmin(), "Admin should be true");
        assertEquals("https://example.com/avatar.png", model.getAvatar(), "Avatar URL does not match");
        assertEquals("OpenProject", model.getFirstName(), "FirstName does not match");
        assertEquals("Admin", model.getLastName(), "LastName does not match");
        assertEquals("admin", model.getLogin(), "Login does not match");
        assertEquals("en", model.getLanguage(), "Language does not match");
        assertNotNull(model.getCreatedAt(), "CreatedAt should not be null");
        assertNotNull(model.getUpdatedAt(), "UpdatedAt should not be null");
    }

    @Test
    void testUserModelCollection() throws Exception {
        final String json = loadTestResource("/models/op_user_collection.json");
        AbstractOPCollection<? extends OPBaseResource> collection = mapper.readValue(json, new TypeReference<AbstractOPCollection<OPUserModel>>() {
        });
        assertBaseResource(collection, "Collection");
        assertNotNull(collection.getElements(), "Collection elements should not be null");
        assertNotNull(collection.getCount(), "Collection count should not be null");
        assertEquals(2, collection.getCount(), "Collection count should be 2");
        assertEquals(collection.getElements().size(), collection.getCount(), "Collection size should match count");
        assertInstanceOf(OPUserModel.class, collection.getElements().get(0), "Embedded resource should be of type OPUserModel");
        assertBaseResource(collection.getElements().get(0), "User");
    }
}
