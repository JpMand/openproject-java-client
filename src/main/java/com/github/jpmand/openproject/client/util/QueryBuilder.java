package com.github.jpmand.openproject.client.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jpmand.openproject.client.api.models.enums.SortEnum;
import com.github.jpmand.openproject.client.api.models.filters.OPQueryFilterInstance;
import com.github.jpmand.openproject.client.api.models.filters.OPQueryFilter;
import com.github.jpmand.openproject.client.http.serialization.HalObjectMapper;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class for building OpenProject API query parameters.
 * <p>
 * Provides methods to convert filter and sort objects into the JSON string format
 * required by the OpenProject API.
 * </p>
 * <p>
 * <b>Usage Examples:</b>
 * <pre>{@code
 * // Build filter JSON
 * OPFilterObject filters = OPFilterObject.of("status", OPFilterValue.of(FilterOperator.WK_OPEN, List.of()));
 * String filterJson = QueryBuilder.buildFilterJson(filters);
 * 
 * // Build sort JSON
 * String sortJson = QueryBuilder.buildSortJson("id", SortEnum.ASC);
 * 
 * // Build multi-field sort JSON using Map
 * Map<String, SortEnum> sortMap = new LinkedHashMap<>();
 * sortMap.put("status", SortEnum.DESC);
 * sortMap.put("id", SortEnum.ASC);
 * String multiSort = QueryBuilder.buildSortJson(sortMap);
 * }</pre>
 * 
 * @see OPQueryFilterInstance
 * @see OPQueryFilter
 * @see SortEnum
 */
public class QueryBuilder {
    
    private static final ObjectMapper objectMapper = HalObjectMapper.get();
    
    /**
     * Builds a filter JSON string from a list of OPFilterObjects.
     * 
     * @param filters the list of filter objects
     * @return JSON string representation of the filters
     * @throws RuntimeException if JSON serialization fails
     */
    public static String buildFilterJson(List<OPQueryFilterInstance> filters) {
        try {
            return objectMapper.writeValueAsString(filters);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize filters to JSON", e);
        }
    }
    
    /**
     * Builds a filter JSON string from a single OPFilterObject.
     * 
     * @param filter the filter object
     * @return JSON string representation of the filter
     * @throws RuntimeException if JSON serialization fails
     */
    public static String buildFilterJson(OPQueryFilterInstance filter) {
        return buildFilterJson(List.of(filter));
    }
    
    /**
     * Builds a sort JSON string for a single field.
     * 
     * @param field the field name to sort by
     * @param direction the sort direction
     * @return JSON string representation of the sort criteria (e.g., [["id","asc"]])
     * @throws RuntimeException if JSON serialization fails
     */
    public static String buildSortJson(String field, SortEnum direction) {
        Map<String, SortEnum> sortMap = new LinkedHashMap<>();
        sortMap.put(field, direction);
        return buildSortJson(sortMap);
    }
    
    /**
     * Builds a sort JSON string for multiple fields using a Map.
     * Use LinkedHashMap to preserve insertion order if order matters.
     * 
     * @param sortFields map of field names to sort directions
     * @return JSON string representation of the sort criteria
     * @throws RuntimeException if JSON serialization fails
     */
    public static String buildSortJson(Map<String, SortEnum> sortFields) {
        List<List<String>> sortCriteria = new ArrayList<>();
        sortFields.forEach((field, direction) -> 
            sortCriteria.add(List.of(field, direction.name().toLowerCase()))
        );
        
        try {
            return objectMapper.writeValueAsString(sortCriteria);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize sort criteria to JSON", e);
        }
    }
}
