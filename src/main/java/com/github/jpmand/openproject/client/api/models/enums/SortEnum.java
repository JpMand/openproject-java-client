package com.github.jpmand.openproject.client.api.models.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SortEnum {

    @JsonProperty("asc")
    ASC("asc"),

    @JsonProperty("desc")
    DESC("desc");

    private final String value;

    private SortEnum(String value){
        this.value = value;
    }
}
