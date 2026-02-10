package com.github.jpmand.openproject.client.api.services;

import com.github.jpmand.openproject.client.api.models.OPProjectModel;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Retrofit service interface for OpenProject Project API endpoints.
 * <p>
 * <strong>Internal Use Only:</strong> This interface is used internally by {@link com.github.jpmand.openproject.client.api.OpenProjectClient}.
 * External code should not use this interface directly. Instead, use the convenience methods provided by OpenProjectClient.
 * </p>
 * 
 * @see OPProjectModel
 * @see com.github.jpmand.openproject.client.api.OpenProjectClient
 */
public interface ProjectService {

    /**
     * Gets a single project by ID.
     * 
     * @param id the project ID
     * @return a Call object that can be executed to retrieve the project
     */
    @GET("/api/v3/projects/{id}")
    Call<OPProjectModel> getProject(@Path("id") Long id);

    /**
     * Lists all projects.
     * 
     * @return a Call object that can be executed to retrieve the project collection
     */
    @GET("/api/v3/projects")
    Call<AbstractOPCollection<OPProjectModel>> listProjects();
}
