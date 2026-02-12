package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Represents a Version (milestone/release) resource in OpenProject.
 */
public class OPVersionModel extends OPBaseResource {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private OPFormattableText description;

    @JsonProperty("startDate")
    private LocalDate startDate;

    @JsonProperty("endDate")
    private LocalDate endDate;

    @JsonProperty("status")
    private String status;

    @JsonProperty("sharing")
    private String sharing;

    @JsonProperty("createdAt")
    private OffsetDateTime createdAt;

    @JsonProperty("updatedAt")
    private OffsetDateTime updatedAt;

    /**
     * Default constructor.
     */
    public OPVersionModel() {
    }

    /**
     * Constructs a Version model with all fields.
     *
     * @param id the version ID
     * @param name the version name
     * @param description the version description
     * @param startDate the version start date
     * @param endDate the version end date
     * @param status the version status (open, locked, closed)
     * @param sharing the sharing scope (none, descendants, hierarchy, tree, system)
     * @param createdAt when the version was created
     * @param updatedAt when the version was last updated
     */
    public OPVersionModel(Long id, String name, OPFormattableText description,
                          LocalDate startDate, LocalDate endDate, String status,
                          String sharing, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.sharing = sharing;
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

    public OPFormattableText getDescription() {
        return description;
    }

    public void setDescription(OPFormattableText description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSharing() {
        return sharing;
    }

    public void setSharing(String sharing) {
        this.sharing = sharing;
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
        if (!(o instanceof OPVersionModel that)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getStartDate(), that.getStartDate()) &&
                Objects.equals(getEndDate(), that.getEndDate()) &&
                Objects.equals(getStatus(), that.getStatus()) &&
                Objects.equals(getSharing(), that.getSharing()) &&
                Objects.equals(getCreatedAt(), that.getCreatedAt()) &&
                Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getId());
        result = 31 * result + Objects.hashCode(getName());
        result = 31 * result + Objects.hashCode(getDescription());
        result = 31 * result + Objects.hashCode(getStartDate());
        result = 31 * result + Objects.hashCode(getEndDate());
        result = 31 * result + Objects.hashCode(getStatus());
        result = 31 * result + Objects.hashCode(getSharing());
        result = 31 * result + Objects.hashCode(getCreatedAt());
        result = 31 * result + Objects.hashCode(getUpdatedAt());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OPVersionModel{");
        sb.append("id='").append(getId()).append('\'');
        sb.append(", name='").append(getName()).append('\'');
        sb.append(", description=").append(getDescription());
        sb.append(", startDate=").append(getStartDate());
        sb.append(", endDate=").append(getEndDate());
        sb.append(", status='").append(getStatus()).append('\'');
        sb.append(", sharing='").append(getSharing()).append('\'');
        sb.append(", createdAt=").append(getCreatedAt());
        sb.append(", updatedAt=").append(getUpdatedAt());
        sb.append(", type='").append(getType()).append('\'');
        sb.append(", links=").append(getLinks());
        sb.append('}');
        return sb.toString();
    }
}
