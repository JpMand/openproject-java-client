package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;

import java.util.Objects;

public class OPPriorityModel extends OPBaseResource {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("position")
    private Integer position;

    @JsonProperty("isDefault")
    private Boolean isDefault;

    @JsonProperty("isActive")
    private Boolean isActive;

    public OPPriorityModel() {
    }

    public OPPriorityModel(Long id, String name, Integer position, Boolean isDefault, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.isDefault = isDefault;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof OPPriorityModel that)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getPosition(), that.getPosition()) &&
                Objects.equals(getDefault(), that.getDefault()) &&
                Objects.equals(getActive(), that.getActive());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(getId());
        result = 31 * result + Objects.hashCode(getName());
        result = 31 * result + Objects.hashCode(getPosition());
        result = 31 * result + Objects.hashCode(getDefault());
        result = 31 * result + Objects.hashCode(getActive());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OPPriorityModel{");
        sb.append("id='").append(getId());
        sb.append(", type='").append(getType()).append('\'');
        sb.append(", name='").append(getName()).append('\'');
        sb.append(", position=").append(getPosition());
        sb.append(", isDefault=").append(getDefault());
        sb.append(", isActive=").append(getActive());
        sb.append(", links=").append(getLinks());
        sb.append('}');
        return sb.toString();
    }
}
