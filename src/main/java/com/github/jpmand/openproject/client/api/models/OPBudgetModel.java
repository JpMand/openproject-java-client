package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;

import java.util.Objects;

public class OPBudgetModel extends OPBaseResource {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("subject")
    private String subject;

    public OPBudgetModel() {
    }

    public OPBudgetModel(Long id, String subject) {
        this.id = id;
        this.subject = subject;
    }

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
