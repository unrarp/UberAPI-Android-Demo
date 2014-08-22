package com.rahul.uberapi.android.demo.model;

/**
 * Used by the product endpoint and contains information about display name and other details about
 * each product.
 */
public class Product extends UberModel {

    /**
     * Unique identifier representing a specific product for a given latitude & longitude. For
     * example, uberX in San Francisco will have a different product_id than uberX in Los Angeles.
     */
    String product_id;

    public String getProductId() {
        return product_id;
    }

    /**
     * Description of product.
     */
    String description;

    public String getDescription() {
        return description;
    }

    /**
     * Display name of product.
     */
    String display_name;

    public String getDisplayName() {
        return display_name;
    }

    /**
     * Capacity of product. For example, 4 people.
     */
    int capacity;

    public int getCapacity() {
        return capacity;
    }

    /**
     * Image URL representing the product.
     */
    String image;

    public String getImage() {
        return image;
    }

}
