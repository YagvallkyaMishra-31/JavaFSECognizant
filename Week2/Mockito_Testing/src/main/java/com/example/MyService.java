package com.example;

/**
 * MyService - A service class that depends on ExternalApi.
 * 
 * This is a typical pattern in real applications — your business logic
 * lives in a service class, but it needs to talk to some external system.
 * By injecting ExternalApi through the constructor, we make it easy to
 * swap in a mock during testing.
 */
public class MyService {

    private final ExternalApi externalApi;

    // Constructor injection — we pass in the API dependency
    // This makes it easy to substitute a mock in our tests
    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    /**
     * Fetches data from the external API.
     * In a real app, we might add caching, error handling, or
     * data transformation here.
     */
    public String fetchData() {
        return externalApi.getData();
    }

    /**
     * Processes and sends data through the external API.
     * Converts the input to uppercase before sending — just to
     * show some business logic between our code and the API call.
     */
    public void processAndSendData(String data) {
        String processed = data.toUpperCase();
        externalApi.sendData(processed);
    }

    /**
     * Fetches data by ID and adds a prefix for display purposes.
     */
    public String fetchDataById(int id) {
        String rawData = externalApi.getDataById(id);
        if (rawData == null) {
            return "No data found for ID: " + id;
        }
        return "Result: " + rawData;
    }
}
