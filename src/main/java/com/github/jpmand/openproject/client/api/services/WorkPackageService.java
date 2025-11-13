package com.github.jpmand.openproject.client.api.services;

import com.github.jpmand.openproject.client.core.model.WorkPackage;
import com.github.jpmand.openproject.client.core.model.base.PagedCollectionResource;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WorkPackageService {

    @GET("/api/v3/work_packages/{id}")
    Call<WorkPackage> getWorkPackage(@Path("id") Long id);

    @GET("/api/v3/work_packages")
    Call<PagedCollectionResource<WorkPackage>> listWorkPackages();

    @GET("/api/v3/work_packages")
    Call<PagedCollectionResource<WorkPackage>> listWorkPackages(
            @Query("pageSize") Integer pageSize,
            @Query("offset") Integer offset
    );
}
