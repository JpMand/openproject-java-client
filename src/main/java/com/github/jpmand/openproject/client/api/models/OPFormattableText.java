package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Represents formattable text with format, raw content, and HTML representation.
 */
public class OPFormattableText {

    @JsonProperty("format")
    private String format;

    @JsonProperty("raw")
    private String raw;

    @JsonProperty("html")
    private String html;

    /**
     * Gets the text format.
     * @return the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the text format.
     * @param format the format
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Gets the raw text content.
     * @return the raw text
     */
    public String getRaw() {
        return raw;
    }

    /**
     * Sets the raw text content.
     * @param raw the raw text
     */
    public void setRaw(String raw) {
        this.raw = raw;
    }

    /**
     * Gets the HTML representation.
     * @return the HTML
     */
    public String getHtml() {
        return html;
    }

    /**
     * Sets the HTML representation.
     * @param html the HTML
     */
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
