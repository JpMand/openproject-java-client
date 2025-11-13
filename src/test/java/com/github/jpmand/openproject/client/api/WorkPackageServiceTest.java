package com.github.jpmand.openproject.client.api;

import com.github.jpmand.openproject.client.api.services.WorkPackageService;
import com.github.jpmand.openproject.client.core.model.SortEnum;
import com.github.jpmand.openproject.client.core.model.WorkPackage;
import com.github.jpmand.openproject.client.core.model.base.PagedCollectionResource;
import com.github.jpmand.openproject.client.core.model.filters.FilterObject;
import com.github.jpmand.openproject.client.core.serialization.HalObjectMapper;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for WorkPackageService.
 * These tests verify the service interface and basic client functionality.
 */
class WorkPackageServiceTest {

    @Test
    void testServiceInterfaceIsProperlyDefined() {
        // Verify that WorkPackageService can be created via Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://example.com/")
                .addConverterFactory(JacksonConverterFactory.create(HalObjectMapper.get()))
                .build();
        
        WorkPackageService service = retrofit.create(WorkPackageService.class);
        assertNotNull(service, "WorkPackageService should be created");
    }

    @Test
    void testClientCanBeCreatedWithoutAuth() {
        // Test that client can be created without authentication for public access
        OpenProjectClient client = new OpenProjectClient("https://example.com", (com.github.jpmand.openproject.client.auth.AuthProvider) null);
        assertNotNull(client, "Client should be created without authentication");
    }

    @Test
    void testClientMethodsExist() throws NoSuchMethodException {
        // Verify all expected methods exist on the client
        OpenProjectClient.class.getDeclaredMethod("getWorkPackage", long.class);
        OpenProjectClient.class.getDeclaredMethod("listWorkPackages");
        OpenProjectClient.class.getDeclaredMethod("listWorkPackages", Integer.class, Integer.class);
        OpenProjectClient.class.getDeclaredMethod("listWorkPackages", 
            Integer.class, Integer.class, String.class, String.class, 
            String.class, Boolean.class, String.class, String.class);
        // New type-safe methods with Map for sort
        OpenProjectClient.class.getDeclaredMethod("listWorkPackages",
            Integer.class, Integer.class, List.class, Map.class);
        OpenProjectClient.class.getDeclaredMethod("listWorkPackages",
            Integer.class, Integer.class, FilterObject.class, String.class, SortEnum.class);
    }

    @Test
    void testServiceMethodsReturnCorrectTypes() throws NoSuchMethodException {
        // Verify service methods return expected types
        var getMethod = WorkPackageService.class.getDeclaredMethod("getWorkPackage", Long.class);
        assertTrue(getMethod.getReturnType().getTypeName().contains("Call"));
        
        var listMethod = WorkPackageService.class.getDeclaredMethod("listWorkPackages");
        assertTrue(listMethod.getReturnType().getTypeName().contains("Call"));
        
        var listWithPaginationMethod = WorkPackageService.class.getDeclaredMethod("listWorkPackages", Integer.class, Integer.class);
        assertTrue(listWithPaginationMethod.getReturnType().getTypeName().contains("Call"));
        
        var listWithAllParamsMethod = WorkPackageService.class.getDeclaredMethod("listWorkPackages",
            Integer.class, Integer.class, String.class, String.class,
            String.class, Boolean.class, String.class, String.class);
        assertTrue(listWithAllParamsMethod.getReturnType().getTypeName().contains("Call"));
    }
}
