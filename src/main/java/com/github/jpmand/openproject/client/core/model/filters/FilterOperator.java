package com.github.jpmand.openproject.client.core.model.filters;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Filter operators supported by the OpenProject API for filtering work packages and other resources.
 * <p>
 * These operators define the comparison logic applied to filter values when querying the API.
 * Different operators may require different types and numbers of values.
 * </p>
 * 
 * @see FilterValue
 * @see FilterObject
 */
public enum FilterOperator {

    /**
     * Values are equal to one of the given value(s).
     * Requires at least one typed value.
     */
    @JsonProperty("=")
    EQUALS("="),
    
    /**
     * Values contain all of the given value(s).
     * Requires at least one typed value.
     */
    @JsonProperty("&=")
    CONTAINS("&="),
    
    /**
     * Values are not equal to any of the given value(s).
     * Requires at least one typed value.
     */
    @JsonProperty("!")
    NOT_EQUALS("!"),
    
    /**
     * Values are greater than or equal to the given value.
     * Requires one typed value.
     */
    @JsonProperty(">=")
    GREATER_OR_EQUALS(">="),
    
    /**
     * Dates in the past N days.
     * Requires one integer value representing the number of days.
     */
    @JsonProperty("t-")
    PAST_N_DAYS("t-"),
    
    /**
     * Dates in the future N days.
     * Requires one integer value representing the number of days.
     */
    @JsonProperty("t+")
    FUTURE_N_DAYS("t+"),
    
    /**
     * Dates less than N days in the future.
     * Requires one integer value representing the number of days.
     */
    @JsonProperty("<t+")
    FUTURE_LESS_THAN_N_DAYS("<t+"),
    
    /**
     * Dates more than N days in the future.
     * Requires one integer value representing the number of days.
     */
    @JsonProperty(">t+")
    FUTURE_MORE_THAN_N_DAYS(">t+"),
    
    /**
     * Dates less than N days in the past.
     * Requires one integer value representing the number of days.
     */
    @JsonProperty("<t-")
    PAST_LESS_THAN_N_DAYS("<t-"),
    
    /**
     * Dates more than N days in the past.
     * Requires one integer value representing the number of days.
     */
    @JsonProperty(">t-")
    PAST_MORE_THAN_N_DAYS(">t-"),
    
    /**
     * Values are not null (any value exists).
     * Requires no values.
     */
    @JsonProperty("*")
    NOT_NULL("*"),
    
    /**
     * Values are null (no value exists).
     * Requires no values.
     */
    @JsonProperty("!*")
    ARE_NULL("!*"),
    
    /**
     * Search by string using full-text search.
     * Requires one string value.
     */
    @JsonProperty("**")
    SEARCH_BY_STRING("**"),
    
    /**
     * Date equals the specified date.
     * Requires one date value.
     */
    @JsonProperty("=d")
    ON_DATE("=d"),
    
    /**
     * Date is between two specified dates.
     * Requires two date values.
     */
    @JsonProperty("<>d")
    BETWEEN_DATES("<>d"),
    
    /**
     * Date is within the current week.
     * Requires no values.
     */
    @JsonProperty("w")
    THIS_WEEK("w"),
    
    /**
     * Date is today.
     * Requires no values.
     */
    @JsonProperty("t")
    TODAY("t"),
    
    /**
     * String contains the value (SQL LIKE pattern).
     * Requires one string value.
     */
    @JsonProperty("~")
    CONTAINING_SQL_LIKE("~"),
    
    /**
     * String does not contain the value (SQL NOT LIKE pattern).
     * Requires one string value.
     */
    @JsonProperty("!~")
    NOT_CONTAINING_SQL_LIKE("!~"),
    
    /**
     * Work package status is open.
     * Requires no values.
     */
    @JsonProperty("o")
    WK_OPEN("o"),
    
    /**
     * Work package status is closed.
     * Requires no values.
     */
    @JsonProperty("c")
    WK_CLOSED("c"),
    
    /**
     * Work packages in manual order.
     * Requires no values.
     */
    @JsonProperty("ow")
    WK_MANUAL_ORDER("ow");

    FilterOperator(String value){
    }
}