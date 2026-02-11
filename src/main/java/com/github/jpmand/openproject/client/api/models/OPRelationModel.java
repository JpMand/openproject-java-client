package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Represents a Relation resource in OpenProject.
 * Relations represent connections between work packages.
 */
public class OPRelationModel extends OPBaseResource {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String relationType;

    @JsonProperty("description")
    private String description;

    @JsonProperty("lag")
    private Integer lag;

    @JsonProperty("reverseType")
    private String reverseType;

    @JsonProperty("createdAt")
    private OffsetDateTime createdAt;

    @JsonProperty("updatedAt")
    private OffsetDateTime updatedAt;

    /**
     * Default constructor.
     */
    public OPRelationModel() {
    }

    /**
     * Constructs a Relation model with all fields.
     *
     * @param id the relation ID
     * @param name the user-friendly name of the relation type
     * @param relationType the relation type (blocks, precedes, relates, etc.)
     * @param description short text describing the relation
     * @param lag the time lag between related work packages (in days)
     * @param reverseType the relation type as seen from the target work package's side
     * @param createdAt when the relation was created
     * @param updatedAt when the relation was last updated
     */
    public OPRelationModel(Long id, String name, String relationType, String description,
                           Integer lag, String reverseType,
                           OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.relationType = relationType;
        this.description = description;
        this.lag = lag;
        this.reverseType = reverseType;
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

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLag() {
        return lag;
    }

    public void setLag(Integer lag) {
        this.lag = lag;
    }

    public String getReverseType() {
        return reverseType;
    }

    public void setReverseType(String reverseType) {
        this.reverseType = reverseType;
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
        if (!(o instanceof OPRelationModel that)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getRelationType(), that.getRelationType()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getLag(), that.getLag()) &&
                Objects.equals(getReverseType(), that.getReverseType()) &&
                Objects.equals(getCreatedAt(), that.getCreatedAt()) &&
                Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getId());
        result = 31 * result + Objects.hashCode(getName());
        result = 31 * result + Objects.hashCode(getRelationType());
        result = 31 * result + Objects.hashCode(getDescription());
        result = 31 * result + Objects.hashCode(getLag());
        result = 31 * result + Objects.hashCode(getReverseType());
        result = 31 * result + Objects.hashCode(getCreatedAt());
        result = 31 * result + Objects.hashCode(getUpdatedAt());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OPRelationModel{");
        sb.append("id='").append(getId()).append('\'');
        sb.append(", name='").append(getName()).append('\'');
        sb.append(", relationType='").append(getRelationType()).append('\'');
        sb.append(", description='").append(getDescription()).append('\'');
        sb.append(", lag=").append(getLag());
        sb.append(", reverseType='").append(getReverseType()).append('\'');
        sb.append(", createdAt=").append(getCreatedAt());
        sb.append(", updatedAt=").append(getUpdatedAt());
        sb.append(", type='").append(getType()).append('\'');
        sb.append(", links=").append(getLinks());
        sb.append('}');
        return sb.toString();
    }
}
