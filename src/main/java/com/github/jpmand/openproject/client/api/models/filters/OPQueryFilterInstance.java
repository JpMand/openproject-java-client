package com.github.jpmand.openproject.client.api.models.filters;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OPQueryFilterInstance {

    private Map<String, OPQueryFilter> filterValues = new LinkedHashMap<>();

    @JsonAnyGetter
    public Map<String, OPQueryFilter> getFilterValues() {
        return filterValues;
    }

    @JsonAnySetter
    public void setFilterValues(Map<String, OPQueryFilter> filterValues) {
        this.filterValues = filterValues;
    }

    public static OPQueryFilterInstance of(Map<String, OPQueryFilter> filterValues) {
        OPQueryFilterInstance filterObject = new OPQueryFilterInstance();
        filterObject.setFilterValues(filterValues);
        return filterObject;
    }

    public static OPQueryFilterInstance of(String key, OPQueryFilter filterValue) {
        Map<String, OPQueryFilter> filterValues = new LinkedHashMap<>();
        filterValues.put(key, filterValue);
        return of(filterValues);
    }

    public static Map<String, OPQueryFilter> from(OPQueryFilterInstance filterObject) {
        return filterObject.getFilterValues();
    }

    public static Map<String, OPQueryFilter> from(String key, OPQueryFilter filterValue) {
        return Map.of(key, filterValue);
    }

}
