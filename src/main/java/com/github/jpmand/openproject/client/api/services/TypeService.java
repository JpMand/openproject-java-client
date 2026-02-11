package com.github.jpmand.openproject.client.api.services;

import com.github.jpmand.openproject.client.api.models.OPTypeModel;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Retrofit service interface for OpenProject Type (Work Package Type) API endpoints.
 * <p>
 * <strong>Internal Use Only:</strong> This interface is used internally by {@link com.github.jpmand.openproject.client.api.OpenProjectClient}.
 * External code should not use this interface directly. Instead, use the convenience methods provided by OpenProjectClient.
 * </p>
 * 
 * @see OPTypeModel
 * @see com.github.jpmand.openproject.client.api.OpenProjectClient
 */
public interface TypeService {

    /**
     * Gets a single type by ID.
     * 
     * @param id the type ID
     * @return a Call object that can be executed to retrieve the type
     */
    @GET("/api/v3/types/{id}")
    Call<OPTypeModel> getType(@Path("id") Long id);

    /**
     * Lists all types available in the system.
     * 
     * @return a Call object that can be executed to retrieve the type collection
     */
    @GET("/api/v3/types")
    Call<AbstractOPCollection<OPTypeModel>> listTypes();
}
