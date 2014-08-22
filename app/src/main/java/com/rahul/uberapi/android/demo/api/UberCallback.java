package com.rahul.uberapi.android.demo.api;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Helper class that extends the Retrofit Callback and implements the default failure method.
 */
public class UberCallback<T> implements Callback<T> {

    @Override
    public void success(T t, Response response) {

    }

    @Override
    public void failure(RetrofitError error) {
        error.printStackTrace();
    }

}
