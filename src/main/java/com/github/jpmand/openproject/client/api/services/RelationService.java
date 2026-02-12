package com.github.jpmand.openproject.client.api.services;

import com.github.jpmand.openproject.client.api.models.OPRelationModel;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Retrofit service interface for OpenProject Relation API endpoints.
 * <p>
 * <strong>Internal Use Only:</strong> This interface is used internally by {@link com.github.jpmand.openproject.client.api.OpenProjectClient}.
 * External code should not use this interface directly. Instead, use the convenience methods provided by OpenProjectClient.
 * </p>
 * 
 * @see OPRelationModel
 * @see com.github.jpmand.openproject.client.api.OpenProjectClient
 */
public interface RelationService {

    /**
     * Gets a single relation by ID.
     * 
     * @param id the relation ID
     * @return a Call object that can be executed to retrieve the relation
     */
    @GET("/api/v3/relations/{id}")
    Call<OPRelationModel> getRelation(@Path("id") Long id);

    /**
     * Lists all relations visible to the current user.
     * 
     * @param filters JSON string specifying filter conditions
     * @param sortBy JSON string specifying sort criteria
     * @return a Call object that can be executed to retrieve the relation collection
     */
    @GET("/api/v3/relations")
    Call<AbstractOPCollection<OPRelationModel>> listRelations(
            @Query("filters") String filters,
            @Query("sortBy") String sortBy
    );

    /**
     * Creates a new relation between work packages.
     * 
     * @param relation the relation to create
     * @return a Call object that can be executed to create the relation
     */
    @POST("/api/v3/relations")
    Call<OPRelationModel> createRelation(@Body OPRelationModel relation);

    /**
     * Updates an existing relation.
     * 
     * @param id the relation ID
     * @param relation the updated relation data
     * @return a Call object that can be executed to update the relation
     */
    @PATCH("/api/v3/relations/{id}")
    Call<OPRelationModel> updateRelation(
            @Path("id") Long id,
            @Body OPRelationModel relation
    );

    /**
     * Deletes a relation.
     * 
     * @param id the relation ID
     * @return a Call object that can be executed to delete the relation
     */
    @DELETE("/api/v3/relations/{id}")
    Call<Void> deleteRelation(@Path("id") Long id);
}
