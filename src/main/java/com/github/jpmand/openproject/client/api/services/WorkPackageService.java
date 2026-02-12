package com.github.jpmand.openproject.client.api.services;

import com.github.jpmand.openproject.client.api.models.OPWorkPackageModel;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import com.github.jpmand.openproject.client.api.models.filters.OPQueryFilterInstance;
import com.github.jpmand.openproject.client.api.models.forms.OPForm;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Retrofit service interface for OpenProject Work Package API endpoints.
 * <p>
 * <strong>Internal Use Only:</strong> This interface is used internally by {@link com.github.jpmand.openproject.client.api.OpenProjectClient}.
 * External code should not use this interface directly. Instead, use the convenience methods provided by OpenProjectClient.
 * </p>
 * 
 * @see OPWorkPackageModel
 * @see OPQueryFilterInstance
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
     * Lists work packages with full query parameter support.
     * 
     * @param offset the page number (starting from 1)
     * @param pageSize the number of elements per page
     * @param filters JSON string specifying filter conditions
     * @param sortBy JSON string specifying sort criteria
     * @param groupBy the column to group by
     * @param showSums whether to show property sums
     * @param select comma-separated list of properties to include
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
            @Query("select") String select
    );

    /**
     * Creates a new work package in the system.
     * 
     * @param workPackage the work package to create
     * @return a Call object that can be executed to create the work package
     */
    @POST("/api/v3/work_packages")
    Call<OPWorkPackageModel> createWorkPackage(@Body OPWorkPackageModel workPackage);

    /**
     * Creates a new work package in a specific project.
     * 
     * @param projectId the project ID
     * @param workPackage the work package to create
     * @return a Call object that can be executed to create the work package
     */
    @POST("/api/v3/projects/{projectId}/work_packages")
    Call<OPWorkPackageModel> createWorkPackageInProject(
            @Path("projectId") Long projectId,
            @Body OPWorkPackageModel workPackage
    );

    /**
     * Updates an existing work package.
     * 
     * @param id the work package ID
     * @param workPackage the updated work package data (must include lockVersion)
     * @return a Call object that can be executed to update the work package
     */
    @PATCH("/api/v3/work_packages/{id}")
    Call<OPWorkPackageModel> updateWorkPackage(
            @Path("id") Long id,
            @Body OPWorkPackageModel workPackage
    );

    /**
     * Deletes a work package.
     * 
     * @param id the work package ID
     * @return a Call object that can be executed to delete the work package
     */
    @DELETE("/api/v3/work_packages/{id}")
    Call<Void> deleteWorkPackage(@Path("id") Long id);

    /**
     * Gets the form for validating work package changes.
     * 
     * @param id the work package ID
     * @param workPackage the work package data to validate
     * @return a Call object that can be executed to retrieve the validation form
     */
    @POST("/api/v3/work_packages/{id}/form")
    Call<OPForm<OPWorkPackageModel>> getWorkPackageForm(
            @Path("id") Long id,
            @Body OPWorkPackageModel workPackage
    );

    /**
     * Gets the form for validating a new work package.
     * 
     * @param workPackage the work package data to validate
     * @return a Call object that can be executed to retrieve the validation form
     */
    @POST("/api/v3/work_packages/form")
    Call<OPForm<OPWorkPackageModel>> getWorkPackageCreationForm(
            @Body OPWorkPackageModel workPackage
    );

    /**
     * Gets the form for validating a new work package in a specific project.
     * 
     * @param projectId the project ID
     * @param workPackage the work package data to validate
     * @return a Call object that can be executed to retrieve the validation form
     */
    @POST("/api/v3/projects/{projectId}/work_packages/form")
    Call<OPForm<OPWorkPackageModel>> getWorkPackageCreationFormForProject(
            @Path("projectId") Long projectId,
            @Body OPWorkPackageModel workPackage
    );
}

