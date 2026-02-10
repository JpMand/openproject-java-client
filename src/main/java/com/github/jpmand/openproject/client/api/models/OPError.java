package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.api.models.base.OPBaseLink;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents an error resource in OpenProject.
 */
public class OPError extends OPBaseResource {

    @JsonProperty("errorIdentifier")
    private String errorIdentifier;

    @JsonProperty("message")
    private String message;

    private Map<String, Object> parameters = new HashMap<>();

    /**
     * Default constructor.
     */
    public OPError() {
    }

    /**
     * Constructs an error with identifier, message, and parameters.
     * @param errorIdentifier the error identifier
     * @param message the error message
     * @param parameters the error parameters
     */
    public OPError(String errorIdentifier, String message, Map<String, Object> parameters) {
        this.errorIdentifier = errorIdentifier;
        this.message = message;
        this.parameters = parameters;
    }

    /**
     * Constructs an error with all properties including type and links.
     * @param type the resource type
     * @param links the HAL links
     * @param errorIdentifier the error identifier
     * @param message the error message
     * @param parameters the error parameters
     */
    public OPError(String type, Map<String, List<OPBaseLink>> links, String errorIdentifier, String message, Map<String, Object> parameters) {
        super(type, links);
        this.errorIdentifier = errorIdentifier;
        this.message = message;
        this.parameters = parameters;
    }

    /**
     * Gets the error identifier.
     * @return the error identifier
     */
    public String getErrorIdentifier() {
        return errorIdentifier;
    }

    /**
     * Sets the error identifier.
     * @param errorIdentifier the error identifier
     */
    public void setErrorIdentifier(String errorIdentifier) {
        this.errorIdentifier = errorIdentifier;
    }

    /**
     * Gets the error message.
     * @return the error message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the error message.
     * @param message the error message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the error parameters.
     * @return the error parameters
     */
    @JsonAnyGetter
    public Map<String, Object> getParameters() {
        return parameters;
    }

    /**
     * Sets an error parameter.
     * @param key the parameter key
     * @param value the parameter value
     */
    @JsonAnySetter
    public void setParameters(String key, Object value) {
        this.parameters.put(key, value);
    }
}
