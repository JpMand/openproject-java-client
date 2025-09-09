package com.github.jpmand.openproject.client.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.core.model.base.BaseResource;
import com.github.jpmand.openproject.client.core.model.base.Formattable;

import java.time.Duration;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkPackage extends BaseResource {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("description")
    private Formattable description;

    @JsonProperty("scheduleManually")
    private Boolean scheduleManually;

    @JsonProperty("readOnly")
    private Boolean readOnly;

    @JsonProperty("startDate")
    private LocalDate startDate;

    @JsonProperty("dueDate")
    private LocalDate dueDate;

    @JsonProperty("derivedStartDate")
    private LocalDate derivedStartDate;

    @JsonProperty("derivedDueDate")
    private LocalDate derivedDueDate;

    @JsonProperty("duration")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Duration duration;

    @JsonProperty("estimatedTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Duration estimatedTime;

    @JsonProperty("derivedEstimatedTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Duration derivedEstimatedTime;

    @JsonProperty("derivedRemainingTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Duration derivedRemainingTime;

    @JsonProperty("ignoreNonWorkingDays")
    private Boolean ignoreNonWorkingDays;

    @JsonProperty("spentTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Duration spentTime;

    @JsonProperty("percentageDone")
    private Integer percentageDone;

    @JsonProperty("derivedPercentageDone")
    private Integer derivedPercentageDone;

    @JsonProperty("createdAt")
    private OffsetDateTime createdAt;

    @JsonProperty("updatedAt")
    private OffsetDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Formattable getDescription() {
        return description;
    }

    public void setDescription(Formattable description) {
        this.description = description;
    }

    public Boolean getScheduleManually() {
        return scheduleManually;
    }

    public void setScheduleManually(Boolean scheduleManually) {
        this.scheduleManually = scheduleManually;
    }

    public Boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDerivedStartDate() {
        return derivedStartDate;
    }

    public void setDerivedStartDate(LocalDate derivedStartDate) {
        this.derivedStartDate = derivedStartDate;
    }

    public LocalDate getDerivedDueDate() {
        return derivedDueDate;
    }

    public void setDerivedDueDate(LocalDate derivedDueDate) {
        this.derivedDueDate = derivedDueDate;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Duration getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Duration estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public Duration getDerivedEstimatedTime() {
        return derivedEstimatedTime;
    }

    public void setDerivedEstimatedTime(Duration derivedEstimatedTime) {
        this.derivedEstimatedTime = derivedEstimatedTime;
    }

    public Boolean getIgnoreNonWorkingDays() {
        return ignoreNonWorkingDays;
    }

    public void setIgnoreNonWorkingDays(Boolean ignoreNonWorkingDays) {
        this.ignoreNonWorkingDays = ignoreNonWorkingDays;
    }

    public Duration getSpentTime() {
        return spentTime;
    }

    public void setSpentTime(Duration spentTime) {
        this.spentTime = spentTime;
    }

    public Integer getPercentageDone() {
        return percentageDone;
    }

    public void setPercentageDone(Integer percentageDone) {
        this.percentageDone = percentageDone;
    }

    public Integer getDerivedPercentageDone() {
        return derivedPercentageDone;
    }

    public void setDerivedPercentageDone(Integer derivedPercentageDone) {
        this.derivedPercentageDone = derivedPercentageDone;
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
}
