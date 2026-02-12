package com.github.jpmand.openproject.client.api.models.filters;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.api.models.enums.FilterOperator;

import java.util.Collections;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OPQueryFilter {

    public static OPQueryFilter WK_OPEN_FILTER = OPQueryFilter.of(FilterOperator.WK_OPEN, Collections.emptyList());
    public static OPQueryFilter WK_CLOSED_FILTER = OPQueryFilter.of(FilterOperator.WK_CLOSED, Collections.emptyList());
    public static OPQueryFilter WK_MANUAL_ORDER = OPQueryFilter.of(FilterOperator.WK_MANUAL_ORDER, Collections.emptyList());

    private OPQueryFilter() {
    }

    private OPQueryFilter(FilterOperator operator, List<Object> values) {
        this.operator = operator;
        this.values = values;
    }

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

    public static OPQueryFilter of(FilterOperator operator, List<Object> values) {
        return new OPQueryFilter(operator, values);
    }

    public static OPQueryFilter of(FilterOperator operator, Object value) {
        return of(operator, List.of(value));
    }
}
