package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;

import java.util.Objects;

public class OPCapabilityModel extends OPBaseResource {

    @JsonProperty("id")
    private String id;

    public OPCapabilityModel() {
    }

    public OPCapabilityModel(String id, String name) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof OPCapabilityModel that)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(getId());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OPCapabilityModel{");
        sb.append("id='").append(getId()).append('\'');
        sb.append(", type='").append(getType()).append('\'');
        sb.append(", links=").append(getLinks());
        sb.append('}');
        return sb.toString();
    }
}
