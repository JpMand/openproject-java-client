package com.github.jpmand.openproject.client.api.models.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Special boolean values used in OpenProject API filters.
 */
public enum FilterSpecialValues {
    /**
     * True value
     */
    @JsonProperty("t")
    TRUE("t"),

    /**
     * False value
     */
    @JsonProperty("f")
    FALSE("f");

    private final String value;

    /**
     * Gets the string value of this filter special value.
     * @return the string value
     */
    public String value() {
        return value;
    }

    private FilterSpecialValues(String value) {
        this.value = value;
    }
}
