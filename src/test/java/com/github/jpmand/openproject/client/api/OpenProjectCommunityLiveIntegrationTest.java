package com.github.jpmand.openproject.client.api;

import com.github.jpmand.openproject.client.api.models.OPWorkPackageModel;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import com.github.jpmand.openproject.client.api.models.enums.SortEnum;
import com.github.jpmand.openproject.client.api.models.filters.OPFilterObject;
import com.github.jpmand.openproject.client.api.models.filters.OPFilterValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Live integration tests for OpenProjectClient against the OpenProject Community instance.
 * <p>
 * Only read operations are permitted.
 * </p>
 * <p>
 * These tests require network access and a reachable OpenProject Community server.
 * They validate the functionality of fetching and listing work packages with filters,
 * sorting, and pagination.
 * </p>
 * <p>
 * No authentication is used; only public data is accessed.
 * </p>
 */
@Tag("live-integration")
public class OpenProjectCommunityLiveIntegrationTest {
    private OpenProjectClient client;

    @BeforeEach
    void setUp() {
        String baseUrl = "https://community.openproject.org";
        client = new OpenProjectClient(baseUrl, null);
    }

    @Test
    void testGetWorkPackageById() throws Exception {
        long workPackageId = 145L; // Example work package ID
        OPWorkPackageModel workPackage = client.getWorkPackage(workPackageId);
        assertNotNull(workPackage, "Work package should not be null");
        assertEquals(workPackageId, workPackage.getId(), "Work package id should match");
    }

    @Test
    void testListWorkPackagesWithFilterSortAndPagination() throws Exception {
        int offset = 6;
        int pageSize = 4;
        OPFilterObject filters = OPFilterObject.of("status", OPFilterValue.WK_OPEN_FILTER);
        Map<String, SortEnum> sorts = new LinkedHashMap<>();
        sorts.put("id", SortEnum.ASC);

        AbstractOPCollection<OPWorkPackageModel> workPackageList = client.listWorkPackages(offset, pageSize, List.of(filters), sorts);
        assertNotNull(workPackageList, "Work package list should not be null");
        assertNotNull(workPackageList.getElements(), "Work package list elements should not be null");

        assertEquals(offset, workPackageList.getOffset(), "Offset should match");
        assertEquals(pageSize, workPackageList.getPageSize(), "Page size should match");
        assertEquals(pageSize, workPackageList.getElements().size(), "Number of elements should match page size");
        List<OPWorkPackageModel> elements = workPackageList.getElements();
        long prevId = Long.MIN_VALUE;
        for (OPWorkPackageModel wp : elements) {
            assertTrue(wp.getId() > prevId, "Work packages must be ordered by id ascending");
            prevId = wp.getId();
        }
    }
}
