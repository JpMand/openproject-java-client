package com.github.jpmand.openproject.client.api.services;

import com.github.jpmand.openproject.client.api.models.OPPriorityModel;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Retrofit service interface for OpenProject Priority API endpoints.
 * <p>
 * <strong>Internal Use Only:</strong> This interface is used internally by {@link com.github.jpmand.openproject.client.api.OpenProjectClient}.
 * External code should not use this interface directly. Instead, use the convenience methods provided by OpenProjectClient.
 * </p>
 * 
 * @see OPPriorityModel
 * @see com.github.jpmand.openproject.client.api.OpenProjectClient
 */
public interface PriorityService {

    /**
     * Gets a single priority by ID.
     * 
     * @param id the priority ID
     * @return a Call object that can be executed to retrieve the priority
     */
    @GET("/api/v3/priorities/{id}")
    Call<OPPriorityModel> getPriority(@Path("id") Long id);

    /**
     * Lists all priorities.
     * 
     * @return a Call object that can be executed to retrieve the priority collection
     */
    @GET("/api/v3/priorities")
    Call<AbstractOPCollection<OPPriorityModel>> listPriorities();
}
