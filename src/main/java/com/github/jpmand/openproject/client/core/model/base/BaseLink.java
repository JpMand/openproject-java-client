package com.github.jpmand.openproject.client.core.model.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_ABSENT;

@JsonInclude(NON_ABSENT)
public class BaseLink {
    @JsonIgnore
    private String rel;

    @JsonProperty("href")
    private String href;
    @JsonProperty("templated")
    private Boolean templated;
    @JsonProperty("method")
    private String method;
    @JsonProperty("payload")
    private JsonNode payload;
    @JsonProperty("identifier")
    private String identifier;
    @JsonProperty("type")
    private String type;
    @JsonProperty("deprecation")
    private String deprecation;
    @JsonProperty("name")
    private String name;
    @JsonProperty("profile")
    private String profile;
    @JsonProperty("title")
    private String title;
    @JsonProperty("hreflang")
    private String hreflang;

    public BaseLink() {
    }

    public BaseLink(String rel, String href, Boolean templated, String method, JsonNode payload, String identifier, String type, String deprecation, String name, String profile, String title, String hreflang) {
        this.rel = rel;
        this.href = href;
        this.templated = templated;
        this.method = method;
        this.payload = payload;
        this.identifier = identifier;
        this.type = type;
        this.deprecation = deprecation;
        this.name = name;
        this.profile = profile;
        this.title = title;
        this.hreflang = hreflang;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Boolean getTemplated() {
        return templated;
    }

    public void setTemplated(Boolean templated) {
        this.templated = templated;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDeprecation() {
        return deprecation;
    }

    public void setDeprecation(String deprecation) {
        this.deprecation = deprecation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHreflang() {
        return hreflang;
    }

    public void setHreflang(String hreflang) {
        this.hreflang = hreflang;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public JsonNode getPayload() {
        return payload;
    }

    public void setPayload(JsonNode payload) {
        this.payload = payload;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
