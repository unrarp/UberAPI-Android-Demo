package com.rahul.uberapi.android.demo.model;

import java.util.List;

/**
 * Used by the user activity endpoint and contains information data about a user's lifetime
 * activity with Uber. It includes pickup locations and times, dropoff locations and times, the
 * distance of past requests, and information about which products were requested.
 */
public class UserActivity extends UberModel {

    /**
     * Position in pagination.
     */
    int offset;

    public int getOffset() {
        return offset;
    }

    /**
     * Number of items to retrieve (100 max).
     */
    int limit;

    public int getLimit() {
        return limit;
    }

    /**
     * Total number of items available.
     */
    int count;

    public int getCount() {
        return count;
    }

    /**
     * Information including the pickup location, dropoff location, request start time, request end
     * time, and distance of requests (in miles), as well as the product type that was requested.
     */
    List<History> history;

    public List<History> getHistory() {
        return history;
    }

}
