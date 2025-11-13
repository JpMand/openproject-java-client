package com.github.jpmand.openproject.client.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SortEnum {
    @JsonProperty("asc")
    ASC("asc"),

    @JsonProperty("desc")
    DESC("desc");

    SortEnum(String value) {
    }
}
