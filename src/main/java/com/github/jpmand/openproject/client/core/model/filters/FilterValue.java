package com.github.jpmand.openproject.client.core.model.filters;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

public class FilterValue {

    @JsonProperty("operator")
    private FilterOperator operator;

    @JsonProperty("values")
    private List<Object> values;

    public FilterOperator getOperator() {
        return operator;
    }

    public void setOperator(FilterOperator operator) {
        this.operator = operator;
    }

    public List<Object> getValues() {
        return values;
    }

    public void setValues(List<Object> values) {
        this.values = values;
    }

    public static FilterValue of(FilterOperator operator, List<Object> values) {
        FilterValue filterValue = new FilterValue();
        filterValue.setOperator(operator);
        filterValue.setValues(values);
        return filterValue;
    }

    public static FilterValue of(FilterOperator operator, Object value) {
        return of(operator, List.of(value));
    }

    public static FilterValue of(FilterOperator operator) {
        return of(operator, Collections.emptyList());
    }
}
