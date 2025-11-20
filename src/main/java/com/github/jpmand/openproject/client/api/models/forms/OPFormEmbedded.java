package com.github.jpmand.openproject.client.api.models.forms;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.api.models.OPError;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;

import java.util.Map;
import java.util.Objects;

public class OPFormEmbedded<T extends OPBaseResource> {

    @JsonProperty("payload")
    private T payload;

    @JsonProperty("schema")
    private Object schema;

    @JsonProperty("validationErrors")
    private Map<String, OPError> validationErrors;

    public OPFormEmbedded() {
    }

    public OPFormEmbedded(T payload, Object schema, Map<String, OPError> validationErrors) {
        this.payload = payload;
        this.schema = schema;
        this.validationErrors = validationErrors;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public Object getSchema() {
        return schema;
    }

    public void setSchema(Object schema) {
        this.schema = schema;
    }

    public Map<String, OPError> getValidationErrors() {
        return validationErrors;
    }

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
