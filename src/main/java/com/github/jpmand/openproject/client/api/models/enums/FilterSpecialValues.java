package com.github.jpmand.openproject.client.api.models.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum FilterSpecialValues {
    @JsonProperty("t")
    TRUE("t"),

    @JsonProperty("f")
    FALSE("f");

    private final String value;

    public String value() {
        return value;
    }

    private FilterSpecialValues(String value) {
        this.value = value;
    }
}
