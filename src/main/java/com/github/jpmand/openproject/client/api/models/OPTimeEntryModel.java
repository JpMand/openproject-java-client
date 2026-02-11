package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;

import java.time.Duration;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Represents a Time Entry resource in OpenProject.
 * Time entries track time spent on work packages and projects.
 */
public class OPTimeEntryModel extends OPBaseResource {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("comment")
    private OPFormattableText comment;

    @JsonProperty("hours")
    private Duration hours;

    @JsonProperty("spentOn")
    private LocalDate spentOn;

    @JsonProperty("ongoing")
    private Boolean ongoing;

    @JsonProperty("startTime")
    private OffsetDateTime startTime;

    @JsonProperty("endTime")
    private OffsetDateTime endTime;

    @JsonProperty("createdAt")
    private OffsetDateTime createdAt;

    @JsonProperty("updatedAt")
    private OffsetDateTime updatedAt;

    /**
     * Default constructor.
     */
    public OPTimeEntryModel() {
    }

    /**
     * Constructs a Time Entry model with all fields.
     *
     * @param id the time entry ID
     * @param comment the comment or description of the work done
     * @param hours the duration of time spent (ISO 8601 duration format)
     * @param spentOn the date for which time is booked
     * @param ongoing whether the time entry is actively tracking time
     * @param startTime the time the time entry was started (nullable)
     * @param endTime the time the time entry was ended (nullable)
     * @param createdAt when the time entry was created
     * @param updatedAt when the time entry was last updated
     */
    public OPTimeEntryModel(Long id, OPFormattableText comment, Duration hours,
                            LocalDate spentOn, Boolean ongoing, OffsetDateTime startTime,
                            OffsetDateTime endTime, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.comment = comment;
        this.hours = hours;
        this.spentOn = spentOn;
        this.ongoing = ongoing;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public Duration getHours() {
        return hours;
    }

    public void setHours(Duration hours) {
        this.hours = hours;
    }

    public LocalDate getSpentOn() {
        return spentOn;
    }

    public void setSpentOn(LocalDate spentOn) {
        this.spentOn = spentOn;
    }

    public Boolean getOngoing() {
        return ongoing;
    }

    public void setOngoing(Boolean ongoing) {
        this.ongoing = ongoing;
    }

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    public OffsetDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
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
        if (!(o instanceof OPTimeEntryModel that)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getComment(), that.getComment()) &&
                Objects.equals(getHours(), that.getHours()) &&
                Objects.equals(getSpentOn(), that.getSpentOn()) &&
                Objects.equals(getOngoing(), that.getOngoing()) &&
                Objects.equals(getStartTime(), that.getStartTime()) &&
                Objects.equals(getEndTime(), that.getEndTime()) &&
                Objects.equals(getCreatedAt(), that.getCreatedAt()) &&
                Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getId());
        result = 31 * result + Objects.hashCode(getComment());
        result = 31 * result + Objects.hashCode(getHours());
        result = 31 * result + Objects.hashCode(getSpentOn());
        result = 31 * result + Objects.hashCode(getOngoing());
        result = 31 * result + Objects.hashCode(getStartTime());
        result = 31 * result + Objects.hashCode(getEndTime());
        result = 31 * result + Objects.hashCode(getCreatedAt());
        result = 31 * result + Objects.hashCode(getUpdatedAt());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OPTimeEntryModel{");
        sb.append("id='").append(getId()).append('\'');
        sb.append(", comment=").append(getComment());
        sb.append(", hours=").append(getHours());
        sb.append(", spentOn=").append(getSpentOn());
        sb.append(", ongoing=").append(getOngoing());
        sb.append(", startTime=").append(getStartTime());
        sb.append(", endTime=").append(getEndTime());
        sb.append(", createdAt=").append(getCreatedAt());
        sb.append(", updatedAt=").append(getUpdatedAt());
        sb.append(", type='").append(getType()).append('\'');
        sb.append(", links=").append(getLinks());
        sb.append('}');
        return sb.toString();
    }
}
