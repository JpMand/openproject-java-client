package com.github.jpmand.openproject.client.api.models.forms;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;

/**
 * Represents a form resource in OpenProject.
 * @param <T> the type of resource in the form payload
 */
public class OPForm<T extends OPBaseResource> extends OPBaseResource {


    @JsonProperty("_embedded")
    private OPFormEmbedded<T> embedded;

    /**
     * Default constructor.
     */
    public OPForm() {
    }

    /**
     * Gets the embedded form data.
     * @return the embedded form data
     */
    public OPFormEmbedded<T> getEmbedded() {
        return embedded;
    }

    /**
     * Sets the embedded form data.
     * @param embedded the embedded form data
     */
    public void setEmbedded(OPFormEmbedded<T> embedded) {
        this.embedded = embedded;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OPForm{");
        sb.append("type='").append(getType()).append('\'');
        sb.append(", links=").append(getLinks());
        sb.append('}');
        return sb.toString();
    }
}
