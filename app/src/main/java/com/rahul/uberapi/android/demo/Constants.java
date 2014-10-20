package com.rahul.uberapi.android.demo;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;

public class Constants {

    private static HashMap<String, String> authParameters = new HashMap<String, String>();

    public static final String AUTHORIZE_URL = "https://login.uber.com/oauth/authorize";
    public static final String BASE_URL = "https://login.uber.com/";
    public static final String SCOPES = "profile history_lite history";
    public static final String BASE_UBER_URL_V1 = "https://api.uber.com/v1/";
    public static final String BASE_UBER_URL_V1_1 = "https://api.uber.com/v1.1/";
    public static final double START_LATITUDE = 37.781955;
    public static final double START_LONGITUDE = -122.402367;
    public static final double END_LATITUDE = 37.744352;
    public static final double END_LONGITUDE = -122.416743;
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static String getUberClientId(Activity activity) {
        return getManifestData(activity, "com.rahul.uberapi.android.demo.UBER_CLIENT_ID");
    }

    public static String getUberClientSecret(Activity activity) {
        return getManifestData(activity, "com.rahul.uberapi.android.demo.UBER_CLIENT_SECRET");
    }

    public static String getUberRedirectUrl(Activity activity) {
        return getManifestData(activity, "com.rahul.uberapi.android.demo.UBER_REDIRECT_URL");
    }

    public static String getManifestData(Activity activity, String name) {
        String data = authParameters.get(name);
        if (data != null) {
            return data;
        }
        try {
            ApplicationInfo ai = activity.getPackageManager().getApplicationInfo(activity.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
            data = bundle.getString(name);
            authParameters.put(name, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

}
