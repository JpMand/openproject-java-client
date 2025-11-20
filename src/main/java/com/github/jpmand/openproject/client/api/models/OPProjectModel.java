package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;

import java.time.OffsetDateTime;
import java.util.Objects;

public class OPProjectModel extends OPBaseResource {


    @JsonProperty("id")
    private Long id;

    @JsonProperty("identifier")
    private String identifier;

    @JsonProperty("name")
    private String name;

    @JsonProperty("active")
    private Boolean active;

    @JsonProperty("statusExplanation")
    private OPFormattableText statusExplanation;

    @JsonProperty("public")
    private Boolean isPublic;

    @JsonProperty("description")
    private OPFormattableText description;

    @JsonProperty("createdAt")
    private OffsetDateTime createdAt;

    @JsonProperty("updatedAt")
    private OffsetDateTime updatedAt;

    public OPProjectModel() {
    }

    public OPProjectModel(Long id, String identifier, String name, Boolean active, OPFormattableText statusExplanation, Boolean isPublic, OPFormattableText description, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.identifier = identifier;
        this.name = name;
        this.active = active;
        this.statusExplanation = statusExplanation;
        this.isPublic = isPublic;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public OPFormattableText getStatusExplanation() {
        return statusExplanation;
    }

    public void setStatusExplanation(OPFormattableText statusExplanation) {
        this.statusExplanation = statusExplanation;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public OPFormattableText getDescription() {
        return description;
    }

    public void setDescription(OPFormattableText description) {
        this.description = description;
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
    public final boolean equals(Object o) {
        if (!(o instanceof OPProjectModel that)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(getId(), that.getId()) && Objects.equals(getIdentifier(), that.getIdentifier()) && Objects.equals(getName(), that.getName()) && Objects.equals(getActive(), that.getActive()) && Objects.equals(getStatusExplanation(), that.getStatusExplanation()) && Objects.equals(getPublic(), that.getPublic()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(getId());
        result = 31 * result + Objects.hashCode(getIdentifier());
        result = 31 * result + Objects.hashCode(getName());
        result = 31 * result + Objects.hashCode(getActive());
        result = 31 * result + Objects.hashCode(getStatusExplanation());
        result = 31 * result + Objects.hashCode(getPublic());
        result = 31 * result + Objects.hashCode(getDescription());
        result = 31 * result + Objects.hashCode(getCreatedAt());
        result = 31 * result + Objects.hashCode(getUpdatedAt());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OPProjectModel{");
        sb.append("id=").append(getId());
        sb.append(", type='").append(getType()).append('\'');
        sb.append(", identifier='").append(getIdentifier()).append('\'');
        sb.append(", name='").append(getName()).append('\'');
        sb.append(", active=").append(getActive());
        sb.append(", statusExplanation=").append(getStatusExplanation());
        sb.append(", isPublic=").append(isPublic);
        sb.append(", description=").append(getDescription());
        sb.append(", createdAt=").append(getCreatedAt());
        sb.append(", updatedAt=").append(getUpdatedAt());
        sb.append(", public=").append(getPublic());
        sb.append(", links=").append(getLinks());
        sb.append('}');
        return sb.toString();
    }
}
