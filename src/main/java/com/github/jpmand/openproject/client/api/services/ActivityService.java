package com.github.jpmand.openproject.client.api.services;

import com.github.jpmand.openproject.client.api.models.OPActivityModel;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Retrofit service interface for OpenProject Activity API endpoints.
 * <p>
 * <strong>Internal Use Only:</strong> This interface is used internally by {@link com.github.jpmand.openproject.client.api.OpenProjectClient}.
 * External code should not use this interface directly. Instead, use the convenience methods provided by OpenProjectClient.
 * </p>
 * 
 * @see OPActivityModel
 * @see com.github.jpmand.openproject.client.api.OpenProjectClient
 */
public interface ActivityService {

    /**
     * Gets a single activity by ID.
     * 
     * @param id the activity ID
     * @return a Call object that can be executed to retrieve the activity
     */
    @GET("/api/v3/activities/{id}")
    Call<OPActivityModel> getActivity(@Path("id") Long id);

    /**
     * Updates an activity (typically used for editing comments).
     * 
     * @param id the activity ID
     * @param activity the updated activity data
     * @return a Call object that can be executed to update the activity
     */
    @PATCH("/api/v3/activities/{id}")
    Call<OPActivityModel> updateActivity(
            @Path("id") Long id,
            @Body OPActivityModel activity
    );
}
