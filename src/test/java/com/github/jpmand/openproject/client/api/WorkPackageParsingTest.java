package com.github.jpmand.openproject.client.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jpmand.openproject.client.api.models.OPWorkPackageModel;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import com.github.jpmand.openproject.client.api.models.enums.FilterOperator;
import com.github.jpmand.openproject.client.core.serialization.HalObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WorkPackageParsingTest {
    @Test
    void testParseWorkPackage() throws Exception {
        ObjectMapper mapper = HalObjectMapper.get();
        try (InputStream inputStream = getClass().getResourceAsStream("/workpackage.json")) {
            assertNotNull(inputStream, "workpackage.json not found in test resources");
            OPWorkPackageModel wp = mapper.readValue(inputStream, OPWorkPackageModel.class);
            assertNotNull(wp);
            assertEquals(2, wp.getId());
            assertEquals("Organize open source conference", wp.getSubject());
            assertNotNull(wp.getCreatedAt());
            assertNotNull(wp.getSingleLink("self"));
            assertEquals("/api/v3/work_packages/2", wp.getSingleLink("self").getHref());
        }
    }

    @Test
    void testParseWorkPackageCollection() throws Exception {
        ObjectMapper mapper = HalObjectMapper.get();
        try (InputStream inputStream = getClass().getResourceAsStream("/workpackage_collection.json")) {
            assertNotNull(inputStream, "workpackage_collection.json not found in test resources");
            AbstractOPCollection<OPWorkPackageModel> wp = mapper.readValue(inputStream, new TypeReference<AbstractOPCollection<OPWorkPackageModel>>() {
            });
            assertNotNull(wp);
            assertEquals(5, wp.getCount());
            assertNotNull(wp.getEmbedded());
            assertNotNull(wp.getElements());
            assertEquals(wp.getElements().size(), wp.getPageSize());
        }
    }
}
