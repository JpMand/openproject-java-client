package com.github.jpmand.openproject.client.util;

import com.github.jpmand.openproject.client.core.model.SortEnum;
import com.github.jpmand.openproject.client.core.model.filters.FilterObject;
import com.github.jpmand.openproject.client.core.model.filters.FilterOperator;
import com.github.jpmand.openproject.client.core.model.filters.FilterValue;
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
        FilterObject filter = FilterObject.of("status", FilterValue.of(FilterOperator.WK_OPEN));
        
        String json = QueryBuilder.buildFilterJson(filter);
        
        assertNotNull(json);
        assertTrue(json.contains("status"));
        assertTrue(json.contains("o")); // operator value
    }

    @Test
    void testBuildFilterJsonWithMultipleFilters() {
        // Create multiple filters
        FilterObject filter1 = FilterObject.of("status", FilterValue.of(FilterOperator.WK_OPEN));
        FilterObject filter2 = FilterObject.of("assignee", FilterValue.of(FilterOperator.EQUALS, "me"));
        
        String json = QueryBuilder.buildFilterJson(List.of(filter1, filter2));
        
        assertNotNull(json);
        assertTrue(json.contains("status"));
        assertTrue(json.contains("assignee"));
    }

    @Test
    void testBuildSortJsonWithSingleField() {
        String json = QueryBuilder.buildSortJson("id", SortEnum.ASC);
        
        assertNotNull(json);
        assertEquals("[[\"id\",\"asc\"]]", json);
    }

    @Test
    void testBuildSortJsonWithMultipleFieldsUsingMap() {
        Map<String, SortEnum> sortMap = new LinkedHashMap<>();
        sortMap.put("status", SortEnum.DESC);
        sortMap.put("id", SortEnum.ASC);
        
        String json = QueryBuilder.buildSortJson(sortMap);
        
        assertNotNull(json);
        assertEquals("[[\"status\",\"desc\"],[\"id\",\"asc\"]]", json);
    }

    @Test
    void testFilterWithValues() {
        // Create a filter with multiple values
        FilterObject filter = FilterObject.of("id", 
            FilterValue.of(FilterOperator.EQUALS, List.of("1", "2", "3")));
        
        String json = QueryBuilder.buildFilterJson(filter);
        
        assertNotNull(json);
        assertTrue(json.contains("id"));
        assertTrue(json.contains("1"));
        assertTrue(json.contains("2"));
        assertTrue(json.contains("3"));
    }
}
