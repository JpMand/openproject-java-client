package com.github.jpmand.openproject.client.api.services;

import com.github.jpmand.openproject.client.api.models.OPWorkPackageModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WorkPackageService {

    @GET("/api/v3/work_packages/{id}")
    Call<OPWorkPackageModel> getWorkPackage(@Path("id") Long id);
}
