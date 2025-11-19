package com.github.jpmand.openproject.client.api;

import com.github.jpmand.openproject.client.api.models.OPWorkPackageModel;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import com.github.jpmand.openproject.client.api.models.enums.SortEnum;
import com.github.jpmand.openproject.client.api.models.filters.OPQueryFilterInstance;
import com.github.jpmand.openproject.client.api.models.filters.OPQueryFilter;
import com.github.jpmand.openproject.client.api.services.WorkPackageService;
import com.github.jpmand.openproject.client.auth.AnonymousAuth;
import com.github.jpmand.openproject.client.auth.AuthProvider;
import com.github.jpmand.openproject.client.http.UserAgentInterceptor;
import com.github.jpmand.openproject.client.http.serialization.HalObjectMapper;
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
 * @see OPQueryFilterInstance
 * @see OPQueryFilter
 */
public class OpenProjectClient {

    private final WorkPackageService workPackageService;

    /**
     * Creates an OpenProjectClient with anonymous access.
     *
     * @param baseUrl the base URL of the OpenProject instance
     */
    public OpenProjectClient(String baseUrl) {
        this(baseUrl, new AnonymousAuth());
    }

    /**
     * Creates an OpenProjectClient with the specified authentication provider.
     *
     * @param baseUrl      the base URL of the OpenProject instance
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
    private OpenProjectClient(Retrofit retrofit) {
        this.workPackageService = retrofit.create(WorkPackageService.class);
    }

    private static Retrofit createRetrofit(String baseUrl, AuthProvider authProvider) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.addInterceptor(new UserAgentInterceptor(null));
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
    public OPWorkPackageModel getWorkPackage(long id) throws IOException {
        Call<OPWorkPackageModel> call = workPackageService.getWorkPackage(id);
        return call.execute().body();
    }

    /**
     * Lists work packages with full query parameter support using raw JSON strings.
     *
     * @param offset     the page number (starting from 1)
     * @param pageSize   the number of elements per page
     * @param filters    JSON string specifying filter conditions
     * @param sortBy     JSON string specifying sort criteria
     * @param groupBy    the column to group by
     * @param showSums   whether to show property sums
     * @param select     comma-separated list of properties to include
     * @return the paginated work package collection
     * @throws IOException if the request fails
     */
    private AbstractOPCollection<OPWorkPackageModel> listWorkPackages(
            Integer offset,
            Integer pageSize,
            String filters,
            String sortBy,
            String groupBy,
            Boolean showSums,
            String select) throws IOException {
        Call<AbstractOPCollection<OPWorkPackageModel>> call = workPackageService.listWorkPackages(
                offset, pageSize, filters, sortBy, groupBy, showSums, select);
        return call.execute().body();
    }

    /**
     * Lists work packages with type-safe filter and sort parameters.
     *
     * @param offset     the page number (starting from 1)
     * @param pageSize   the number of elements per page
     * @param filters    list of filter objects to apply
     * @param sorts map of field names to sort directions (use LinkedHashMap to preserve order)
     * @param groupBy    the column to group by
     * @param showSums   whether to show property sums
     * @param select     comma-separated list of properties to include
     * @return the paginated work package collection
     * @throws IOException if the request fails
     */
    public AbstractOPCollection<OPWorkPackageModel> listWorkPackages(
            Integer offset,
            Integer pageSize,
            List<OPQueryFilterInstance> filters,
            Map<String, SortEnum> sorts,
            String groupBy,
            Boolean showSums,
            String select) throws IOException {

        String filtersJson = filters != null && !filters.isEmpty()
                ? QueryBuilder.buildFilterJson(filters)
                : null;

        String sortByJson = sorts != null && !sorts.isEmpty()
                ? QueryBuilder.buildSortJson(sorts)
                : null;

        return listWorkPackages(offset, pageSize, filtersJson, sortByJson, groupBy, showSums, select);
    }
}
