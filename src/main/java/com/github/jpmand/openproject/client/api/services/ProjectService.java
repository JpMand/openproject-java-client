package com.github.jpmand.openproject.client.api.services;

import com.github.jpmand.openproject.client.api.models.OPProjectModel;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Retrofit service interface for OpenProject Project API endpoints.
 * <p>
 * <strong>Internal Use Only:</strong> This interface is used internally by {@link com.github.jpmand.openproject.client.api.OpenProjectClient}.
 * External code should not use this interface directly. Instead, use the convenience methods provided by OpenProjectClient.
 * </p>
 * <p>
 * Available OpenProject Project API endpoints (see https://www.openproject.org/docs/api/endpoints/):
 * <ul>
 *   <li>GET /api/v3/projects - List projects</li>
 *   <li>GET /api/v3/projects/{id} - Get project</li>
 *   <li>POST /api/v3/projects - Create project</li>
 *   <li>PATCH /api/v3/projects/{id} - Update project</li>
 *   <li>DELETE /api/v3/projects/{id} - Delete project</li>
 *   <li>GET /api/v3/projects/available_parent_projects - Available parent projects</li>
 *   <li>GET /api/v3/projects/schema - Project schema</li>
 *   <li>GET /api/v3/projects/form - Project create form</li>
 *   <li>GET /api/v3/projects/{id}/form - Project update form</li>
 *   <li>POST /api/v3/projects/{id}/copy - Copy project</li>
 *   <li>POST /api/v3/projects/{id}/copy/form - Copy project form</li>
 *   <li>PATCH /api/v3/projects/{id}/favorite - Mark project as favorite</li>
 *   <li>GET /api/v3/projects/{id}/available_assignees - Available assignees</li>
 *   <li>GET /api/v3/projects/{id}/budgets - Project budgets</li>
 *   <li>GET /api/v3/projects/{id}/categories - Project categories</li>
 *   <li>GET /api/v3/projects/{id}/types - Project types</li>
 *   <li>GET /api/v3/projects/{id}/versions - Project versions</li>
 *   <li>GET /api/v3/projects/{id}/work_packages - Project work packages</li>
 * </ul>
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
     * Lists all projects with query parameter support.
     * 
     * Note: According to the OpenAPI specification, this endpoint supports:
     * filters, sortBy, and select. It does NOT support offset or pageSize parameters.
     * 
     * @param filters JSON string specifying filter conditions
     * @param sortBy JSON string specifying sort criteria (supported orders: id, name, type_id, public, created_at, latest_activity_at, required_disk_space, parent_id, identifier)
     * @param select comma-separated list of properties to include
     * @return a Call object that can be executed to retrieve the project collection
     */
    @GET("/api/v3/projects")
    Call<AbstractOPCollection<OPProjectModel>> listProjects(
            @Query("filters") String filters,
            @Query("sortBy") String sortBy,
            @Query("select") String select
    );
}
