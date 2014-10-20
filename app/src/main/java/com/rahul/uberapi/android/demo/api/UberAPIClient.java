package com.rahul.uberapi.android.demo.api;

import com.rahul.uberapi.android.demo.BuildConfig;
import com.rahul.uberapi.android.demo.Constants;
import com.rahul.uberapi.android.demo.model.PriceEstimateList;
import com.rahul.uberapi.android.demo.model.ProductList;
import com.rahul.uberapi.android.demo.model.Profile;
import com.rahul.uberapi.android.demo.model.TimeEstimateList;
import com.rahul.uberapi.android.demo.model.UserActivity;

import retrofit.Callback;
import retrofit.Endpoint;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Query;

public class UberAPIClient {

    private static UberAPIInterface sUberAPIService;
    private static UberEndPoint sEndPoint = new UberEndPoint(Constants.BASE_UBER_URL_V1, Constants.BASE_UBER_URL_V1_1);

    private static UberAPIInterface getUberAPIClient() {
        if (sUberAPIService == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(sEndPoint)
                    .setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
                    .build();

            sUberAPIService = restAdapter.create(UberAPIInterface.class);
        }

        return sUberAPIService;
    }

    public static UberAPIInterface getUberV1APIClient() {
        sEndPoint.setVersion(false);
        return getUberAPIClient();
    }

    public static UberAPIInterface getUberV1_1APIClient() {
        sEndPoint.setVersion(true);
        return getUberAPIClient();
    }

    public interface UberAPIInterface {

        /**
         * The Products endpoint returns information about the Uber products offered at a given
         * location. The response includes the display name and other details about each product,
         * and lists the products in the proper display order.
         *
         * @param authToken OAuth 2.0 bearer token with the profile scope.
         * @param latitude  Latitude component of location.
         * @param longitude Longitude component of location.
         * @param callback
         */
        @GET("/products")
        void getProducts(@Header("Authorization") String authToken,
                         @Query("latitude") double latitude,
                         @Query("longitude") double longitude,
                         Callback<ProductList> callback);

        /**
         * The Time Estimates endpoint returns ETAs for all products offered at a given location,
         * with the responses expressed as integers in seconds. We recommend that this endpoint be
         * called every minute to provide the most accurate, up-to-date ETAs.
         *
         * @param authToken      OAuth 2.0 bearer token or server_token
         * @param startLatitude  Latitude component.
         * @param startLongitude Longitude component.
         * @param callback
         */
        @GET("/estimates/time")
        void getTimeEstimates(@Header("Authorization") String authToken,
                              @Query("start_latitude") double startLatitude,
                              @Query("start_longitude") double startLongitude,
                              Callback<TimeEstimateList> callback);

        /**
         * The Price Estimates endpoint returns an estimated price range for each product offered
         * at a given location. The price estimate is provided as a formatted string with the full
         * price range and the localized currency symbol.
         * <p/>
         * The response also includes low and high estimates, and the ISO 4217 currency code for
         * situations requiring currency conversion. When surge is active for a particular product,
         * its surge_multiplier will be greater than 1, but the price estimate already factors in
         * this multiplier.
         *
         * @param authToken      OAuth 2.0 bearer token or server_token
         * @param startLatitude  Latitude component of start location.
         * @param startLongitude Longitude component of start location.
         * @param endLatitude    Longitude component of start location.
         * @param endLongitude   Longitude component of end location.
         * @param callback
         */
        @GET("/estimates/price")
        void getPriceEstimates(@Header("Authorization") String authToken,
                               @Query("start_latitude") double startLatitude,
                               @Query("start_longitude") double startLongitude,
                               @Query("end_latitude") double endLatitude,
                               @Query("end_longitude") double endLongitude,
                               Callback<PriceEstimateList> callback);

        /**
         * The User Activity endpoint returns data about a user's lifetime activity with Uber. The
         * response will include pickup locations and times, dropoff locations and times, the
         * distance of past requests, and information about which products were requested.
         * <p/>
         * The history array in the response will have a maximum length based on the limit parameter.
         * The response value count may exceed limit, therefore subsequent API requests may be
         * necessary.
         *
         * @param authToken OAuth 2.0 bearer token with the history scope.
         * @param offset    Offset the list of returned results by this amount. Default is zero.
         * @param limit     Number of items to retrieve. Default is 5, maximum is 100.
         * @param callback
         */
        @GET("/history")
        void getUserActivity(@Header("Authorization") String authToken,
                             @Query("offset") int offset,
                             @Query("limit") int limit,
                             Callback<UserActivity> callback);

        /**
         * The User Profile endpoint returns information about the Uber user that has authorized
         * with the application.
         *
         * @param authToken OAuth 2.0 bearer token with the profile scope.
         * @param callback
         */
        @GET("/me")
        void getProfile(@Header("Authorization") String authToken,
                        Callback<Profile> callback);
    }

    private static class UberEndPoint implements Endpoint {

        private final String apiUrlV1, apiUrlV11;
        private boolean useV11 = false;

        private UberEndPoint(String apiUrlV1, String apiUrlV11) {
            this.apiUrlV1 = apiUrlV1;
            this.apiUrlV11 = apiUrlV11;
        }

        public void setVersion(boolean useV11) {
            this.useV11 = useV11;
        }

        @Override
        public String getUrl() {
            return useV11 ? apiUrlV11 : apiUrlV1;
        }

        @Override
        public String getName() {
            return "default";
        }
    }
}
