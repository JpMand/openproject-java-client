package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class OPDigest {

    @JsonProperty("algorithm")
    private String algorithm;

    @JsonProperty("hash")
    private String hash;

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof OPDigest that)) return false;

        return Objects.equals(getHash(), that.getHash()) && Objects.equals(getAlgorithm(), that.getAlgorithm());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getHash());
        result = 31 * result + Objects.hashCode(getAlgorithm());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OPDigest{");
        sb.append("format='").append(getAlgorithm()).append('\'');
        sb.append(", hash='").append(getHash()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
