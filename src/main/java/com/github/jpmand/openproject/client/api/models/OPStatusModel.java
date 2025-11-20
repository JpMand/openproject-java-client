package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;

import java.util.Objects;

public class OPStatusModel extends OPBaseResource {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("isClosed")
    private Boolean isClosed;

    @JsonProperty("color")
    private String color;

    @JsonProperty("isDefault")
    private Boolean isDefault;

    @JsonProperty("isReadonly")
    private Boolean isReadonly;

    @JsonProperty("excludedFromTotals")
    private Boolean excludedFromTotals;

    @JsonProperty("defaultDoneRatio")
    private Integer defaultDoneRatio;

    @JsonProperty("position")
    private Integer position;

    public OPStatusModel() {
    }

    public OPStatusModel(Long id, String name, Boolean isClosed, String color, Boolean isDefault, Boolean isReadonly, Boolean excludedFromTotals, Integer defaultDoneRatio, Integer position) {
        this.id = id;
        this.name = name;
        this.isClosed = isClosed;
        this.color = color;
        this.isDefault = isDefault;
        this.isReadonly = isReadonly;
        this.excludedFromTotals = excludedFromTotals;
        this.defaultDoneRatio = defaultDoneRatio;
        this.position = position;
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

    public Boolean getClosed() {
        return isClosed;
    }

    public void setClosed(Boolean closed) {
        isClosed = closed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public Boolean getReadonly() {
        return isReadonly;
    }

    public void setReadonly(Boolean readonly) {
        isReadonly = readonly;
    }

    public Boolean getExcludedFromTotals() {
        return excludedFromTotals;
    }

    public void setExcludedFromTotals(Boolean excludedFromTotals) {
        this.excludedFromTotals = excludedFromTotals;
    }

    public Integer getDefaultDoneRatio() {
        return defaultDoneRatio;
    }

    public void setDefaultDoneRatio(Integer defaultDoneRatio) {
        this.defaultDoneRatio = defaultDoneRatio;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof OPStatusModel that)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getClosed(), that.getClosed()) && Objects.equals(getColor(), that.getColor()) && Objects.equals(getDefault(), that.getDefault()) && Objects.equals(getReadonly(), that.getReadonly()) && Objects.equals(getExcludedFromTotals(), that.getExcludedFromTotals()) && Objects.equals(getDefaultDoneRatio(), that.getDefaultDoneRatio()) && Objects.equals(getPosition(), that.getPosition());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(getId());
        result = 31 * result + Objects.hashCode(getName());
        result = 31 * result + Objects.hashCode(getClosed());
        result = 31 * result + Objects.hashCode(getColor());
        result = 31 * result + Objects.hashCode(getDefault());
        result = 31 * result + Objects.hashCode(getReadonly());
        result = 31 * result + Objects.hashCode(getExcludedFromTotals());
        result = 31 * result + Objects.hashCode(getDefaultDoneRatio());
        result = 31 * result + Objects.hashCode(getPosition());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OPStatusModel{");
        sb.append("id=").append(getId());
        sb.append(", type='").append(getType()).append('\'');
        sb.append(", name='").append(getName()).append('\'');
        sb.append(", isClosed=").append(getClosed());
        sb.append(", color='").append(getColor()).append('\'');
        sb.append(", isDefault=").append(getDefault());
        sb.append(", isReadonly=").append(getReadonly());
        sb.append(", excludedFromTotals=").append(getExcludedFromTotals());
        sb.append(", defaultDoneRatio=").append(getDefaultDoneRatio());
        sb.append(", position=").append(getPosition());
        sb.append(", closed=").append(getClosed());
        sb.append(", default=").append(getDefault());
        sb.append(", readonly=").append(getReadonly());
        sb.append(", links=").append(getLinks());
        sb.append('}');
        return sb.toString();
    }
}
