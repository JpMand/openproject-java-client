package com.github.jpmand.openproject.client.api;

import com.github.jpmand.openproject.client.api.models.OPPriorityModel;
import com.github.jpmand.openproject.client.api.models.OPProjectModel;
import com.github.jpmand.openproject.client.api.models.OPStatusModel;
import com.github.jpmand.openproject.client.api.models.OPWorkPackageModel;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import com.github.jpmand.openproject.client.api.models.enums.SortEnum;
import com.github.jpmand.openproject.client.api.models.filters.OPQueryFilterInstance;
import com.github.jpmand.openproject.client.api.models.filters.OPQueryFilter;
import com.github.jpmand.openproject.client.auth.AnonymousAuth;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
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
 * They validate the functionality of fetching and listing various OpenProject resources
 * including work packages, projects, statuses, and priorities.
 * </p>
 * <p>
 * No authentication is used; only public data is accessed.
 * </p>
 * <p>
 * <strong>Note:</strong> These tests are disabled by default to avoid hitting the network during
 * normal test runs. They are tagged with "live-integration" and can be enabled manually to verify
 * connectivity to the OpenProject community instance.
 * </p>
 * <p>
 * <strong>To run these tests:</strong>
 * <ul>
 * <li>Remove the {@code @Disabled} annotation from the test(s) you want to run</li>
 * <li>Run with: {@code mvn test -DexcludedGroups=}</li>
 * <li>Or run individual tests from your IDE after removing {@code @Disabled}</li>
 * </ul>
 * </p>
 */
@Tag("live-integration")
public class OpenProjectCommunityLiveIntegrationTest {
    private OpenProjectClient client;

    @BeforeEach
    void setUp() {
        String baseUrl = "https://community.openproject.org";
        client = new OpenProjectClient(baseUrl, new AnonymousAuth());
    }

    @Test
    @Disabled("Disabled by default to avoid network calls. Remove @Disabled to run against live API.")
    void testGetWorkPackageById() throws IOException {
        long workPackageId = 145L;
        OPWorkPackageModel workPackage = client.getWorkPackage(workPackageId);
        assertNotNull(workPackage, "Work package should not be null");
        assertEquals(workPackageId, workPackage.getId(), "Work package id should match");
    }

    @Test
    @Disabled("Disabled by default to avoid network calls. Remove @Disabled to run against live API.")
    void testListWorkPackagesWithFilterSortAndPagination() throws IOException {
        int offset = 6;
        int pageSize = 4;
        OPQueryFilterInstance filters = OPQueryFilterInstance.of("status", OPQueryFilter.WK_OPEN_FILTER);
        Map<String, SortEnum> sorts = new LinkedHashMap<>();
        sorts.put("id", SortEnum.ASC);

        AbstractOPCollection<OPWorkPackageModel> workPackageList = client.listWorkPackages(offset, pageSize, List.of(filters), sorts, null, null, null);
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

    @Test
    @Disabled("Disabled by default to avoid network calls. Remove @Disabled to run against live API.")
    void testGetProjectById() throws IOException {
        long projectId = 14L;
        OPProjectModel project = client.getProject(projectId);
        assertNotNull(project, "Project should not be null");
        assertEquals(projectId, project.getId(), "Project id should match");
        assertNotNull(project.getIdentifier(), "Project identifier should not be null");
        assertNotNull(project.getName(), "Project name should not be null");
    }

    @Test
    @Disabled("Disabled by default to avoid network calls. Remove @Disabled to run against live API.")
    void testListProjectsWithFilterSortAndSelect() throws IOException {
        // Note: Projects endpoint does NOT support offset/pageSize according to OpenAPI spec
        Map<String, SortEnum> sorts = new LinkedHashMap<>();
        sorts.put("name", SortEnum.ASC);

        AbstractOPCollection<OPProjectModel> projects = client.listProjects(null, sorts, null);
        assertNotNull(projects, "Projects list should not be null");
        assertNotNull(projects.getElements(), "Projects elements should not be null");

        OPProjectModel firstProject = projects.getElements().get(0);
        assertNotNull(firstProject, "First project should not be null");
        assertNotNull(firstProject.getId(), "Project id should not be null");
        assertNotNull(firstProject.getName(), "Project name should not be null");
    }

    @Test
    @Disabled("Disabled by default to avoid network calls. Remove @Disabled to run against live API.")
    void testGetStatusById() throws IOException {
        long statusId = 1L;
        OPStatusModel status = client.getStatus(statusId);
        assertNotNull(status, "Status should not be null");
        assertEquals(statusId, status.getId(), "Status id should match");
        assertNotNull(status.getName(), "Status name should not be null");
    }

    @Test
    @Disabled("Disabled by default to avoid network calls. Remove @Disabled to run against live API.")
    void testListStatuses() throws IOException {
        // Note: Statuses endpoint does NOT support any query parameters according to OpenAPI spec
        AbstractOPCollection<OPStatusModel> statuses = client.listStatuses();
        assertNotNull(statuses, "Statuses list should not be null");
        assertNotNull(statuses.getElements(), "Statuses elements should not be null");

        OPStatusModel firstStatus = statuses.getElements().get(0);
        assertNotNull(firstStatus, "First status should not be null");
        assertNotNull(firstStatus.getId(), "Status id should not be null");
        assertNotNull(firstStatus.getName(), "Status name should not be null");
    }

    @Test
    @Disabled("Disabled by default to avoid network calls. Remove @Disabled to run against live API.")
    void testGetPriorityById() throws IOException {
        long priorityId = 8L;
        OPPriorityModel priority = client.getPriority(priorityId);
        assertNotNull(priority, "Priority should not be null");
        assertEquals(priorityId, priority.getId(), "Priority id should match");
        assertNotNull(priority.getName(), "Priority name should not be null");
    }

    @Test
    @Disabled("Disabled by default to avoid network calls. Remove @Disabled to run against live API.")
    void testListPriorities() throws IOException {
        // Note: Priorities endpoint does NOT support any query parameters according to OpenAPI spec
        AbstractOPCollection<OPPriorityModel> priorities = client.listPriorities();
        assertNotNull(priorities, "Priorities list should not be null");
        assertNotNull(priorities.getElements(), "Priorities elements should not be null");

        OPPriorityModel firstPriority = priorities.getElements().get(0);
        assertNotNull(firstPriority, "First priority should not be null");
        assertNotNull(firstPriority.getId(), "Priority id should not be null");
        assertNotNull(firstPriority.getName(), "Priority name should not be null");
    }
}
