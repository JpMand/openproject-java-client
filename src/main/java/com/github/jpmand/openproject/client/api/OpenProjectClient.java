package com.github.jpmand.openproject.client.api;

import com.github.jpmand.openproject.client.api.services.WorkPackageService;
import com.github.jpmand.openproject.client.auth.ApiKeyAuth;
import com.github.jpmand.openproject.client.auth.AuthProvider;
import com.github.jpmand.openproject.client.core.model.WorkPackage;
import com.github.jpmand.openproject.client.core.model.base.PagedCollectionResource;
import com.github.jpmand.openproject.client.core.serialization.HalObjectMapper;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

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

    public WorkPackage getWorkPackage(long id) throws IOException {
        Call<WorkPackage> call = workPackageService.getWorkPackage(id);
        return call.execute().body();
    }

    public PagedCollectionResource<WorkPackage> listWorkPackages() throws IOException {
        Call<PagedCollectionResource<WorkPackage>> call = workPackageService.listWorkPackages();
        return call.execute().body();
    }

    public PagedCollectionResource<WorkPackage> listWorkPackages(Integer pageSize, Integer offset) throws IOException {
        Call<PagedCollectionResource<WorkPackage>> call = workPackageService.listWorkPackages(pageSize, offset);
        return call.execute().body();
    }

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
}

