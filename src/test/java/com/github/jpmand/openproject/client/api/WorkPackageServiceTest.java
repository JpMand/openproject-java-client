package com.github.jpmand.openproject.client.api;

import com.github.jpmand.openproject.client.api.services.WorkPackageService;
import com.github.jpmand.openproject.client.http.serialization.HalObjectMapper;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

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
        OpenProjectClient client = new OpenProjectClient("https://community.openproject.org");
        assertNotNull(client);
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
        assertNotNull(service.listWorkPackages(0, 10, null, null, null, null, null));
    }
}
