package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Represents a User resource in OpenProject.
 */
public class OPUserModel extends OPBaseResource {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("status")
    private String status;

    @JsonProperty("admin")
    private Boolean admin;

    @JsonProperty("avatar")
    private String avatar;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("login")
    private String login;

    @JsonProperty("language")
    private String language;

    @JsonProperty("createdAt")
    private OffsetDateTime createdAt;

    @JsonProperty("updatedAt")
    private OffsetDateTime updatedAt;

    /**
     * Default constructor.
     */
    public OPUserModel() {
    }

    /**
     * Constructs a User model with all fields.
     *
     * @param id the user ID
     * @param name the user's full name
     * @param email the user's email address
     * @param status the user's status (active, locked, registered)
     * @param admin whether the user has admin privileges
     * @param avatar the URL to the user's avatar
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param login the user's login name
     * @param language the user's language (ISO 639-1 format)
     * @param createdAt when the user was created
     * @param updatedAt when the user was last updated
     */
    public OPUserModel(Long id, String name, String email, String status, Boolean admin,
                       String avatar, String firstName, String lastName, String login,
                       String language, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.status = status;
        this.admin = admin;
        this.avatar = avatar;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.language = language;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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
        if (!(o instanceof OPUserModel that)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getStatus(), that.getStatus()) &&
                Objects.equals(getAdmin(), that.getAdmin()) &&
                Objects.equals(getAvatar(), that.getAvatar()) &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getLogin(), that.getLogin()) &&
                Objects.equals(getLanguage(), that.getLanguage()) &&
                Objects.equals(getCreatedAt(), that.getCreatedAt()) &&
                Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getId());
        result = 31 * result + Objects.hashCode(getName());
        result = 31 * result + Objects.hashCode(getEmail());
        result = 31 * result + Objects.hashCode(getStatus());
        result = 31 * result + Objects.hashCode(getAdmin());
        result = 31 * result + Objects.hashCode(getAvatar());
        result = 31 * result + Objects.hashCode(getFirstName());
        result = 31 * result + Objects.hashCode(getLastName());
        result = 31 * result + Objects.hashCode(getLogin());
        result = 31 * result + Objects.hashCode(getLanguage());
        result = 31 * result + Objects.hashCode(getCreatedAt());
        result = 31 * result + Objects.hashCode(getUpdatedAt());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OPUserModel{");
        sb.append("id='").append(getId()).append('\'');
        sb.append(", name='").append(getName()).append('\'');
        sb.append(", email='").append(getEmail()).append('\'');
        sb.append(", status='").append(getStatus()).append('\'');
        sb.append(", admin=").append(getAdmin());
        sb.append(", avatar='").append(getAvatar()).append('\'');
        sb.append(", firstName='").append(getFirstName()).append('\'');
        sb.append(", lastName='").append(getLastName()).append('\'');
        sb.append(", login='").append(getLogin()).append('\'');
        sb.append(", language='").append(getLanguage()).append('\'');
        sb.append(", createdAt=").append(getCreatedAt());
        sb.append(", updatedAt=").append(getUpdatedAt());
        sb.append(", type='").append(getType()).append('\'');
        sb.append(", links=").append(getLinks());
        sb.append('}');
        return sb.toString();
    }
}
