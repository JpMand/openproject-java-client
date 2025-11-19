package com.github.jpmand.openproject.client.util;

import com.github.jpmand.openproject.client.api.models.enums.FilterOperator;
import com.github.jpmand.openproject.client.api.models.enums.SortEnum;
import com.github.jpmand.openproject.client.api.models.filters.OPQueryFilterInstance;
import com.github.jpmand.openproject.client.api.models.filters.OPQueryFilter;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for QueryBuilder utility class.
 */
class QueryBuilderTest {

    @Test
    void testBuildFilterJsonWithSingleFilter() {
        // Create a filter for open status
        OPQueryFilterInstance filter = OPQueryFilterInstance.of("status", OPQueryFilter.of(FilterOperator.WK_OPEN, List.of()));
        
        String json = QueryBuilder.buildFilterJson(filter);
        
        assertNotNull(json);
        assertEquals("[{\"status\":{\"operator\":\"o\",\"values\":[]}}]", json.strip(), "Filter JSON does not match expected format");
    }

    @Test
    void testBuildFilterJsonWithMultipleFilters() {
        // Create multiple filters
        OPQueryFilterInstance filter1 = OPQueryFilterInstance.of("status", OPQueryFilter.of(FilterOperator.WK_OPEN, List.of()));
        OPQueryFilterInstance filter2 = OPQueryFilterInstance.of("assignee", OPQueryFilter.of(FilterOperator.EQUALS, List.of("me")));
        
        String json = QueryBuilder.buildFilterJson(List.of(filter1, filter2));
        
        assertNotNull(json);
        assertEquals("[{\"status\":{\"operator\":\"o\",\"values\":[]}},{\"assignee\":{\"operator\":\"=\",\"values\":[\"me\"]}}]", json.strip(), "Filter JSON does not match expected format");
    }

    @Test
    void testBuildSortJsonWithSingleField() {
        String json = QueryBuilder.buildSortJson("id", SortEnum.ASC);
        
        assertNotNull(json);
        assertEquals("[[\"id\",\"asc\"]]", json.strip(), "Sort JSON does not match expected format");
    }

    @Test
    void testBuildSortJsonWithMultipleFields() {
        Map<String, SortEnum> sortFields = new LinkedHashMap<>();
        sortFields.put("priority", SortEnum.DESC);
        sortFields.put("id", SortEnum.ASC);
        
        String json = QueryBuilder.buildSortJson(sortFields);
        
        assertNotNull(json);
        assertEquals("[[\"priority\",\"desc\"],[\"id\",\"asc\"]]", json.strip(), "Sort JSON does not match expected format");
    }

    @Test
    void testBuildFilterJsonWithMultipleValues() {
        // Create a filter with multiple values
        OPQueryFilterInstance filter = OPQueryFilterInstance.of("status", OPQueryFilter.of(FilterOperator.EQUALS, List.of("1", "2", "3")));
        
        String json = QueryBuilder.buildFilterJson(filter);
        
        assertNotNull(json);
        assertEquals("[{\"status\":{\"operator\":\"=\",\"values\":[\"1\",\"2\",\"3\"]}}]", json.strip(), "Filter JSON does not match expected format");
    }
}
