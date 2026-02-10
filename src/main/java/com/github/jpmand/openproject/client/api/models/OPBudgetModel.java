package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;

import java.util.Objects;

/**
 * Represents a budget resource in OpenProject.
 */
public class OPBudgetModel extends OPBaseResource {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("subject")
    private String subject;

    /**
     * Default constructor.
     */
    public OPBudgetModel() {
    }

    /**
     * Constructs a budget with id and subject.
     * @param id the budget ID
     * @param subject the budget subject
     */
    public OPBudgetModel(Long id, String subject) {
        this.id = id;
        this.subject = subject;
    }

    /**
     * Gets the budget ID.
     * @return the budget ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the budget ID.
     * @param id the budget ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the budget subject.
     * @return the budget subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the budget subject.
     * @param subject the budget subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof OPBudgetModel that)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(getId(), that.getId()) && Objects.equals(getSubject(), that.getSubject());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(getId());
        result = 31 * result + Objects.hashCode(getSubject());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OPBudgetModel{");
        sb.append("id='").append(getId());
        sb.append(", type='").append(getType()).append('\'');
        sb.append(", subject='").append(getSubject()).append('\'');
        sb.append(", links=").append(getLinks());
        sb.append('}');
        return sb.toString();
    }
}
