package com.github.jpmand.openproject.client.core.model.base;

import com.fasterxml.jackson.annotation.*;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(alphabetic = false)
public class PagedCollectionResource<T> extends BaseResource {
    @JsonProperty("total")
    private Long total;

    @JsonProperty("pageSize")
    private Long pageSize;

    @JsonProperty("count")
    private Long count;

    @JsonProperty("offset")
    private Long offset;

    @JsonProperty("_embedded")
    private CollectionEmbedded<T> embedded;

    public PagedCollectionResource() {
    }

    public PagedCollectionResource(Long total, Long pageSize, Long count, Long offset, CollectionEmbedded<T> embedded) {
        this.total = total;
        this.pageSize = pageSize;
        this.count = count;
        this.offset = offset;
        this.embedded = embedded;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public CollectionEmbedded<T> getEmbedded() {
        return embedded;
    }

    public void setEmbedded(CollectionEmbedded<T> embedded) {
        this.embedded = embedded;
    }

    @JsonPropertyOrder(alphabetic = false)
    public static class CollectionEmbedded<T> {

        public CollectionEmbedded() {
        }

        @JsonProperty("elements")
        private List<T> elements;

        @JsonAnyGetter
        @JsonAnySetter
        private Map<String, List<BaseResource>> others;

        public List<T> getElements() {
            return elements;
        }

        public void setElements(List<T> elements) {
            this.elements = elements;
        }

        public Map<String, List<BaseResource>> getOthers() {
            return others;
        }

        public void setOthers(Map<String, List<BaseResource>> others) {
            this.others = others;
        }
    }
}
