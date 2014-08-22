package com.rahul.uberapi.android.demo.model;

/**
 * Used by the time estimates endpoint and contains information about ETAs for all products offered
 * at a given location, with the responses expressed as integers in seconds.
 */
public class TimeEstimate extends UberModel {

    /**
     * Unique identifier representing a specific product for a given latitude & longitude. For
     * example, uberX in San Francisco will have a different product_id than uberX in Los Angeles.
     */
    String product_id;

    public String getProductId() {
        return product_id;
    }

    /**
     * Localized display name of product.
     */
    String localized_display_name;

    public String getLocalizedDisplayName() {
        return localized_display_name;
    }

    /**
     * Display name of product.
     */
    String display_name;

    public String getDisplayName() {
        return display_name;
    }

    /**
     * ETA for the product (in seconds). Always show estimate in minutes.
     */
    int estimate;

    public int getEstimate() {
        return estimate;
    }

}
