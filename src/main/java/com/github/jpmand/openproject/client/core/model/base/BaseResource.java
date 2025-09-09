package com.github.jpmand.openproject.client.core.model.base;

import com.fasterxml.jackson.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(alphabetic = false)
public class BaseResource {

    @JsonProperty("_type")
    private String type;

    @JsonProperty("_links")
    private Map<String, List<BaseLink>> links;

    @JsonProperty("_embedded")
    private Map<String, List<BaseResource>> embedded;

    @JsonAnySetter
    @JsonAnyGetter
    private Map<String, Object> properties;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, List<BaseLink>> getLinks() {
        return links;
    }

    public void setLinks(Map<String, List<BaseLink>> links) {
        if (null != links) {
            for (Map.Entry<String, List<BaseLink>> entry : links.entrySet()) {
                if (null != entry.getValue()) {
                    for (BaseLink link : entry.getValue()) {
                        link.setRel(entry.getKey());
                    }
                }
            }
        }
        this.links = links;
    }

    public Map<String, List<BaseResource>> getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Map<String, List<BaseResource>> embedded) {
        this.embedded = embedded;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public List<BaseLink> getLinksByRel(String rel) {
        return this.links.getOrDefault(rel, null);
    }

    public Optional<BaseLink> getSingleLinkByRel(String rel) {
        return null != this.getLinksByRel(rel) ? this.getLinksByRel(rel).stream().findFirst() : Optional.empty();
    }
}
