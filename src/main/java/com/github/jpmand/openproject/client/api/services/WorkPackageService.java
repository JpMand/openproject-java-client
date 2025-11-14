package com.github.jpmand.openproject.client.api.services;

import com.github.jpmand.openproject.client.api.models.OPWorkPackageModel;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Retrofit service interface for OpenProject Work Package API endpoints.
 * <p>
 * <strong>Internal Use Only:</strong> This interface is used internally by {@link com.github.jpmand.openproject.client.api.OpenProjectClient}.
 * External code should not use this interface directly. Instead, use the convenience methods provided by OpenProjectClient.
 * </p>
 * 
 * @see OPWorkPackageModel
 * @see com.github.jpmand.openproject.client.api.models.filters.OPFilterObject
 * @see com.github.jpmand.openproject.client.api.OpenProjectClient
 */
public interface WorkPackageService {

    /**
     * Gets a single work package by ID.
     * 
     * @param id the work package ID
     * @return a Call object that can be executed to retrieve the work package
     */
    @GET("/api/v3/work_packages/{id}")
    Call<OPWorkPackageModel> getWorkPackage(@Path("id") Long id);

    /**
     * Lists all work packages with default parameters.
     * 
     * @return a Call object that can be executed to retrieve the work package collection
     */
    @GET("/api/v3/work_packages")
    Call<AbstractOPCollection<OPWorkPackageModel>> listWorkPackages();

    /**
     * Lists work packages with pagination.
     * 
     * @param pageSize the number of elements per page
     * @param offset the page number (starting from 1)
     * @return a Call object that can be executed to retrieve the work package collection
     */
    @GET("/api/v3/work_packages")
    Call<AbstractOPCollection<OPWorkPackageModel>> listWorkPackages(
            @Query("pageSize") Integer pageSize,
            @Query("offset") Integer offset
    );

    /**
     * Lists work packages with full query parameter support.
     * 
     * @param offset the page number (starting from 1)
     * @param pageSize the number of elements per page
     * @param filters JSON string specifying filter conditions
     * @param sortBy JSON string specifying sort criteria
     * @param groupBy the column to group by
     * @param showSums whether to show property sums
     * @param select comma-separated list of properties to include
     * @param timestamps comma-separated timestamps for baseline comparisons
     * @return a Call object that can be executed to retrieve the work package collection
     */
    @GET("/api/v3/work_packages")
    Call<AbstractOPCollection<OPWorkPackageModel>> listWorkPackages(
            @Query("offset") Integer offset,
            @Query("pageSize") Integer pageSize,
            @Query("filters") String filters,
            @Query("sortBy") String sortBy,
            @Query("groupBy") String groupBy,
            @Query("showSums") Boolean showSums,
            @Query("select") String select,
            @Query("timestamps") String timestamps
    );
}
