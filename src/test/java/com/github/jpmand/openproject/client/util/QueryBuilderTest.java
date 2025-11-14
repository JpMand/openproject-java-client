package com.github.jpmand.openproject.client.util;

import com.github.jpmand.openproject.client.api.models.enums.FilterOperator;
import com.github.jpmand.openproject.client.api.models.enums.SortEnum;
import com.github.jpmand.openproject.client.api.models.filters.OPFilterObject;
import com.github.jpmand.openproject.client.api.models.filters.OPFilterValue;
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
        OPFilterObject filter = OPFilterObject.of("status", OPFilterValue.of(FilterOperator.WK_OPEN, List.of()));
        
        String json = QueryBuilder.buildFilterJson(filter);
        
        assertNotNull(json);
        assertTrue(json.contains("status"));
        assertTrue(json.contains("o")); // operator value
    }

    @Test
    void testBuildFilterJsonWithMultipleFilters() {
        // Create multiple filters
        OPFilterObject filter1 = OPFilterObject.of("status", OPFilterValue.of(FilterOperator.WK_OPEN, List.of()));
        OPFilterObject filter2 = OPFilterObject.of("assignee", OPFilterValue.of(FilterOperator.EQUALS, List.of("me")));
        
        String json = QueryBuilder.buildFilterJson(List.of(filter1, filter2));
        
        assertNotNull(json);
        assertTrue(json.contains("status"));
        assertTrue(json.contains("assignee"));
    }

    @Test
    void testBuildSortJsonWithSingleField() {
        String json = QueryBuilder.buildSortJson("id", SortEnum.ASC);
        
        assertNotNull(json);
        assertTrue(json.contains("id"));
        assertTrue(json.contains("asc"));
    }

    @Test
    void testBuildSortJsonWithMultipleFields() {
        Map<String, SortEnum> sortFields = new LinkedHashMap<>();
        sortFields.put("priority", SortEnum.DESC);
        sortFields.put("id", SortEnum.ASC);
        
        String json = QueryBuilder.buildSortJson(sortFields);
        
        assertNotNull(json);
        assertTrue(json.contains("priority"));
        assertTrue(json.contains("desc"));
        assertTrue(json.contains("id"));
        assertTrue(json.contains("asc"));
    }

    @Test
    void testBuildFilterJsonWithMultipleValues() {
        // Create a filter with multiple values
        OPFilterObject filter = OPFilterObject.of("status", OPFilterValue.of(FilterOperator.EQUALS, List.of("1", "2", "3")));
        
        String json = QueryBuilder.buildFilterJson(filter);
        
        assertNotNull(json);
        assertTrue(json.contains("status"));
    }
}
