package com.github.jpmand.openproject.client.api.services;

import com.github.jpmand.openproject.client.api.models.OPTimeEntryModel;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Retrofit service interface for OpenProject Time Entry API endpoints.
 * <p>
 * <strong>Internal Use Only:</strong> This interface is used internally by {@link com.github.jpmand.openproject.client.api.OpenProjectClient}.
 * External code should not use this interface directly. Instead, use the convenience methods provided by OpenProjectClient.
 * </p>
 * 
 * @see OPTimeEntryModel
 * @see com.github.jpmand.openproject.client.api.OpenProjectClient
 */
public interface TimeEntryService {

    /**
     * Gets a single time entry by ID.
     * 
     * @param id the time entry ID
     * @return a Call object that can be executed to retrieve the time entry
     */
    @GET("/api/v3/time_entries/{id}")
    Call<OPTimeEntryModel> getTimeEntry(@Path("id") Long id);

    /**
     * Lists all time entries visible to the current user.
     * 
     * @param offset the page number (starting from 1)
     * @param pageSize the number of elements per page
     * @param filters JSON string specifying filter conditions
     * @param sortBy JSON string specifying sort criteria
     * @return a Call object that can be executed to retrieve the time entry collection
     */
    @GET("/api/v3/time_entries")
    Call<AbstractOPCollection<OPTimeEntryModel>> listTimeEntries(
            @Query("offset") Integer offset,
            @Query("pageSize") Integer pageSize,
            @Query("filters") String filters,
            @Query("sortBy") String sortBy
    );

    /**
     * Creates a new time entry.
     * 
     * @param timeEntry the time entry to create
     * @return a Call object that can be executed to create the time entry
     */
    @POST("/api/v3/time_entries")
    Call<OPTimeEntryModel> createTimeEntry(@Body OPTimeEntryModel timeEntry);

    /**
     * Updates an existing time entry.
     * 
     * @param id the time entry ID
     * @param timeEntry the updated time entry data
     * @return a Call object that can be executed to update the time entry
     */
    @PATCH("/api/v3/time_entries/{id}")
    Call<OPTimeEntryModel> updateTimeEntry(
            @Path("id") Long id,
            @Body OPTimeEntryModel timeEntry
    );

    /**
     * Deletes a time entry.
     * 
     * @param id the time entry ID
     * @return a Call object that can be executed to delete the time entry
     */
    @DELETE("/api/v3/time_entries/{id}")
    Call<Void> deleteTimeEntry(@Path("id") Long id);
}
