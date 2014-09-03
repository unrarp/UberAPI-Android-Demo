package com.rahul.uberapi.android.demo.model;

/**
 * Used by the user activity endpoint and contains information including the latitude, longitude &
 * address of a location.
 */
public class Location extends UberModel {

    /**
     * Human-readable address.
     */
    String address;

    public String getAddress() {
        return address;
    }

    /**
     * Latitude component of location.
     */
    double latitude;

    public double getLatitude() {
        return latitude;
    }

    /**
     * Longitude component of location.
     */
    double longitude;

    public double getLongitude() {
        return longitude;
    }

}
