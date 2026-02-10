package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Represents a digest with algorithm and hash information.
 */
public class OPDigest {

    @JsonProperty("algorithm")
    private String algorithm;

    @JsonProperty("hash")
    private String hash;

    /**
     * Gets the digest algorithm.
     * @return the algorithm
     */
    public String getAlgorithm() {
        return algorithm;
    }

    /**
     * Sets the digest algorithm.
     * @param algorithm the algorithm
     */
    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * Gets the hash value.
     * @return the hash
     */
    public String getHash() {
        return hash;
    }

    /**
     * Sets the hash value.
     * @param hash the hash
     */
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
