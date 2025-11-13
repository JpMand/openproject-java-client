package com.github.jpmand.openproject.client.core.model.filters;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum FilterSpecialValue {
    @JsonProperty("t")
    TRUE("t"),

    @JsonProperty("f")
    FALSE("f");

    FilterSpecialValue(String value) {
    }
}
