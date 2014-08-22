package com.rahul.uberapi.android.demo.api;

import com.rahul.uberapi.android.demo.BuildConfig;
import com.rahul.uberapi.android.demo.Constants;
import com.rahul.uberapi.android.demo.model.User;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.POST;
import retrofit.http.Query;

public class UberAuthTokenClient {

    private static UberAuthTokenInterface sUberAuthService;

    public static UberAuthTokenInterface getUberAuthTokenClient() {
        if (sUberAuthService == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(Constants.BASE_URL)
                    .setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
                    .build();

            sUberAuthService = restAdapter.create(UberAuthTokenInterface.class);
        }

        return sUberAuthService;
    }

    public interface UberAuthTokenInterface {

        /**
         * Exchange this authorization code for an access_token, which will allow you to make
         * requests on behalf of a user. The access_token expires in 30 days.
         *
         * @param clientSecret A 40 character string. DO NOT SHARE. This should not be available on
         *                     any public facing server or web site.
         * @param clientId     A 32 character string (public)
         * @param grantType    May be authorization_code or refresh_token
         * @param code
         * @param redirectUrl
         * @param callback
         */
        @POST("/oauth/token")
        void getAuthToken(@Query("client_secret") String clientSecret,
                          @Query("client_id") String clientId,
                          @Query("grant_type") String grantType,
                          @Query("code") String code,
                          @Query("redirect_uri") String redirectUrl,
                          Callback<User> callback);
    }

}
