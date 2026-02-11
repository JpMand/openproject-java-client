package com.github.jpmand.openproject.client.api.services;

import com.github.jpmand.openproject.client.api.models.OPVersionModel;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Retrofit service interface for OpenProject Version API endpoints.
 * <p>
 * <strong>Internal Use Only:</strong> This interface is used internally by {@link com.github.jpmand.openproject.client.api.OpenProjectClient}.
 * External code should not use this interface directly. Instead, use the convenience methods provided by OpenProjectClient.
 * </p>
 * 
 * @see OPVersionModel
 * @see com.github.jpmand.openproject.client.api.OpenProjectClient
 */
public interface VersionService {

    /**
     * Gets a single version by ID.
     * 
     * @param id the version ID
     * @return a Call object that can be executed to retrieve the version
     */
    @GET("/api/v3/versions/{id}")
    Call<OPVersionModel> getVersion(@Path("id") Long id);

    /**
     * Lists all versions visible to the current user.
     * 
     * @param filters JSON string specifying filter conditions
     * @param sortBy JSON string specifying sort criteria
     * @return a Call object that can be executed to retrieve the version collection
     */
    @GET("/api/v3/versions")
    Call<AbstractOPCollection<OPVersionModel>> listVersions(
            @Query("filters") String filters,
            @Query("sortBy") String sortBy
    );

    /**
     * Creates a new version.
     * 
     * @param version the version to create
     * @return a Call object that can be executed to create the version
     */
    @POST("/api/v3/versions")
    Call<OPVersionModel> createVersion(@Body OPVersionModel version);

    /**
     * Updates an existing version.
     * 
     * @param id the version ID
     * @param version the updated version data
     * @return a Call object that can be executed to update the version
     */
    @PATCH("/api/v3/versions/{id}")
    Call<OPVersionModel> updateVersion(
            @Path("id") Long id,
            @Body OPVersionModel version
    );

    /**
     * Deletes a version.
     * 
     * @param id the version ID
     * @return a Call object that can be executed to delete the version
     */
    @DELETE("/api/v3/versions/{id}")
    Call<Void> deleteVersion(@Path("id") Long id);
}
