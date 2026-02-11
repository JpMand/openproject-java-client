package com.github.jpmand.openproject.client.api.services;

import com.github.jpmand.openproject.client.api.models.OPUserModel;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Retrofit service interface for OpenProject User API endpoints.
 * <p>
 * <strong>Internal Use Only:</strong> This interface is used internally by {@link com.github.jpmand.openproject.client.api.OpenProjectClient}.
 * External code should not use this interface directly. Instead, use the convenience methods provided by OpenProjectClient.
 * </p>
 * 
 * @see OPUserModel
 * @see com.github.jpmand.openproject.client.api.OpenProjectClient
 */
public interface UserService {

    /**
     * Gets a single user by ID.
     * 
     * @param id the user ID
     * @return a Call object that can be executed to retrieve the user
     */
    @GET("/api/v3/users/{id}")
    Call<OPUserModel> getUser(@Path("id") Long id);

    /**
     * Lists all users visible to the current user.
     * 
     * @param offset the page number (starting from 1)
     * @param pageSize the number of elements per page
     * @param filters JSON string specifying filter conditions
     * @param sortBy JSON string specifying sort criteria
     * @return a Call object that can be executed to retrieve the user collection
     */
    @GET("/api/v3/users")
    Call<AbstractOPCollection<OPUserModel>> listUsers(
            @Query("offset") Integer offset,
            @Query("pageSize") Integer pageSize,
            @Query("filters") String filters,
            @Query("sortBy") String sortBy
    );
}
