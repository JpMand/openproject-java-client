package com.github.jpmand.openproject.client.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jpmand.openproject.client.api.models.enums.SortEnum;
import com.github.jpmand.openproject.client.api.models.OPWorkPackageModel;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import com.github.jpmand.openproject.client.api.models.filters.OPFilterObject;
import com.github.jpmand.openproject.client.api.models.enums.FilterOperator;
import com.github.jpmand.openproject.client.api.models.filters.OPFilterValue;
import com.github.jpmand.openproject.client.core.serialization.HalObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for OPWorkPackageModel API with mock web server.
 * Tests that query parameters are properly encoded and responses are correctly parsed.
 */
class WorkPackageIntegrationTest {

    private MockWebServer mockServer;
    private OpenProjectClient client;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() throws IOException {
        mockServer = new MockWebServer();
        mockServer.start();
        
        String baseUrl = mockServer.url("/").toString();
        client = new OpenProjectClient(baseUrl, (com.github.jpmand.openproject.client.auth.AuthProvider) null);
        objectMapper = HalObjectMapper.get();
    }

    @AfterEach
    void tearDown() throws IOException {
        mockServer.shutdown();
    }

    @Test
    void testGetWorkPackageById() throws Exception {
        // Load test data
        String json = loadTestResource("/workpackage.json");
        
        mockServer.enqueue(new MockResponse()
                .setBody(json)
                .addHeader("Content-Type", "application/hal+json"));

        OPWorkPackageModel workPackage = client.getWorkPackage(2L);

        assertNotNull(workPackage);
        assertEquals(2L, workPackage.getId());
        assertEquals("Organize open source conference", workPackage.getSubject());
        
        // Verify the request
        RecordedRequest request = mockServer.takeRequest();
        assertEquals("/api/v3/work_packages/2", request.getPath());
        assertEquals("GET", request.getMethod());
    }

    @Test
    void testListWorkPackagesWithPagination() throws Exception {
        String json = loadTestResource("/workpackage_collection.json");
        
        mockServer.enqueue(new MockResponse()
                .setBody(json)
                .addHeader("Content-Type", "application/hal+json"));

        AbstractOPCollection<WorkPackage> result = client.listWorkPackages(20, 5);

        assertNotNull(result);
        assertEquals(26L, result.getTotal());
        
        // Verify the request and query parameters
        RecordedRequest request = mockServer.takeRequest();
        String path = request.getPath();
        assertTrue(path.startsWith("/api/v3/work_packages?"));
        assertTrue(path.contains("pageSize=20"));
        assertTrue(path.contains("offset=5"));
    }

    @Test
    void testListWorkPackagesWithFiltersEncoding() throws Exception {
        String json = loadTestResource("/workpackage_collection.json");
        
        mockServer.enqueue(new MockResponse()
                .setBody(json)
                .addHeader("Content-Type", "application/hal+json"));

        // Use type-safe filter
        OPFilterObject statusFilter = OPFilterObject.of("status", OPFilterValue.of(FilterOperator.WK_OPEN, List.of()));
        Map<String, SortEnum> sortFields = new LinkedHashMap<>();
        sortFields.put("id", SortEnum.ASC);
        
        AbstractOPCollection<WorkPackage> result = client.listWorkPackages(
                1, 10, List.of(statusFilter), sortFields);

        assertNotNull(result);
        
        // Verify the request
        RecordedRequest request = mockServer.takeRequest();
        String path = request.getPath();
        String decodedPath = URLDecoder.decode(path, StandardCharsets.UTF_8);
        
        // Verify filters parameter is properly encoded
        assertTrue(decodedPath.contains("filters="));
        assertTrue(decodedPath.contains("\"status\""));
        assertTrue(decodedPath.contains("\"operator\":\"o\""));
        
        // Verify sortBy parameter is properly encoded  
        assertTrue(decodedPath.contains("sortBy="));
        assertTrue(decodedPath.contains("[[\"id\",\"asc\"]]"));
        
        // Verify pagination parameters
        assertTrue(path.contains("offset=1"));
        assertTrue(path.contains("pageSize=10"));
    }

