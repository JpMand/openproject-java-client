package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Represents a Revision (repository commit/changeset) resource in OpenProject.
 */
public class OPRevisionModel extends OPBaseResource {

    @JsonProperty("id")
    private String id;

    @JsonProperty("identifier")
    private String identifier;

    @JsonProperty("formattedIdentifier")
    private String formattedIdentifier;

    @JsonProperty("authorName")
    private String authorName;

    @JsonProperty("message")
    private OPFormattableText message;

    @JsonProperty("createdAt")
    private OffsetDateTime createdAt;

    /**
     * Default constructor.
     */
    public OPRevisionModel() {
    }

    /**
     * Constructs a Revision model with all fields.
     *
     * @param id the revision ID (commit hash or changeset number)
     * @param identifier the revision identifier
     * @param formattedIdentifier the formatted identifier for display
     * @param authorName the name of the author/committer
     * @param message the commit message or description
     * @param createdAt when the revision was created
     */
    public OPRevisionModel(String id, String identifier, String formattedIdentifier,
                           String authorName, OPFormattableText message, OffsetDateTime createdAt) {
        this.id = id;
        this.identifier = identifier;
        this.formattedIdentifier = formattedIdentifier;
        this.authorName = authorName;
        this.message = message;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getFormattedIdentifier() {
        return formattedIdentifier;
    }

    public void setFormattedIdentifier(String formattedIdentifier) {
        this.formattedIdentifier = formattedIdentifier;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public OPFormattableText getMessage() {
        return message;
    }

    public void setMessage(OPFormattableText message) {
        this.message = message;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OPRevisionModel that)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getIdentifier(), that.getIdentifier()) &&
                Objects.equals(getFormattedIdentifier(), that.getFormattedIdentifier()) &&
                Objects.equals(getAuthorName(), that.getAuthorName()) &&
                Objects.equals(getMessage(), that.getMessage()) &&
                Objects.equals(getCreatedAt(), that.getCreatedAt());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getId());
        result = 31 * result + Objects.hashCode(getIdentifier());
        result = 31 * result + Objects.hashCode(getFormattedIdentifier());
        result = 31 * result + Objects.hashCode(getAuthorName());
        result = 31 * result + Objects.hashCode(getMessage());
        result = 31 * result + Objects.hashCode(getCreatedAt());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OPRevisionModel{");
        sb.append("id='").append(getId()).append('\'');
        sb.append(", identifier='").append(getIdentifier()).append('\'');
        sb.append(", formattedIdentifier='").append(getFormattedIdentifier()).append('\'');
        sb.append(", authorName='").append(getAuthorName()).append('\'');
        sb.append(", message=").append(getMessage());
        sb.append(", createdAt=").append(getCreatedAt());
        sb.append(", type='").append(getType()).append('\'');
        sb.append(", links=").append(getLinks());
        sb.append('}');
        return sb.toString();
    }
}
