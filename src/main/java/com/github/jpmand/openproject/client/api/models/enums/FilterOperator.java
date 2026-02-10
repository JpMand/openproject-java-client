package com.github.jpmand.openproject.client.api.models.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Filter operators for OpenProject API queries.
 */
public enum FilterOperator {

    /**
     * are equal to one of the given value(s)
     * At least one typed value
     */
    @JsonProperty("=")
    EQUALS("="),
    /**
     * are containing all of the given value(s)
     * At least one typed value
     */
    @JsonProperty("&=")
    CONTAINS("&="),
    /**
     * are not equal one of the given value(s)
     * At least one typed value
     */
    @JsonProperty("!")
    NOT_EQUALS("!"),
    /**
     * Greater than or equal to
     */
    @JsonProperty(">=")
    GREATER_OR_EQUALS(">="),
    /**
     * Past N days
     */
    @JsonProperty("t-")
    PAST_N_DAYS("t-"),
    /**
     * Future N days
     */
    @JsonProperty("t+")
    FUTURE_N_DAYS("t+"),
    /**
     * Future less than N days
     */
    @JsonProperty("<t+")
    FUTURE_LESS_THAN_N_DAYS("<t+"),
    /**
     * Future more than N days
     */
    @JsonProperty(">t+")
    FUTURE_MORE_THAN_N_DAYS(">t+"),
    /**
     * Past less than N days
     */
    @JsonProperty("<t-")
    PAST_LESS_THAN_N_DAYS("<t-"),
    /**
     * Past more than N days
     */
    @JsonProperty(">t-")
    PAST_MORE_THAN_N_DAYS(">t-"),
    /**
     * Not null
     */
    @JsonProperty("*")
    NOT_NULL("*"),
    /**
     * Are null
     */
    @JsonProperty("!*")
    ARE_NULL("!*"),
    /**
     * Search by string
     */
    @JsonProperty("**")
    SEARCH_BY_STRING("**"),
    /**
     * On date
     */
    @JsonProperty("=d")
    ON_DATE("=d"),
    /**
     * Between dates
     */
    @JsonProperty("<>d")
    BETWEEN_DATES("<>d"),
    /**
     * This week
     */
    @JsonProperty("w")
    THIS_WEEK("w"),
    /**
     * Today
     */
    @JsonProperty("t")
    TODAY("t"),
    /**
     * Containing (SQL LIKE)
     */
    @JsonProperty("~")
    CONTAINING_SQL_LIKE("~"),
    /**
     * Not containing (SQL LIKE)
     */
    @JsonProperty("!~")
    NOT_CONTAINING_SQL_LIKE("!~"),
    /**
     * Work package open status filter
     */
    @JsonProperty("o")
    WK_OPEN("o"),
    /**
     * Work package closed status filter
     */
    @JsonProperty("c")
    WK_CLOSED("c"),
    /**
     * Work package manual order filter
     */
    @JsonProperty("ow")
    WK_MANUAL_ORDER("ow");

    private final String value;

    /**
     * Gets the operator value.
     * @return the operator value
     */
    public String value(){
        return value;
    }

    /**
     * Constructs a filter operator.
     * @param value the operator value
     */
    private FilterOperator(String value){
        this.value = value;
    }
}
