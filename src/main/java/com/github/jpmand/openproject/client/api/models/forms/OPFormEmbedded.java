package com.github.jpmand.openproject.client.api.models.forms;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.api.models.OPError;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;

import java.util.Map;
import java.util.Objects;

/**
 * Represents the embedded data in a form resource.
 * @param <T> the type of resource in the payload
 */
public class OPFormEmbedded<T extends OPBaseResource> {

    @JsonProperty("payload")
    private T payload;

    @JsonProperty("schema")
    private Object schema;

    @JsonProperty("validationErrors")
    private Map<String, OPError> validationErrors;

    /**
     * Default constructor.
     */
    public OPFormEmbedded() {
    }

    /**
     * Constructs a form embedded with payload, schema, and validation errors.
     * @param payload the form payload
     * @param schema the form schema
     * @param validationErrors the validation errors
     */
    public OPFormEmbedded(T payload, Object schema, Map<String, OPError> validationErrors) {
        this.payload = payload;
        this.schema = schema;
        this.validationErrors = validationErrors;
    }

    /**
     * Gets the form payload.
     * @return the payload
     */
    public T getPayload() {
        return payload;
    }

    /**
     * Sets the form payload.
     * @param payload the payload
     */
    public void setPayload(T payload) {
        this.payload = payload;
    }

    /**
     * Gets the form schema.
     * @return the schema
     */
    public Object getSchema() {
        return schema;
    }

    /**
     * Sets the form schema.
     * @param schema the schema
     */
    public void setSchema(Object schema) {
        this.schema = schema;
    }

    /**
     * Gets the validation errors.
     * @return the validation errors map
     */
    public Map<String, OPError> getValidationErrors() {
        return validationErrors;
    }

    /**
     * Sets the validation errors.
     * @param validationErrors the validation errors map
     */
    public void setValidationErrors(Map<String, OPError> validationErrors) {
        this.validationErrors = validationErrors;
    }


    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof OPFormEmbedded<?> that)) return false;

        return Objects.equals(getPayload(), that.getPayload()) && Objects.equals(getSchema(), that.getSchema()) && Objects.equals(getValidationErrors(), that.getValidationErrors());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getPayload());
        result = 31 * result + Objects.hashCode(getSchema());
        result = 31 * result + Objects.hashCode(getValidationErrors());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OPFormEmbedded{");
        sb.append("payload=").append(getPayload());
        sb.append(", schema=").append(getSchema());
        sb.append(", validationErrors=").append(getValidationErrors());
        sb.append('}');
        return sb.toString();
    }
}
