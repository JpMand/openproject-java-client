package com.github.jpmand.openproject.client.core.model.base;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Formattable {

    @JsonProperty("format")
    private String format;

    @JsonProperty("raw")
    private String raw;

    @JsonProperty("html")
    private String html;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
