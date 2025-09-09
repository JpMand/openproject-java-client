package com.github.jpmand.openproject.client.api.services;

import com.github.jpmand.openproject.client.core.model.WorkPackage;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WorkPackageService {

    @GET("/api/v3/work_packages/{id}")
    Call<WorkPackage> getWorkPackage(@Path("id") Long id);
}
