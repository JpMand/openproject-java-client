package com.github.jpmand.openproject.client.core.model.filters;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilterObject {
    @JsonAnySetter
    @JsonAnyGetter
    private Map<String, FilterValue> filterValues = new LinkedHashMap<>();


    public Map<String, FilterValue> getFilterValues() {
        return filterValues;
    }

    public void setFilterValues(Map<String, FilterValue> filterValues) {
        this.filterValues = filterValues;
    }

    public static FilterObject of(Map<String, FilterValue> filterValues) {
        FilterObject filterObject = new FilterObject();
        filterObject.setFilterValues(filterValues);
        return filterObject;
    }

    public static FilterObject of(String key, FilterValue filterValue) {
        Map<String, FilterValue> filterValues = new LinkedHashMap<>();
        filterValues.put(key, filterValue);
        return of(filterValues);
    }

    public static Map<String, FilterValue> from(FilterObject filterObject) {
        return filterObject.getFilterValues();
    }

    public static Map<String, FilterValue> from(String key, FilterValue filterValue) {
        return Map.of(key, filterValue);
    }
}
