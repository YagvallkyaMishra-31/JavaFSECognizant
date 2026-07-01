package com.example;

/**
 * ExternalApi - Represents an external API that our service depends on.
 * 
 * In a real project, this could be a REST client, a database connector,
 * or any third-party service. We keep it as an interface so that
 * we can easily mock it during testing without hitting the real API.
 */
public interface ExternalApi {

    /**
     * Fetches data from the external source.
     * In production this might call a REST endpoint or query a database.
     */
    String getData();

    /**
     * Sends data to the external service.
     * @param data the data string to send
     */
    void sendData(String data);

    /**
     * Fetches data for a specific item by its ID.
     * @param id the item identifier
     * @return the data associated with that ID
     */
    String getDataById(int id);
}
