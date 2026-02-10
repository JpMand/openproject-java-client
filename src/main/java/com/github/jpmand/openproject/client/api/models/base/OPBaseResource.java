package com.github.jpmand.openproject.client.api.models.base;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Base class for HAL+JSON resources in the OpenProject API.
 * Provides common properties and methods for handling HAL links and resource types.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OPBaseResource {

    /**
     * The "self" link relation constant.
     */
    public static final String SELF_LINK = "self";

    @JsonProperty("_type")
    private String type;

    @JsonProperty("_links")
    private Map<String, List<OPBaseLink>> links;

    @JsonAnySetter
    @JsonAnyGetter
    private Map<String, Object> properties;

    /**
     * Default constructor.
     */
    public OPBaseResource() {
    }

    /**
     * Constructs a resource with type and links.
     * @param type the resource type
     * @param links the HAL links
     */
    public OPBaseResource(String type, Map<String, List<OPBaseLink>> links) {
        this.type = type;
        this.links = links;
    }

    /**
     * Gets the resource type.
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the resource type.
     * @param _type the type
     */
    public void setType(String _type) {
        this.type = _type;
    }

    /**
     * Gets the HAL links.
     * @return the links map
     */
    public Map<String, List<OPBaseLink>> getLinks() {
        return links;
    }

    /**
     * Sets the HAL links.
     * @param _links the links map
     */
    public void setLinks(Map<String, List<OPBaseLink>> _links) {
        this.links = _links;
    }

    /**
     * Gets the additional properties.
     * @return the properties map
     */
    public Map<String, Object> getProperties() {
        return properties;
    }

    /**
     * Sets the additional properties.
     * @param properties the properties map
     */
    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    /**
     * Gets a list of links by relation name.
     * @param rel the link relation
     * @return the list of links, or null if not found
     */
    public List<OPBaseLink> getLink(String rel) {
        return null != this.links? this.links.getOrDefault(rel, null) : null;
    }

    /**
     * Gets a single link by relation name.
     * @param rel the link relation
     * @return the first link, or null if not found
     */
    public OPBaseLink getSingleLink(String rel) {
        return (this.getLink(rel) == null || this.getLink(rel).isEmpty()) ? null : this.getLink(rel).get(0);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OPBaseResource that)) return false;

        return Objects.equals(getType(), that.getType()) && Objects.deepEquals(getLinks(), that.getLinks());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getType());
        result = 31 * result + Objects.hashCode(getLinks());
        return result;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OPBaseResource{");
        sb.append("type='").append(getType()).append('\'');
        sb.append(", links=").append(getLinks());
        sb.append('}');
        return sb.toString();
    }
}
