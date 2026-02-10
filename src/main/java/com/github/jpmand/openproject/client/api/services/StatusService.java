package com.github.jpmand.openproject.client.api.services;

import com.github.jpmand.openproject.client.api.models.OPStatusModel;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Retrofit service interface for OpenProject Status API endpoints.
 * <p>
 * <strong>Internal Use Only:</strong> This interface is used internally by {@link com.github.jpmand.openproject.client.api.OpenProjectClient}.
 * External code should not use this interface directly. Instead, use the convenience methods provided by OpenProjectClient.
 * </p>
 * 
 * @see OPStatusModel
 * @see com.github.jpmand.openproject.client.api.OpenProjectClient
 */
public interface StatusService {

    /**
     * Gets a single status by ID.
     * 
     * @param id the status ID
     * @return a Call object that can be executed to retrieve the status
     */
    @GET("/api/v3/statuses/{id}")
    Call<OPStatusModel> getStatus(@Path("id") Long id);

    /**
     * Lists all statuses.
     * 
     * @return a Call object that can be executed to retrieve the status collection
     */
    @GET("/api/v3/statuses")
    Call<AbstractOPCollection<OPStatusModel>> listStatuses();
}
