package com.github.jpmand.openproject.client.api;

import com.github.jpmand.openproject.client.api.services.WorkPackageService;
import com.github.jpmand.openproject.client.auth.ApiKeyAuth;
import com.github.jpmand.openproject.client.auth.AuthProvider;
import com.github.jpmand.openproject.client.core.model.SortEnum;
import com.github.jpmand.openproject.client.core.model.WorkPackage;
import com.github.jpmand.openproject.client.core.model.base.PagedCollectionResource;
import com.github.jpmand.openproject.client.core.model.filters.FilterObject;
import com.github.jpmand.openproject.client.core.serialization.HalObjectMapper;
import com.github.jpmand.openproject.client.util.QueryBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Main client for interacting with the OpenProject API.
 * <p>
 * Provides high-level methods for working with work packages and other OpenProject resources.
 * Supports multiple authentication methods and flexible configuration via Retrofit.
 * </p>
 * 
 * @see WorkPackageService
 * @see FilterObject
 * @see com.github.jpmand.openproject.client.core.model.filters.FilterValue
 */
public class OpenProjectClient {

    private final WorkPackageService workPackageService;

    /**
     * Creates an OpenProjectClient with API key authentication.
     *
     * @param baseUrl the base URL of the OpenProject instance
     * @param apiToken the API token for authentication
     * @deprecated Use {@link #OpenProjectClient(String, AuthProvider)} or {@link #OpenProjectClient(Retrofit)} instead
     */
    @Deprecated
    public OpenProjectClient(final String baseUrl, final String apiToken) {
        this(baseUrl, new ApiKeyAuth(apiToken));
    }

    /**
     * Creates an OpenProjectClient with the specified authentication provider.
     *
     * @param baseUrl the base URL of the OpenProject instance
     * @param authProvider the authentication provider to use
     */
    public OpenProjectClient(String baseUrl, AuthProvider authProvider) {
        this(createRetrofit(baseUrl, authProvider));
    }

    /**
     * Creates an OpenProjectClient with a pre-configured Retrofit instance.
     *
     * @param retrofit the configured Retrofit instance
     */
    public OpenProjectClient(Retrofit retrofit) {
        this.workPackageService = retrofit.create(WorkPackageService.class);
    }

    private static Retrofit createRetrofit(String baseUrl, AuthProvider authProvider) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        
        if (authProvider != null) {
            builder.addInterceptor(authProvider.getInterceptor());
        }
        
        return new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create(HalObjectMapper.get()))
                .build();
    }

    /**
     * Gets a single work package by ID.
     * 
     * @param id the work package ID
     * @return the work package
     * @throws IOException if the request fails
     */
    public WorkPackage getWorkPackage(long id) throws IOException {
        Call<WorkPackage> call = workPackageService.getWorkPackage(id);
        return call.execute().body();
    }

    /**
     * Lists all work packages with default parameters.
     * 
     * @return the paginated work package collection
     * @throws IOException if the request fails
     */
    public PagedCollectionResource<WorkPackage> listWorkPackages() throws IOException {
        Call<PagedCollectionResource<WorkPackage>> call = workPackageService.listWorkPackages();
        return call.execute().body();
    }

    /**
     * Lists work packages with pagination.
     * 
     * @param pageSize the number of elements per page
     * @param offset the page number (starting from 1)
     * @return the paginated work package collection
     * @throws IOException if the request fails
     */
    public PagedCollectionResource<WorkPackage> listWorkPackages(Integer pageSize, Integer offset) throws IOException {
        Call<PagedCollectionResource<WorkPackage>> call = workPackageService.listWorkPackages(pageSize, offset);
        return call.execute().body();
    }

    /**
     * Lists work packages with full query parameter support using raw JSON strings.
     * 
     * @param offset the page number (starting from 1)
     * @param pageSize the number of elements per page
     * @param filters JSON string specifying filter conditions
     * @param sortBy JSON string specifying sort criteria
     * @param groupBy the column to group by
     * @param showSums whether to show property sums
     * @param select comma-separated list of properties to include
     * @param timestamps comma-separated timestamps for baseline comparisons
     * @return the paginated work package collection
     * @throws IOException if the request fails
     */
    public PagedCollectionResource<WorkPackage> listWorkPackages(
            Integer offset,
            Integer pageSize,
            String filters,
            String sortBy,
            String groupBy,
            Boolean showSums,
            String select,
            String timestamps) throws IOException {
        Call<PagedCollectionResource<WorkPackage>> call = workPackageService.listWorkPackages(
                offset, pageSize, filters, sortBy, groupBy, showSums, select, timestamps);
        return call.execute().body();
    }

    /**
     * Lists work packages with type-safe filter and sort parameters.
     * 
     * @param offset the page number (starting from 1)
     * @param pageSize the number of elements per page
     * @param filters list of filter objects to apply
     * @param sortFields map of field names to sort directions (use LinkedHashMap to preserve order)
     * @return the paginated work package collection
     * @throws IOException if the request fails
     */
    public PagedCollectionResource<WorkPackage> listWorkPackages(
            Integer offset,
            Integer pageSize,
            List<FilterObject> filters,
            Map<String, SortEnum> sortFields) throws IOException {
        
        String filtersJson = filters != null && !filters.isEmpty() 
                ? QueryBuilder.buildFilterJson(filters) 
                : null;
        
        String sortByJson = sortFields != null && !sortFields.isEmpty() 
                ? QueryBuilder.buildSortJson(sortFields) 
                : null;
        
        return listWorkPackages(offset, pageSize, filtersJson, sortByJson, null, null, null, null);
    }

    /**
     * Lists work packages with a single filter and sort field.
     * 
     * @param offset the page number (starting from 1)
     * @param pageSize the number of elements per page
     * @param filter the filter object to apply
     * @param sortField the field name to sort by
     * @param sortDirection the sort direction
     * @return the paginated work package collection
     * @throws IOException if the request fails
     */
    public PagedCollectionResource<WorkPackage> listWorkPackages(
            Integer offset,
            Integer pageSize,
            FilterObject filter,
            String sortField,
            SortEnum sortDirection) throws IOException {
        
        List<FilterObject> filters = filter != null ? List.of(filter) : null;
        Map<String, SortEnum> sortFields = sortField != null && sortDirection != null 
                ? Map.of(sortField, sortDirection) 
                : null;
        
        return listWorkPackages(offset, pageSize, filters, sortFields);
    }
}

