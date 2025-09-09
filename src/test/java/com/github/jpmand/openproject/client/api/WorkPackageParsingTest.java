package com.github.jpmand.openproject.client.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jpmand.openproject.client.core.model.WorkPackage;
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
            WorkPackage wp = mapper.readValue(inputStream, WorkPackage.class);
            assertNotNull(wp);
            assertEquals(2L, wp.getId());
            assertEquals("Organize open source conference", wp.getSubject());
            assertNotNull(wp.getCreatedAt());

            assertNotNull(wp.getSingleLinkByRel("self").orElse(null));
            assertEquals("/api/v3/work_packages/2", wp.getSingleLinkByRel("self").get().getHref());
        }
    }
}
