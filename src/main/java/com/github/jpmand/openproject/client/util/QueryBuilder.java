package com.github.jpmand.openproject.client.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jpmand.openproject.client.core.model.SortEnum;
import com.github.jpmand.openproject.client.core.model.filters.FilterObject;
import com.github.jpmand.openproject.client.core.serialization.HalObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for building OpenProject API query parameters.
 * <p>
 * Provides methods to convert filter and sort objects into the JSON string format
 * required by the OpenProject API.
 * </p>
 * 
 * <h3>Usage Examples:</h3>
 * <pre>{@code
 * // Build filter JSON
 * FilterObject filters = FilterObject.of("status", FilterValue.of(FilterOperator.WK_OPEN));
 * String filterJson = QueryBuilder.buildFilterJson(filters);
 * 
 * // Build sort JSON
 * String sortJson = QueryBuilder.buildSortJson("id", SortEnum.ASC);
 * 
 * // Build multi-field sort JSON
 * String multiSort = QueryBuilder.buildSortJson(
 *     List.of("status", "id"),
 *     List.of(SortEnum.DESC, SortEnum.ASC)
 * );
 * }</pre>
 * 
 * @see FilterObject
 * @see com.github.jpmand.openproject.client.core.model.filters.FilterValue
 * @see SortEnum
 */
public class QueryBuilder {
    
    private static final ObjectMapper objectMapper = HalObjectMapper.get();
    
    /**
     * Builds a filter JSON string from a list of FilterObjects.
     * 
     * @param filters the list of filter objects
     * @return JSON string representation of the filters
     * @throws RuntimeException if JSON serialization fails
     */
    public static String buildFilterJson(List<FilterObject> filters) {
        try {
            return objectMapper.writeValueAsString(filters);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize filters to JSON", e);
        }
    }
    
    /**
     * Builds a filter JSON string from a single FilterObject.
     * 
     * @param filter the filter object
     * @return JSON string representation of the filter
     * @throws RuntimeException if JSON serialization fails
     */
    public static String buildFilterJson(FilterObject filter) {
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
        return buildSortJson(List.of(field), List.of(direction));
    }
    
    /**
     * Builds a sort JSON string for multiple fields.
     * 
     * @param fields the list of field names to sort by
     * @param directions the list of sort directions (must match the size of fields)
     * @return JSON string representation of the sort criteria
     * @throws IllegalArgumentException if fields and directions lists have different sizes
     * @throws RuntimeException if JSON serialization fails
     */
    public static String buildSortJson(List<String> fields, List<SortEnum> directions) {
        if (fields.size() != directions.size()) {
            throw new IllegalArgumentException("Fields and directions lists must have the same size");
        }
        
        List<List<String>> sortCriteria = new ArrayList<>();
        for (int i = 0; i < fields.size(); i++) {
            sortCriteria.add(List.of(fields.get(i), directions.get(i).name().toLowerCase()));
        }
        
        try {
            return objectMapper.writeValueAsString(sortCriteria);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize sort criteria to JSON", e);
        }
    }
}
