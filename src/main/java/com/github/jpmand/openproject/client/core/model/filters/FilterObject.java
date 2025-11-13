package com.github.jpmand.openproject.client.core.model.filters;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents a collection of filter conditions for OpenProject API queries.
 * <p>
 * A FilterObject contains a map of field names to {@link FilterValue} instances,
 * allowing multiple filter conditions to be combined in a single query.
 * Each key represents a field name (e.g., "status", "assignee", "type"),
 * and each value is a FilterValue defining the filter criteria for that field.
 * </p>
 * <p>
 * <b>Usage Examples:</b>
 * <pre>{@code
 * // Single filter for open status
 * FilterObject filters = FilterObject.of("status", FilterValue.of(FilterOperator.WK_OPEN));
 * 
 * // Multiple filters
 * Map<String, FilterValue> filterMap = new LinkedHashMap<>();
 * filterMap.put("status", FilterValue.of(FilterOperator.WK_OPEN));
 * filterMap.put("assignee", FilterValue.of(FilterOperator.EQUALS, "me"));
 * FilterObject filters = FilterObject.of(filterMap);
 * }</pre>
 * 
 * @see FilterValue
 * @see FilterOperator
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilterObject {
    
    /**
     * Map of field names to filter values.
     * Uses LinkedHashMap to preserve insertion order.
     */
    @JsonAnySetter
    @JsonAnyGetter
    private Map<String, FilterValue> filterValues = new LinkedHashMap<>();

    /**
     * Gets all filter values.
     * 
     * @return map of field names to filter values
     */
    public Map<String, FilterValue> getFilterValues() {
        return filterValues;
    }

    /**
     * Sets all filter values.
     * 
     * @param filterValues map of field names to filter values
     */
    public void setFilterValues(Map<String, FilterValue> filterValues) {
        this.filterValues = filterValues;
    }

    /**
     * Creates a FilterObject from a map of filter values.
     * 
     * @param filterValues map of field names to filter values
     * @return a new FilterObject instance
     */
    public static FilterObject of(Map<String, FilterValue> filterValues) {
        FilterObject filterObject = new FilterObject();
        filterObject.setFilterValues(filterValues);
        return filterObject;
    }

    /**
     * Creates a FilterObject with a single filter condition.
     * 
     * @param key the field name to filter on
     * @param filterValue the filter value
     * @return a new FilterObject instance
     */
    public static FilterObject of(String key, FilterValue filterValue) {
        Map<String, FilterValue> filterValues = new LinkedHashMap<>();
        filterValues.put(key, filterValue);
        return of(filterValues);
    }

    /**
     * Extracts the filter values map from a FilterObject.
     * 
     * @param filterObject the FilterObject to extract from
     * @return map of field names to filter values
     */
    public static Map<String, FilterValue> from(FilterObject filterObject) {
        return filterObject.getFilterValues();
    }

    /**
     * Creates a map with a single filter entry.
     * 
     * @param key the field name
     * @param filterValue the filter value
     * @return a map containing the single filter entry
     */
    public static Map<String, FilterValue> from(String key, FilterValue filterValue) {
        return Map.of(key, filterValue);
    }
}
