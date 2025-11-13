package com.github.jpmand.openproject.client.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Sort order enumeration for OpenProject API queries.
 * <p>
 * Defines the direction in which results should be sorted.
 * </p>
 * 
 * @see com.github.jpmand.openproject.client.api.services.WorkPackageService
 */
public enum SortEnum {
    /**
     * Ascending order (A to Z, 0 to 9, oldest to newest).
     */
    @JsonProperty("asc")
    ASC("asc"),

    /**
     * Descending order (Z to A, 9 to 0, newest to oldest).
     */
    @JsonProperty("desc")
    DESC("desc");

    SortEnum(String value) {
    }
}
