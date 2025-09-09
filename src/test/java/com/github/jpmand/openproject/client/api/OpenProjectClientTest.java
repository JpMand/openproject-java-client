package com.github.jpmand.openproject.client.api;

import com.github.jpmand.openproject.client.api.services.WorkPackageService;
import com.github.jpmand.openproject.client.core.transport.ApiTokenAuthenticator;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import retrofit2.Retrofit;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

public class OpenProjectClientTest {

    private MockRetrofit retrofit = new MockRetrofit.Builder(new Retrofit.Builder()
            .client(new OkHttpClient.Builder()
                    .addInterceptor(new ApiTokenAuthenticator("mock"))
                    .build())
            .baseUrl("http://localhost:8080")
            .build()).build();
    @Test
    public void testGetWorkPackage() throws Exception {
        OpenProjectClient openProjectClient = new OpenProjectClient(retrofit.retrofit());


    }
}
