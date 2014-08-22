package com.rahul.uberapi.android.demo.model;

/**
 * Used by the auth endpoint and contains information data about the current authenticated user.
 */
public class User extends UberModel {

    String access_token;

    public String getAccessToken() {
        return access_token;
    }

    String token_type;

    public String getTokenType() {
        return token_type;
    }

    String expires_in;

    public String getExpiresIn() {
        return expires_in;
    }

    String refresh_token;

    public String getRefreshToken() {
        return refresh_token;
    }

    String scope;

    public String getScope() {
        return scope;
    }

}
