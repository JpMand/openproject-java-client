package com.github.jpmand.openproject.client.core.model.filters;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Special filter values used in OpenProject API filters.
 * <p>
 * These values represent boolean-like states used in specific filter contexts.
 * </p>
 * 
 * @see FilterValue
 * @see FilterOperator
 */
public enum FilterSpecialValue {
    /**
     * Represents a true/positive value in filter contexts.
     */
    @JsonProperty("t")
    TRUE("t"),

    /**
     * Represents a false/negative value in filter contexts.
     */
    @JsonProperty("f")
    FALSE("f");

    FilterSpecialValue(String value) {
    }
}
