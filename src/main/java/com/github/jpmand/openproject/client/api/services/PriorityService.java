package com.github.jpmand.openproject.client.api.services;

import com.github.jpmand.openproject.client.api.models.OPPriorityModel;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Retrofit service interface for OpenProject Priority API endpoints.
 * <p>
 * <strong>Internal Use Only:</strong> This interface is used internally by {@link com.github.jpmand.openproject.client.api.OpenProjectClient}.
 * External code should not use this interface directly. Instead, use the convenience methods provided by OpenProjectClient.
 * </p>
 * <p>
 * Available OpenProject Priority API endpoints (see https://www.openproject.org/docs/api/endpoints/):
 * <ul>
 *   <li>GET /api/v3/priorities - List priorities</li>
 *   <li>GET /api/v3/priorities/{id} - Get priority</li>
 * </ul>
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
     * Note: According to the OpenAPI specification, this endpoint does not support
     * any query parameters (filters, sortBy, select, offset, pageSize).
     * 
     * @return a Call object that can be executed to retrieve the priority collection
     */
    @GET("/api/v3/priorities")
    Call<AbstractOPCollection<OPPriorityModel>> listPriorities();
}
