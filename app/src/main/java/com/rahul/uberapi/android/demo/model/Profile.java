package com.rahul.uberapi.android.demo.model;

/**
 * Used by the profile endpoint and contains information about the Uber user that has authorized
 * with the application.
 */
public class Profile extends UberModel {

    /**
     * First name of the Uber user.
     */
    String first_name;

    public String getFirstName() {
        return first_name;
    }

    /**
     * Last name of the Uber user.
     */
    String last_name;

    public String getLastName() {
        return last_name;
    }

    /**
     * Email address of the Uber user
     */
    String email;

    public String getEmail() {
        return email;
    }

    /**
     * Image URL of the Uber user.
     */
    String picture;

    public String getPicture() {
        return picture;
    }

    /**
     * Promo code of the Uber user.
     */
    String promo_code;

    public String getPromoCode() {
        return promo_code;
    }

}
