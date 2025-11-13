package com.github.jpmand.openproject.client.core.model.filters;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

/**
 * Represents a filter value with an operator and associated values for OpenProject API filtering.
 * <p>
 * A FilterValue combines a {@link FilterOperator} with zero or more values to create
 * a complete filter condition. The number and type of values required depends on the operator.
 * </p>
 * <p>
 * <b>Usage Examples:</b>
 * <pre>{@code
 * // Filter for open status
 * FilterValue openStatus = FilterValue.of(FilterOperator.WK_OPEN);
 * 
 * // Filter for specific IDs
 * FilterValue idFilter = FilterValue.of(FilterOperator.EQUALS, List.of("1", "2", "3"));
 * 
 * // Filter for a single value
 * FilterValue singleValue = FilterValue.of(FilterOperator.EQUALS, "1");
 * }</pre>
 * 
 * @see FilterOperator
 * @see FilterObject
 */
public class FilterValue {

    /**
     * The filter operator to apply.
     */
    @JsonProperty("operator")
    private FilterOperator operator;

    /**
     * The values to use with the operator.
     * May be empty for operators that don't require values (e.g., WK_OPEN, NOT_NULL).
     */
    @JsonProperty("values")
    private List<Object> values;

    /**
     * Gets the filter operator.
     * 
     * @return the filter operator
     */
    public FilterOperator getOperator() {
        return operator;
    }

    /**
     * Sets the filter operator.
     * 
     * @param operator the filter operator to set
     */
    public void setOperator(FilterOperator operator) {
        this.operator = operator;
    }

    /**
     * Gets the filter values.
     * 
     * @return the list of filter values
     */
    public List<Object> getValues() {
        return values;
    }

    /**
     * Sets the filter values.
     * 
     * @param values the list of values to set
     */
    public void setValues(List<Object> values) {
        this.values = values;
    }

    /**
     * Creates a FilterValue with the specified operator and values.
     * 
     * @param operator the filter operator
     * @param values the list of values
     * @return a new FilterValue instance
     */
    public static FilterValue of(FilterOperator operator, List<Object> values) {
        FilterValue filterValue = new FilterValue();
        filterValue.setOperator(operator);
        filterValue.setValues(values);
        return filterValue;
    }

    /**
     * Creates a FilterValue with the specified operator and a single value.
     * 
     * @param operator the filter operator
     * @param value the single value
     * @return a new FilterValue instance
     */
    public static FilterValue of(FilterOperator operator, Object value) {
        return of(operator, List.of(value));
    }

    /**
     * Creates a FilterValue with the specified operator and no values.
     * Useful for operators that don't require values (e.g., WK_OPEN, NOT_NULL).
     * 
     * @param operator the filter operator
     * @return a new FilterValue instance with an empty values list
     */
    public static FilterValue of(FilterOperator operator) {
        return of(operator, Collections.emptyList());
    }
}
