package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;

import java.util.Objects;

/**
 * Represents a notification resource in OpenProject.
 */
public class OPNotificationModel extends OPBaseResource {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("reason")
    private String reason;

    @JsonProperty("readIAN")
    private Boolean readIAN;

    /**
     * Default constructor.
     */
    public OPNotificationModel() {
    }

    /**
     * Constructs a notification with all properties.
     * @param id the notification ID
     * @param subject the notification subject
     * @param reason the notification reason
     * @param readIAN whether the notification has been read
     */
    public OPNotificationModel(Long id, String subject, String reason, Boolean readIAN) {
        this.id = id;
        this.subject = subject;
        this.reason = reason;
        this.readIAN = readIAN;
    }

    /**
     * Gets the notification ID.
     * @return the notification ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the notification ID.
     * @param id the notification ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the notification subject.
     * @return the notification subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the notification subject.
     * @param subject the notification subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Gets the notification reason.
     * @return the notification reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the notification reason.
     * @param reason the notification reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Gets whether the notification has been read.
     * @return true if read, false otherwise
     */
    public Boolean getReadIAN() {
        return readIAN;
    }

    /**
     * Sets whether the notification has been read.
     * @param readIAN true if read, false otherwise
     */
    public void setReadIAN(Boolean readIAN) {
        this.readIAN = readIAN;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof OPNotificationModel that)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getSubject(), that.getSubject()) &&
                Objects.equals(getReason(), that.getReason()) &&
                Objects.equals(getReadIAN(), that.getReadIAN());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(getId());
        result = 31 * result + Objects.hashCode(getSubject());
        result = 31 * result + Objects.hashCode(getReason());
        result = 31 * result + Objects.hashCode(getReadIAN());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OPNotificationModel{");
        sb.append("id='").append(getId());
        sb.append(", type='").append(getType()).append('\'');
        sb.append(", subject='").append(getSubject()).append('\'');
        sb.append(", reason='").append(getReason()).append('\'');
        sb.append(", readIAN=").append(getReadIAN());
        sb.append(", links=").append(getLinks());
        sb.append('}');
        return sb.toString();
    }
}
