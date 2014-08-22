package com.rahul.uberapi.android.demo.model;

/**
 * Used by the user activity endpoint and contains information including the pickup location,
 * dropoff location, request start time, request end time, and distance of requests (in miles), as
 * well as the product type that was requested.
 */
public class History extends UberModel {

    String uuid;

    public String getUUID() {
        return uuid;
    }

    long request_time;

    public long getRequestTime() {
        return request_time;
    }

    String product_id;

    public String getProductId() {
        return product_id;
    }

    String status;

    public String getStatus() {
        return status;
    }

    float distance;

    public float getDistance() {
        return distance;
    }

    long start_time;

    public long getStart_time() {
        return start_time;
    }

    Location start_location;

    public Location getStartLocation() {
        return start_location;
    }

    long end_time;

    public long getEndTime() {
        return end_time;
    }

    Location end_location;

    public Location getEndLocation() {
        return end_location;
    }

}
