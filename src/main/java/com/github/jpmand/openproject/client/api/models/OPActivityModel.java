package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Represents an Activity (comment or journal entry) resource in OpenProject.
 * Activities represent changes and comments made on work packages.
 */
public class OPActivityModel extends OPBaseResource {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("comment")
    private OPFormattableText comment;

    @JsonProperty("details")
    private List<OPDigest> details;

    @JsonProperty("version")
    private Integer version;

    @JsonProperty("createdAt")
    private OffsetDateTime createdAt;

    @JsonProperty("updatedAt")
    private OffsetDateTime updatedAt;

    /**
     * Default constructor.
     */
    public OPActivityModel() {
    }

    /**
     * Constructs an Activity model with all fields.
     *
     * @param id the activity ID
     * @param comment the comment content
     * @param details array describing property changes
     * @param version internal version indicator
     * @param createdAt when the activity was created
     * @param updatedAt when the activity was last updated
     */
    public OPActivityModel(Long id, OPFormattableText comment, List<OPDigest> details,
                           Integer version, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.comment = comment;
        this.details = details;
        this.version = version;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OPFormattableText getComment() {
        return comment;
    }

    public void setComment(OPFormattableText comment) {
        this.comment = comment;
    }

    public List<OPDigest> getDetails() {
        return details;
    }

    public void setDetails(List<OPDigest> details) {
        this.details = details;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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
        if (!(o instanceof OPActivityModel that)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getComment(), that.getComment()) &&
                Objects.equals(getDetails(), that.getDetails()) &&
                Objects.equals(getVersion(), that.getVersion()) &&
                Objects.equals(getCreatedAt(), that.getCreatedAt()) &&
                Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getId());
        result = 31 * result + Objects.hashCode(getComment());
        result = 31 * result + Objects.hashCode(getDetails());
        result = 31 * result + Objects.hashCode(getVersion());
        result = 31 * result + Objects.hashCode(getCreatedAt());
        result = 31 * result + Objects.hashCode(getUpdatedAt());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OPActivityModel{");
        sb.append("id='").append(getId()).append('\'');
        sb.append(", comment=").append(getComment());
        sb.append(", details=").append(getDetails());
        sb.append(", version=").append(getVersion());
        sb.append(", createdAt=").append(getCreatedAt());
        sb.append(", updatedAt=").append(getUpdatedAt());
        sb.append(", type='").append(getType()).append('\'');
        sb.append(", links=").append(getLinks());
        sb.append('}');
        return sb.toString();
    }
}
