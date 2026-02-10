package com.github.jpmand.openproject.client.api.models.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

/**
 * Base class for HAL+JSON links in the OpenProject API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OPBaseLink {
    private static final String UNDISCLOSED_LINK = "urn:openproject-org:api:v3:undisclosed";

    private String href;
    private String title;
    private Boolean templated;
    private String method;
    private String identifier;

    /**
     * Default constructor.
     */
    public OPBaseLink() {
    }

    /**
     * Constructs a link with all properties.
     * @param href the link URL
     * @param title the link title
     * @param templated whether the link is templated
     * @param method the HTTP method for the link
     * @param identifier the link identifier
     */
    public OPBaseLink(String href, String title, Boolean templated, String method, String identifier) {
        this.href = href;
        this.title = title;
        this.templated = templated;
        this.method = method;
        this.identifier = identifier;
    }

    /**
     * Gets the link URL.
     * @return the href
     */
    public String getHref() {
        return href;
    }

    /**
     * Sets the link URL.
     * @param href the href
     */
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * Gets the link title.
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the link title.
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets whether the link is templated.
     * @return true if templated
     */
    public Boolean getTemplated() {
        return templated;
    }

    /**
     * Sets whether the link is templated.
     * @param templated true if templated
     */
    public void setTemplated(Boolean templated) {
        this.templated = templated;
    }

    /**
     * Gets the HTTP method for this link.
     * @return the HTTP method
     */
    public String getMethod() {
        return method;
    }

    /**
     * Sets the HTTP method for this link.
     * @param method the HTTP method
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * Gets the link identifier.
     * @return the identifier
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Sets the link identifier.
     * @param identifier the identifier
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Checks if this link is an undisclosed link.
     * @return true if the link is undisclosed
     */
    public boolean isUndisclosed() {
        return Objects.equals(getHref(), UNDISCLOSED_LINK);
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof OPBaseLink that)) return false;

        return Objects.equals(getHref(), that.getHref()) && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getTemplated(), that.getTemplated()) && Objects.equals(getMethod(), that.getMethod()) && Objects.equals(getIdentifier(), that.getIdentifier());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getHref());
        result = 31 * result + Objects.hashCode(getTitle());
        result = 31 * result + Objects.hashCode(getTemplated());
        result = 31 * result + Objects.hashCode(getMethod());
        result = 31 * result + Objects.hashCode(getIdentifier());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OPBaseLink{");
        sb.append("href='").append(href).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", templated=").append(templated);
        sb.append(", method='").append(method).append('\'');
        sb.append(", identifier='").append(identifier).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
