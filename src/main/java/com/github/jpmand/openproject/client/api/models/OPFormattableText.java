package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class OPFormattableText {

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

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof OPFormattableText that)) return false;

        return Objects.equals(getRaw(), that.getRaw()) && Objects.equals(getFormat(), that.getFormat()) && Objects.equals(getHtml(), that.getHtml());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getRaw());
        result = 31 * result + Objects.hashCode(getFormat());
        result = 31 * result + Objects.hashCode(getHtml());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OPFormattableText{");
        sb.append("format='").append(format).append('\'');
        sb.append(", raw='").append(raw).append('\'');
        //sb.append(", html='").append(html).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
