package com.github.jpmand.openproject.client.api;

import com.github.jpmand.openproject.client.api.models.OPPriorityModel;
import com.github.jpmand.openproject.client.api.models.OPProjectModel;
import com.github.jpmand.openproject.client.api.models.OPStatusModel;
import com.github.jpmand.openproject.client.api.models.OPWorkPackageModel;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import com.github.jpmand.openproject.client.api.models.enums.SortEnum;
import com.github.jpmand.openproject.client.api.models.filters.OPQueryFilterInstance;
import com.github.jpmand.openproject.client.api.models.filters.OPQueryFilter;
import com.github.jpmand.openproject.client.api.services.PriorityService;
import com.github.jpmand.openproject.client.api.services.ProjectService;
import com.github.jpmand.openproject.client.api.services.StatusService;
import com.github.jpmand.openproject.client.api.services.WorkPackageService;
import com.github.jpmand.openproject.client.api.services.UserService;
import com.github.jpmand.openproject.client.api.services.TypeService;
import com.github.jpmand.openproject.client.api.services.VersionService;
import com.github.jpmand.openproject.client.api.services.ActivityService;
import com.github.jpmand.openproject.client.api.services.RelationService;
import com.github.jpmand.openproject.client.api.services.TimeEntryService;
import com.github.jpmand.openproject.client.auth.AnonymousAuth;
import com.github.jpmand.openproject.client.auth.AuthProvider;
import com.github.jpmand.openproject.client.http.UserAgentInterceptor;
import com.github.jpmand.openproject.client.http.serialization.HalObjectMapper;
import com.github.jpmand.openproject.client.util.QueryBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Main client for interacting with the OpenProject API.
 * <p>
 * Provides high-level methods for working with work packages and other OpenProject resources.
 * Supports multiple authentication methods and flexible configuration via Retrofit.
 * </p>
 *
 * @see WorkPackageService
 * @see OPQueryFilterInstance
 * @see OPQueryFilter
 */
public class OpenProjectClient {

    private final WorkPackageService workPackageService;
    private final ProjectService projectService;
    private final StatusService statusService;
    private final PriorityService priorityService;
    private final UserService userService;
    private final TypeService typeService;
    private final VersionService versionService;
    private final ActivityService activityService;
    private final RelationService relationService;
    private final TimeEntryService timeEntryService;

    /**
     * Creates an OpenProjectClient with anonymous access.
     *
     * @param baseUrl the base URL of the OpenProject instance
     */
    public OpenProjectClient(String baseUrl) {
        this(baseUrl, new AnonymousAuth());
    }

    /**
     * Creates an OpenProjectClient with the specified authentication provider.
     *
     * @param baseUrl      the base URL of the OpenProject instance
     * @param authProvider the authentication provider to use
     */
    public OpenProjectClient(String baseUrl, AuthProvider authProvider) {
        this(createRetrofit(baseUrl, authProvider));
    }

    /**
     * Creates an OpenProjectClient with a pre-configured Retrofit instance.
     *
     * @param retrofit the configured Retrofit instance
     */
    public OpenProjectClient(Retrofit retrofit) {
        this.workPackageService = retrofit.create(WorkPackageService.class);
        this.projectService = retrofit.create(ProjectService.class);
        this.statusService = retrofit.create(StatusService.class);
        this.priorityService = retrofit.create(PriorityService.class);
        this.userService = retrofit.create(UserService.class);
        this.typeService = retrofit.create(TypeService.class);
        this.versionService = retrofit.create(VersionService.class);
        this.activityService = retrofit.create(ActivityService.class);
        this.relationService = retrofit.create(RelationService.class);
        this.timeEntryService = retrofit.create(TimeEntryService.class);
    }

    private static Retrofit createRetrofit(String baseUrl, AuthProvider authProvider) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.addInterceptor(new UserAgentInterceptor(null));
        if (authProvider != null) {
            builder.addInterceptor(authProvider.getInterceptor());
        }

