package com.rahul.uberapi.android.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.rahul.uberapi.android.demo.api.UberAPIClient;
import com.rahul.uberapi.android.demo.api.UberCallback;
import com.rahul.uberapi.android.demo.model.PriceEstimateList;
import com.rahul.uberapi.android.demo.model.ProductList;
import com.rahul.uberapi.android.demo.model.Profile;
import com.rahul.uberapi.android.demo.model.TimeEstimateList;
import com.rahul.uberapi.android.demo.model.UserActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit.client.Response;


public class EndpointActivity extends ActionBarActivity {

    public static void start(Context context, int position, String accessToken, String tokenType) {
        Intent intent = new Intent(context, EndpointActivity.class);
        intent.putExtra("position", position);
        intent.putExtra("access_token", accessToken);
        intent.putExtra("token_type", tokenType);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int position = getIntent().getIntExtra("position", 0);
        switch (position) {
            case 1:
                UberAPIClient.getUberV1APIClient().getProducts(getAccessToken(),
                        Constants.START_LATITUDE,
                        Constants.START_LONGITUDE,
                        new UberCallback<ProductList>() {
                            @Override
                            public void success(ProductList productList, Response response) {
                                setupListAdapter("products", productList.toString());
                            }
                        });
                break;
            case 2:
                UberAPIClient.getUberV1APIClient().getTimeEstimates(getAccessToken(),
                        Constants.START_LATITUDE,
                        Constants.START_LONGITUDE,
                        new UberCallback<TimeEstimateList>() {
                            @Override
                            public void success(TimeEstimateList timeEstimateList, Response response) {
                                setupListAdapter("time", timeEstimateList.toString());
                            }
                        });
                break;
            case 3:
                UberAPIClient.getUberV1APIClient().getPriceEstimates(getAccessToken(),
                        Constants.START_LATITUDE,
                        Constants.START_LONGITUDE,
                        Constants.END_LATITUDE,
                        Constants.END_LONGITUDE,
                        new UberCallback<PriceEstimateList>() {
                            @Override
                            public void success(PriceEstimateList priceEstimateList, Response response) {
                                setupListAdapter("price", priceEstimateList.toString());
                            }
                        });
                break;
            case 4:
                UberAPIClient.getUberV1APIClient().getUserActivity(getAccessToken(),
                        0,
                        5,
                        new UberCallback<UserActivity>() {
                            @Override
                            public void success(UserActivity userActivity, Response response) {
                                setupListAdapter("history (v1)", userActivity.toString());
                            }
                        });
                break;
            case 5:
                UberAPIClient.getUberV1_1APIClient().getUserActivity(getAccessToken(),
                        0,
                        5,
                        new UberCallback<UserActivity>() {
                            @Override
                            public void success(UserActivity userActivity, Response response) {
                                setupListAdapter("history (v1.1)", userActivity.toString());
                            }
                        });
                break;
            case 6:
                UberAPIClient.getUberV1APIClient().getProfile(getAccessToken(),
                        new UberCallback<Profile>() {
                            @Override
                            public void success(Profile profile, Response response) {
                                setupListAdapter("me", profile.toString());
                            }
                        });
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupListAdapter(String endpoint, String response) {
        List<String> options = new ArrayList<String>();
        options.add(getString(R.string.endpoint_list_header_text, endpoint));
        options.add(getString(R.string.endpoint_list_result_text, endpoint));
        options.add(response);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, options));
    }


    private String getAccessToken() {
        return getIntent().getStringExtra("token_type") + " " + getIntent().getStringExtra("access_token");
    }
}
