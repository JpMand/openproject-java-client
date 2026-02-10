package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Represents an attachment resource in the OpenProject API.
 */
public class OPAttachmentModel extends OPBaseResource {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("fileName")
    private String fileName;

    @JsonProperty("fileSize")
    private Integer fileSize;

    @JsonProperty("description")
    private OPFormattableText description;

    @JsonProperty("contentType")
    private String contentType;

    @JsonProperty("digest")
    private OPDigest digest;

    @JsonProperty("createdAt")
    private OffsetDateTime createdAt;


    /**
     * Default constructor.
     */
    public OPAttachmentModel() {
    }

    /**
     * Constructs an attachment with all properties.
     * @param id the attachment ID
     * @param title the attachment title
     * @param fileName the file name
     * @param fileSize the file size in bytes
     * @param description the attachment description
     * @param contentType the MIME content type
     * @param digest the file digest information
     * @param createdAt the creation timestamp
     */
    public OPAttachmentModel(Long id, String title, String fileName, Integer fileSize, OPFormattableText description, String contentType, OPDigest digest, OffsetDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.description = description;
        this.contentType = contentType;
        this.digest = digest;
        this.createdAt = createdAt;
    }

    /**
     * Gets the attachment ID.
     * @return the attachment ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the attachment ID.
     * @param id the attachment ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the attachment title.
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the attachment title.
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the file name.
     * @return the file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the file name.
     * @param fileName the file name
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Gets the file size in bytes.
     * @return the file size
     */
    public Integer getFileSize() {
        return fileSize;
    }

    /**
     * Sets the file size in bytes.
     * @param fileSize the file size
     */
    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * Gets the attachment description.
     * @return the description
     */
    public OPFormattableText getDescription() {
        return description;
    }

    /**
     * Sets the attachment description.
     * @param description the description
     */
    public void setDescription(OPFormattableText description) {
        this.description = description;
    }

    /**
     * Gets the MIME content type.
     * @return the content type
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Sets the MIME content type.
     * @param contentType the content type
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * Gets the file digest information.
     * @return the digest
     */
    public OPDigest getDigest() {
        return digest;
    }

    /**
     * Sets the file digest information.
     * @param digest the digest
     */
    public void setDigest(OPDigest digest) {
        this.digest = digest;
    }

    /**
     * Gets the creation timestamp.
     * @return the creation timestamp
     */
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the creation timestamp.
     * @param createdAt the creation timestamp
     */
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }


    /**
     * Gets the download location URL from the HAL links.
     * @return the download location URL, or null if not available
     */
    public String getDownloadLocationLink(){
        return null != this.getSingleLink("downloadLocation")? this.getSingleLink("downloadLocation").getHref() : null;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof OPAttachmentModel that)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(getId(), that.getId()) && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getFileName(), that.getFileName()) && Objects.equals(getFileSize(), that.getFileSize()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getContentType(), that.getContentType()) && Objects.equals(getDigest(), that.getDigest()) && Objects.equals(getCreatedAt(), that.getCreatedAt());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(getId());
        result = 31 * result + Objects.hashCode(getTitle());
        result = 31 * result + Objects.hashCode(getFileName());
        result = 31 * result + Objects.hashCode(getFileSize());
        result = 31 * result + Objects.hashCode(getDescription());
        result = 31 * result + Objects.hashCode(getContentType());
        result = 31 * result + Objects.hashCode(getDigest());
        result = 31 * result + Objects.hashCode(getCreatedAt());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OPAttachmentModel{");
        sb.append("id=").append(getId());
        sb.append(", type='").append(getType()).append('\'');
        sb.append(", title='").append(getTitle()).append('\'');
        sb.append(", fileName='").append(getFileName()).append('\'');
        sb.append(", fileSize=").append(getFileSize());
        sb.append(", description=").append(getDescription());
        sb.append(", contentType='").append(getContentType()).append('\'');
        sb.append(", digest=").append(getDigest());
        sb.append(", createdAt=").append(getCreatedAt());
        sb.append(", links=").append(getLinks());
        sb.append('}');
        return sb.toString();
    }
}
