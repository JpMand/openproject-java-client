package com.github.jpmand.openproject.client.api;

import com.github.jpmand.openproject.client.api.services.WorkPackageService;
import com.github.jpmand.openproject.client.core.model.WorkPackage;
import com.github.jpmand.openproject.client.core.transport.ApiTokenAuthenticator;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

public class OpenProjectClient {

    private final WorkPackageService workPackageService;

    public OpenProjectClient(final String baseUrl, final String apiToken) {
        this(new Retrofit.Builder()
                .client(new OkHttpClient.Builder()
                        .addInterceptor(new ApiTokenAuthenticator(apiToken))
                        .build())
                .baseUrl(baseUrl)
                .build());
    }

    public OpenProjectClient(Retrofit retrofit) {
        this.workPackageService = retrofit.create(WorkPackageService.class);
    }

    public WorkPackage getWorkPackage(long id) throws IOException {
        Call<WorkPackage> call = workPackageService.getWorkPackage(id);
        return call.execute().body();
    }
}