    @Test
    void testListWorkPackagesWithMultipleFilters() throws Exception {
        String json = loadTestResource("/workpackage_collection.json");
        
        mockServer.enqueue(new MockResponse()
                .setBody(json)
                .addHeader("Content-Type", "application/hal+json"));

        // Create multiple filters
        OPFilterObject filter1 = OPFilterObject.of("status", OPFilterValue.of(FilterOperator.WK_OPEN, List.of()));
        OPFilterObject filter2 = OPFilterObject.of("assignee", OPFilterValue.of(FilterOperator.EQUALS, List.of("me")));
        
        Map<String, SortEnum> sortFields = new LinkedHashMap<>();
        sortFields.put("priority", SortEnum.DESC);
        sortFields.put("id", SortEnum.ASC);
        
        AbstractOPCollection<WorkPackage> result = client.listWorkPackages(
                0, 20, List.of(filter1, filter2), sortFields);

        assertNotNull(result);
        
        // Verify the request
        RecordedRequest request = mockServer.takeRequest();
        String path = request.getPath();
        String decodedPath = URLDecoder.decode(path, StandardCharsets.UTF_8);
        
        // Verify both filters are in the request
        assertTrue(decodedPath.contains("\"status\""));
        assertTrue(decodedPath.contains("\"assignee\""));
        
        // Verify both sort fields are in the request
        assertTrue(decodedPath.contains("\"priority\""));
        assertTrue(decodedPath.contains("\"id\""));
        assertTrue(decodedPath.contains("\"desc\""));
        assertTrue(decodedPath.contains("\"asc\""));
    }

    @Test
    void testListWorkPackagesWithSingleFilterAndSort() throws Exception {
        String json = loadTestResource("/workpackage_collection.json");
        
        mockServer.enqueue(new MockResponse()
                .setBody(json)
                .addHeader("Content-Type", "application/hal+json"));

        OPFilterObject filter = OPFilterObject.of("status", OPFilterValue.of(FilterOperator.WK_OPEN, List.of()));
        
        AbstractOPCollection<WorkPackage> result = client.listWorkPackages(
                0, 20, filter, "id", SortEnum.ASC);

        assertNotNull(result);
        
        // Verify the request
        RecordedRequest request = mockServer.takeRequest();
        String path = request.getPath();
        String decodedPath = URLDecoder.decode(path, StandardCharsets.UTF_8);
        
        assertTrue(decodedPath.contains("filters="));
        assertTrue(decodedPath.contains("sortBy="));
        assertTrue(decodedPath.contains("\"status\""));
        assertTrue(decodedPath.contains("[[\"id\",\"asc\"]]"));
    }

    @Test
    void testResponseParsingWithAllFields() throws Exception {
        String json = loadTestResource("/workpackage.json");
        
        mockServer.enqueue(new MockResponse()
                .setBody(json)
                .addHeader("Content-Type", "application/hal+json"));

        OPWorkPackageModel wp = client.getWorkPackage(2L);

        // Verify all fields are properly parsed
        assertNotNull(wp.getId());
        assertNotNull(wp.getSubject());
        assertNotNull(wp.getStartDate());
        assertNotNull(wp.getDueDate());
        assertNotNull(wp.getDuration());
        assertNotNull(wp.getSpentTime());
        assertNotNull(wp.getDerivedPercentageDone());
        assertNotNull(wp.getCreatedAt());
        assertNotNull(wp.getUpdatedAt());
        
        // Verify specific values
        assertEquals("Organize open source conference", wp.getSubject());
        assertEquals(83, wp.getDerivedPercentageDone());
    }
    }

    @Test
    void testQueryParametersAreUrlEncoded() throws Exception {
        String json = loadTestResource("/workpackage_collection.json");
        
        mockServer.enqueue(new MockResponse()
                .setBody(json)
                .addHeader("Content-Type", "application/hal+json"));

        // Use raw JSON strings to test encoding
        String filters = "[{\"status\":{\"operator\":\"o\",\"values\":null}}]";
        String sortBy = "[[\"id\",\"asc\"]]";
        
        client.listWorkPackages(0, 20, filters, sortBy, null, false, null, null);
        
        // Verify the request
        RecordedRequest request = mockServer.takeRequest();
        String path = request.getPath();
        
        // Path should contain URL-encoded characters
        assertFalse(path.contains("[{"), "Characters should be URL encoded");
        assertTrue(path.contains("filters="), "Should have filters parameter");
        assertTrue(path.contains("sortBy="), "Should have sortBy parameter");
        
        // Decode and verify content
        String decodedPath = URLDecoder.decode(path, StandardCharsets.UTF_8);
        assertTrue(decodedPath.contains(filters));
        assertTrue(decodedPath.contains(sortBy));
    }

    private String loadTestResource(String resourcePath) throws IOException {
        try (InputStream is = getClass().getResourceAsStream(resourcePath)) {
            assertNotNull(is, "Test resource not found: " + resourcePath);
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}
