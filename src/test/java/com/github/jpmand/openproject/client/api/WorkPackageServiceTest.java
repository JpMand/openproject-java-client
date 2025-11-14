package com.github.jpmand.openproject.client.api;

import com.github.jpmand.openproject.client.api.models.OPWorkPackageModel;
import com.github.jpmand.openproject.client.api.models.base.AbstractOPCollection;
import com.github.jpmand.openproject.client.api.models.enums.SortEnum;
import com.github.jpmand.openproject.client.api.models.filters.OPFilterObject;
import com.github.jpmand.openproject.client.api.services.WorkPackageService;
import com.github.jpmand.openproject.client.core.serialization.HalObjectMapper;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for WorkPackageService.
 * These tests verify the service interface and basic client functionality.
 */
class WorkPackageServiceTest {

    @Test
    void testServiceInterfaceCreation() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://community.openproject.org")
                .addConverterFactory(JacksonConverterFactory.create(HalObjectMapper.get()))
                .build();
        
        WorkPackageService service = retrofit.create(WorkPackageService.class);
        assertNotNull(service);
    }

    @Test
    void testClientCreationWithoutAuth() {
        OpenProjectClient client = new OpenProjectClient("https://community.openproject.org", (String) null);
        assertNotNull(client);
    }

    @Test
    void testClientMethodsExist() throws Exception {
        OpenProjectClient client = new OpenProjectClient("https://community.openproject.org", (String) null);
        
        // Verify all methods exist and return proper types
        assertNotNull(client.getClass().getMethod("getWorkPackage", long.class));
        assertNotNull(client.getClass().getMethod("listWorkPackages"));
        assertNotNull(client.getClass().getMethod("listWorkPackages", Integer.class, Integer.class));
        assertNotNull(client.getClass().getMethod("listWorkPackages", Integer.class, Integer.class, String.class, String.class, String.class, Boolean.class, String.class, String.class));
        assertNotNull(client.getClass().getMethod("listWorkPackages", Integer.class, Integer.class, List.class, Map.class));
        assertNotNull(client.getClass().getMethod("listWorkPackages", Integer.class, Integer.class, OPFilterObject.class, String.class, SortEnum.class));
    }

    @Test
    void testServiceMethodReturnTypes() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://community.openproject.org")
                .addConverterFactory(JacksonConverterFactory.create(HalObjectMapper.get()))
                .build();
        
        WorkPackageService service = retrofit.create(WorkPackageService.class);
        
        // Verify service methods return Call objects
        assertNotNull(service.getWorkPackage(1L));
        assertNotNull(service.listWorkPackages());
        assertNotNull(service.listWorkPackages(10, 0));
        assertNotNull(service.listWorkPackages(0, 10, null, null, null, null, null, null));
    }
}
