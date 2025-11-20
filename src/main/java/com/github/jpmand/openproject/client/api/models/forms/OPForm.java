package com.github.jpmand.openproject.client.api.models.forms;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;

public class OPForm<T extends OPBaseResource> extends OPBaseResource {


    @JsonProperty("_embedded")
    private OPFormEmbedded<T> embedded;

    public OPForm() {
    }

    public OPFormEmbedded<T> getEmbedded() {
        return embedded;
    }

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
