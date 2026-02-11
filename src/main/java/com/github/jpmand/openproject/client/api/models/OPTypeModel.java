package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Represents a Type (Work Package Type) resource in OpenProject.
 */
public class OPTypeModel extends OPBaseResource {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("color")
    private String color;

    @JsonProperty("position")
    private Integer position;

    @JsonProperty("isDefault")
    private Boolean isDefault;

    @JsonProperty("isMilestone")
    private Boolean isMilestone;

    @JsonProperty("createdAt")
    private OffsetDateTime createdAt;

    @JsonProperty("updatedAt")
    private OffsetDateTime updatedAt;

    /**
     * Default constructor.
     */
    public OPTypeModel() {
    }

    /**
     * Constructs a Type model with all fields.
     *
     * @param id the type ID
     * @param name the type name
     * @param color the color in hex format
     * @param position the sort order position
     * @param isDefault whether this is the default type
     * @param isMilestone whether this type represents a milestone
     * @param createdAt when the type was created
     * @param updatedAt when the type was last updated
     */
    public OPTypeModel(Long id, String name, String color, Integer position,
                       Boolean isDefault, Boolean isMilestone,
                       OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.position = position;
        this.isDefault = isDefault;
        this.isMilestone = isMilestone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Boolean getIsMilestone() {
        return isMilestone;
    }

    public void setIsMilestone(Boolean isMilestone) {
        this.isMilestone = isMilestone;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OPTypeModel that)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getColor(), that.getColor()) &&
                Objects.equals(getPosition(), that.getPosition()) &&
                Objects.equals(getIsDefault(), that.getIsDefault()) &&
                Objects.equals(getIsMilestone(), that.getIsMilestone()) &&
                Objects.equals(getCreatedAt(), that.getCreatedAt()) &&
                Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getId());
        result = 31 * result + Objects.hashCode(getName());
        result = 31 * result + Objects.hashCode(getColor());
        result = 31 * result + Objects.hashCode(getPosition());
        result = 31 * result + Objects.hashCode(getIsDefault());
        result = 31 * result + Objects.hashCode(getIsMilestone());
        result = 31 * result + Objects.hashCode(getCreatedAt());
        result = 31 * result + Objects.hashCode(getUpdatedAt());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OPTypeModel{");
        sb.append("id='").append(getId()).append('\'');
        sb.append(", name='").append(getName()).append('\'');
        sb.append(", color='").append(getColor()).append('\'');
        sb.append(", position=").append(getPosition());
        sb.append(", isDefault=").append(getIsDefault());
        sb.append(", isMilestone=").append(getIsMilestone());
        sb.append(", createdAt=").append(getCreatedAt());
        sb.append(", updatedAt=").append(getUpdatedAt());
        sb.append(", type='").append(getType()).append('\'');
        sb.append(", links=").append(getLinks());
        sb.append('}');
        return sb.toString();
    }
}
