package com.github.jpmand.openproject.client.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jpmand.openproject.client.api.models.base.OPBaseResource;

import java.time.OffsetDateTime;
import java.util.Objects;

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


    public OPAttachmentModel() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public OPFormattableText getDescription() {
        return description;
    }

    public void setDescription(OPFormattableText description) {
        this.description = description;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public OPDigest getDigest() {
        return digest;
    }

    public void setDigest(OPDigest digest) {
        this.digest = digest;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }


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
