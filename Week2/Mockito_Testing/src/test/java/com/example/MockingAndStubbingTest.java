package com.example;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Exercise 1: Mocking and Stubbing
 *
 * When we test MyService, we don't want to actually call the real ExternalApi
 * (it might be slow, unreliable, or cost money). Instead, we create a "mock"
 * — a fake version of ExternalApi that we fully control.
 *
 * Stubbing means telling the mock what to return when its methods are called.
 * For example: when(mockApi.getData()).thenReturn("some value")
 *
 * This way we can test our service logic in isolation, without worrying
 * about the external dependency.
 */
public class MockingAndStubbingTest {

    private ExternalApi mockApi;
    private MyService service;

    @Before
    public void setUp() {
        // Create a mock of ExternalApi — this is a fake object that
        // we can program to behave however we want
        mockApi = Mockito.mock(ExternalApi.class);

        // Inject the mock into our service
        service = new MyService(mockApi);
    }

    @Test
    public void testFetchDataWithMock() {
        // Stub the getData() method to return a predefined value
        // Instead of calling a real API, it just returns "Mock Data"
        when(mockApi.getData()).thenReturn("Mock Data");

        // Call the service method that internally uses externalApi.getData()
        String result = service.fetchData();

        // Verify we got back what the mock was programmed to return
        assertEquals("Mock Data", result);
        System.out.println("testFetchDataWithMock passed — got: " + result);
    }

    @Test
    public void testFetchDataByIdWithStub() {
        // Stubbing with a specific argument — only returns this value
        // when getDataById is called with id = 42
        when(mockApi.getDataById(42)).thenReturn("Product XYZ");

        String result = service.fetchDataById(42);

        // Our service adds "Result: " prefix to the API response
        assertEquals("Result: Product XYZ", result);
        System.out.println("testFetchDataByIdWithStub passed — got: " + result);
    }

    @Test
    public void testFetchDataByIdReturnsNull() {
        // When the mock returns null (simulating "not found" from API)
        when(mockApi.getDataById(999)).thenReturn(null);

        String result = service.fetchDataById(999);

        // Our service should handle null and return a friendly message
        assertEquals("No data found for ID: 999", result);
        System.out.println("testFetchDataByIdReturnsNull passed — got: " + result);
    }

    @Test
    public void testMultipleStubs() {
        // We can stub different calls to return different things
        when(mockApi.getDataById(1)).thenReturn("Laptop");
        when(mockApi.getDataById(2)).thenReturn("Headphones");
        when(mockApi.getDataById(3)).thenReturn("Keyboard");

        assertEquals("Result: Laptop", service.fetchDataById(1));
        assertEquals("Result: Headphones", service.fetchDataById(2));
        assertEquals("Result: Keyboard", service.fetchDataById(3));

        System.out.println("testMultipleStubs passed — different IDs returned different products");
    }
}
