package com.rahul.uberapi.android.demo.model;

/**
 * Used by the user activity endpoint and contains information including the pickup location,
 * dropoff location, request start time, request end time, and distance of requests (in miles), as
 * well as the product type that was requested.
 */
public class History extends UberModel {

    /**
     * Unique user identifier.
     */
    String uuid;

    public String getUUID() {
        return uuid;
    }

    /**
     * Unix timestamp of trip request time.
     */
    long request_time;

    public long getRequestTime() {
        return request_time;
    }

    /**
     * Unique identifier representing a specific product for a given latitude & longitude. For
     * example, uberX in San Francisco will have a different product_id than uberX in Los Angeles.
     */
    String product_id;

    public String getProductId() {
        return product_id;
    }

    /**
     * Status of the trip. Only returns completed for now.
     */
    String status;

    public String getStatus() {
        return status;
    }

    /**
     * Length of trip in miles.
     */
    float distance;

    public float getDistance() {
        return distance;
    }

    /**
     * Unix timestamp of trip start time.
     */
    long start_time;

    public long getStart_time() {
        return start_time;
    }

    /**
     * Latitude, longitude & address of the start location.
     */
    Location start_location;

    public Location getStartLocation() {
        return start_location;
    }

    /**
     * Unix timestamp of trip end time.
     */
    long end_time;

    public long getEndTime() {
        return end_time;
    }

    /**
     * Latitude, longitude & address of the end location.
     */
    Location end_location;

    public Location getEndLocation() {
        return end_location;
    }

}