        return new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create(HalObjectMapper.get()))
                .build();
    }

    /**
     * Gets a single work package by ID.
     *
     * @param id the work package ID
     * @return the work package
     * @throws IOException if the request fails
     */
    public OPWorkPackageModel getWorkPackage(long id) throws IOException {
        Call<OPWorkPackageModel> call = workPackageService.getWorkPackage(id);
        return call.execute().body();
    }

    /**
     * Lists work packages with full query parameter support using raw JSON strings.
     *
     * @param offset     the page number (starting from 1)
     * @param pageSize   the number of elements per page
     * @param filters    JSON string specifying filter conditions
     * @param sortBy     JSON string specifying sort criteria
     * @param groupBy    the column to group by
     * @param showSums   whether to show property sums
     * @param select     comma-separated list of properties to include
     * @return the paginated work package collection
     * @throws IOException if the request fails
     */
    private AbstractOPCollection<OPWorkPackageModel> listWorkPackages(
            Integer offset,
            Integer pageSize,
            String filters,
            String sortBy,
            String groupBy,
            Boolean showSums,
            String select) throws IOException {
        Call<AbstractOPCollection<OPWorkPackageModel>> call = workPackageService.listWorkPackages(
                offset, pageSize, filters, sortBy, groupBy, showSums, select);
        return call.execute().body();
    }

    /**
     * Lists work packages with type-safe filter and sort parameters.
     *
     * @param offset     the page number (starting from 1)
     * @param pageSize   the number of elements per page
     * @param filters    list of filter objects to apply
     * @param sorts map of field names to sort directions (use LinkedHashMap to preserve order)
     * @param groupBy    the column to group by
     * @param showSums   whether to show property sums
     * @param select     comma-separated list of properties to include
     * @return the paginated work package collection
     * @throws IOException if the request fails
     */
    public AbstractOPCollection<OPWorkPackageModel> listWorkPackages(
            Integer offset,
            Integer pageSize,
            List<OPQueryFilterInstance> filters,
            Map<String, SortEnum> sorts,
            String groupBy,
            Boolean showSums,
            String select) throws IOException {

        String filtersJson = filters != null && !filters.isEmpty()
                ? QueryBuilder.buildFilterJson(filters)
                : null;

        String sortByJson = sorts != null && !sorts.isEmpty()
                ? QueryBuilder.buildSortJson(sorts)
                : null;

        return listWorkPackages(offset, pageSize, filtersJson, sortByJson, groupBy, showSums, select);
    }

    /**
     * Gets a single project by ID.
     *
     * @param id the project ID
     * @return the project
     * @throws IOException if the request fails
     */
    public OPProjectModel getProject(long id) throws IOException {
        Call<OPProjectModel> call = projectService.getProject(id);
        return call.execute().body();
    }

    /**
     * Lists projects with query parameter support using raw JSON strings.
     * 
     * Note: Projects endpoint does NOT support offset/pageSize according to OpenAPI spec.
     *
     * @param filters    JSON string specifying filter conditions
     * @param sortBy     JSON string specifying sort criteria
     * @param select     comma-separated list of properties to include
     * @return the project collection
     * @throws IOException if the request fails
     */
    private AbstractOPCollection<OPProjectModel> listProjects(
            String filters,
            String sortBy,
            String select) throws IOException {
        Call<AbstractOPCollection<OPProjectModel>> call = projectService.listProjects(
                filters, sortBy, select);
        return call.execute().body();
    }

    /**
     * Lists projects with type-safe filter and sort parameters.
     * 
     * Note: Projects endpoint does NOT support offset/pageSize according to OpenAPI spec.
     *
     * @param filters    list of filter objects to apply
     * @param sorts      map of field names to sort directions (use LinkedHashMap to preserve order)
     * @param select     comma-separated list of properties to include
     * @return the project collection
     * @throws IOException if the request fails
     */
    public AbstractOPCollection<OPProjectModel> listProjects(
            List<OPQueryFilterInstance> filters,
            Map<String, SortEnum> sorts,
            String select) throws IOException {

        String filtersJson = filters != null && !filters.isEmpty()
                ? QueryBuilder.buildFilterJson(filters)
                : null;

        String sortByJson = sorts != null && !sorts.isEmpty()
                ? QueryBuilder.buildSortJson(sorts)
                : null;

        return listProjects(filtersJson, sortByJson, select);
    }

    /**
     * Gets a single status by ID.
     *
     * @param id the status ID
     * @return the status
     * @throws IOException if the request fails
     */
    public OPStatusModel getStatus(long id) throws IOException {
        Call<OPStatusModel> call = statusService.getStatus(id);
        return call.execute().body();
    }

    /**
     * Lists all statuses.
     * 
     * Note: Statuses endpoint does NOT support any query parameters according to OpenAPI spec.
     *
     * @return the status collection
     * @throws IOException if the request fails
     */
    public AbstractOPCollection<OPStatusModel> listStatuses() throws IOException {
        Call<AbstractOPCollection<OPStatusModel>> call = statusService.listStatuses();
        return call.execute().body();
    }

    /**
     * Gets a single priority by ID.
     *
     * @param id the priority ID
     * @return the priority
     * @throws IOException if the request fails
     */
    public OPPriorityModel getPriority(long id) throws IOException {
        Call<OPPriorityModel> call = priorityService.getPriority(id);
        return call.execute().body();
    }

    /**
     * Lists all priorities.
     * 
     * Note: Priorities endpoint does NOT support any query parameters according to OpenAPI spec.
     *
     * @return the priority collection
     * @throws IOException if the request fails
     */
    public AbstractOPCollection<OPPriorityModel> listPriorities() throws IOException {
        Call<AbstractOPCollection<OPPriorityModel>> call = priorityService.listPriorities();
        return call.execute().body();
    }

    /**
     * Gets the UserService for making user-related API calls.
     * 
     * @return the user service
     */
    public UserService users() {
        return userService;
    }

    /**
     * Gets the TypeService for making type-related API calls.
     * 
     * @return the type service
     */
    public TypeService types() {
        return typeService;
    }

    /**
     * Gets the VersionService for making version-related API calls.
     * 
     * @return the version service
     */
    public VersionService versions() {
        return versionService;
    }

    /**
     * Gets the ActivityService for making activity-related API calls.
     * 
     * @return the activity service
     */
    public ActivityService activities() {
        return activityService;
    }

    /**
     * Gets the RelationService for making relation-related API calls.
     * 
     * @return the relation service
     */
    public RelationService relations() {
        return relationService;
    }

    /**
     * Gets the TimeEntryService for making time entry-related API calls.
     * 
     * @return the time entry service
     */
    public TimeEntryService timeEntries() {
        return timeEntryService;
    }
}
