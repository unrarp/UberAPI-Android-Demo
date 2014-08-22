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

    float request_time;

    public float getRequestTime() {
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

    float start_time;

    public float getStart_time() {
        return start_time;
    }

    Location start_location;

    public Location getStartLocation() {
        return start_location;
    }

    int end_time;

    public int getEndTime() {
        return end_time;
    }

    Location end_location;

    public Location getEndLocation() {
        return end_location;
    }

}
