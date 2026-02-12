package com.github.jpmand.openproject.client.api.models.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

/**
 * Abstract base class for paginated collections in the OpenProject API.
 * @param <T> the type of resources in the collection
 */
public class AbstractOPCollection<T extends OPBaseResource> extends OPBaseResource {

    /**
     * Link relation for changing page size.
     */
    public static final String CHANGESIZE_LINK = "changeSize";
    /**
     * Link relation for jumping to a specific page.
     */
    public static final String JUMPTO_LINK = "jumpTo";
    /**
     * Link relation for next page (offset-based pagination).
     */
    public static final String NEXTBYOFFSET_LINK = "nextByOffset";
    /**
     * Link relation for previous page (offset-based pagination).
     */
    public static final String PREVIOUSBYOFFSET_LINK = "previousByOffset";
    /**
     * Link relation for next page (cursor-based pagination).
     */
    public static final String NEXTBYCURSOR_LINK = "nextByCursor";
    /**
     * Link relation for previous page (cursor-based pagination).
     */
    public static final String PREVIOUSBYCURSOR_LINK = "previousByCursor";

    @JsonProperty("total")
    private Integer total;

    @JsonProperty("pageSize")
    private Integer pageSize;

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("offset")
    private Integer offset;

    @JsonProperty("_embedded")
    private Map<String, List<T>> embedded;

    /**
     * Default constructor.
     */
    public AbstractOPCollection() {
    }

    /**
     * Constructs a collection with all properties.
     * @param type the resource type
     * @param links the HAL links
     * @param total the total number of items
     * @param pageSize the page size
     * @param count the number of items in this page
     * @param offset the offset for pagination
     * @param embedded the embedded resources
     */
    public AbstractOPCollection(String type, Map<String, List<OPBaseLink>> links, Integer total, Integer pageSize, Integer count, Integer offset, Map<String, List<T>> embedded) {
        super(type, links);
        this.total = total;
        this.pageSize = pageSize;
        this.count = count;
        this.offset = offset;
        this.embedded = embedded;
    }

    /**
     * Constructs a collection from a list of elements.
     * @param elements the list of elements
     */
    public AbstractOPCollection(List<T> elements) {
        setElements(elements);
    }

    /**
     * Gets the total number of items.
     * @return the total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * Sets the total number of items.
     * @param total the total
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * Gets the page size.
     * @return the page size
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Sets the page size.
     * @param pageSize the page size
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Gets the number of items in this page.
     * @return the count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Sets the number of items in this page.
     * @param count the count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * Gets the offset for pagination.
     * @return the offset
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * Sets the offset for pagination.
     * @param offset the offset
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * Gets the embedded resources map.
     * @return the embedded resources
     */
    public Map<String, List<T>> getEmbedded() {
        return embedded;
    }

    /**
     * Gets the list of elements from the embedded resources.
     * @return the list of elements, or an empty list if none exist
     */
    public List<T> getElements() {
        if (embedded == null) {
            return Collections.emptyList();
        }
        return embedded.getOrDefault("elements", Collections.emptyList());
    }

    /**
     * Sets the list of elements in the embedded resources.
     * @param elements the list of elements
     */
    public void setElements(List<T> elements) {
        if (embedded == null) {
            embedded = new HashMap<>();
        }
        embedded.put("elements", elements);
        this.count = elements.size();
        this.total = elements.size();
        this.pageSize = elements.size();
        this.offset = 0;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof AbstractOPCollection<?> that)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(getTotal(), that.getTotal()) && Objects.equals(getPageSize(), that.getPageSize()) && Objects.equals(getCount(), that.getCount()) && Objects.equals(getOffset(), that.getOffset()) && Objects.equals(getEmbedded(), that.getEmbedded());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(getTotal());
        result = 31 * result + Objects.hashCode(getPageSize());
        result = 31 * result + Objects.hashCode(getCount());
        result = 31 * result + Objects.hashCode(getOffset());
        result = 31 * result + Objects.hashCode(getEmbedded());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AbstractOPCollection{");
        sb.append("total=").append(getTotal());
        sb.append(", pageSize=").append(getPageSize());
        sb.append(", count=").append(getCount());
        sb.append(", offset=").append(getOffset());
        sb.append(", embedded=").append(getEmbedded());
        sb.append(", type='").append(getType()).append('\'');
        sb.append(", links=").append(getLinks());
        sb.append('}');
        return sb.toString();
    }
}
