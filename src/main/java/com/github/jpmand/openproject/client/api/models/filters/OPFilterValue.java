package com.github.jpmand.openproject.client.api.models.filters;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.api.models.enums.FilterOperator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OPFilterValue {

    public static OPFilterValue WK_OPEN_FILTER = OPFilterValue.of(FilterOperator.WK_OPEN, Collections.emptyList());
    public static OPFilterValue WK_CLOSED_FILTER = OPFilterValue.of(FilterOperator.WK_CLOSED, Collections.emptyList());
    public static OPFilterValue WK_MANUAL_ORDER = OPFilterValue.of(FilterOperator.WK_MANUAL_ORDER, Collections.emptyList());

    private OPFilterValue() {
    }

    private OPFilterValue(FilterOperator operator, List<Object> values) {
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

    public static OPFilterValue of(FilterOperator operator, List<Object> values) {
        final OPFilterValue filterValue = new OPFilterValue(operator, new ArrayList<>(values.size()));
        Collections.copy(filterValue.values, values);
        return filterValue;
    }

    public static OPFilterValue of(FilterOperator operator, Object value) {
        return of(operator, List.of(value));
    }
}
