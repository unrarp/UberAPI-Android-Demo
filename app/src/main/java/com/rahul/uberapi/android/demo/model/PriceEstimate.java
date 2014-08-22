package com.rahul.uberapi.android.demo.model;

/**
 * Used by the price estimates endpoint and contains information about the estimated price range
 * for each product offered at a given location. The price estimate is provided as a formatted
 * string with the full price range and the localized currency symbol.
 * <p/>
 * It also includes low and high estimates, and the ISO 4217 currency code for situations requiring
 * currency conversion. When surge is active for a particular product, the surge_multiplier will be
 * greater than 1, but the price estimate already factors in this multiplier.
 */
public class PriceEstimate extends UberModel {

    /**
     * Unique identifier representing a specific product for a given latitude & longitude. For
     * example, uberX in San Francisco will have a different product_id than uberX in Los Angeles.
     */
    String product_id;

    public String getProductId() {
        return product_id;
    }

    /**
     * ISO 4217 currency code.
     */
    String currency_code;

    public String getCurrencyCode() {
        return currency_code;
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
     * Formatted string of estimate in local currency of the start location. Estimate could be a
     * range, a single number (flat rate) or "Metered" for TAXI.
     */
    String estimate;

    public String getEstimate() {
        return estimate;
    }

    /**
     * Lower bound of the estimated price.
     */
    int low_estimate;

    public int getLowEstimate() {
        return low_estimate;
    }

    /**
     * Upper bound of the estimated price.
     */
    int high_estimate;

    public int getHighEstimate() {
        return high_estimate;
    }

    /**
     * Expected surge multiplier. Surge is active if surge_multiplier is greater than 1. Price
     * estimate already factors in the surge multiplier.
     */
    float surge_multiplier;

    public float getSurgeMultiplier() {
        return surge_multiplier;
    }

}
