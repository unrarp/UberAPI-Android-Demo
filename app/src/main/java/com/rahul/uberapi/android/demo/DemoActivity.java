package com.rahul.uberapi.android.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class DemoActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    public static void start(Context context, String accessToken, String tokenType) {
        Intent intent = new Intent(context, DemoActivity.class);
        intent.putExtra("access_token", accessToken);
        intent.putExtra("token_type", tokenType);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setOnItemClickListener(this);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, getOptionsList()));
    }

    private List<String> getOptionsList() {
        List<String> options = new ArrayList<String>();
        options.add(getString(R.string.demo_list_header_text, getIntent().getStringExtra("access_token")));
        options.add(getString(R.string.products));
        options.add(getString(R.string.time_estimates));
        options.add(getString(R.string.price_estimates));
        options.add(getString(R.string.history_v1));
        options.add(getString(R.string.history_v1_1));
        options.add(getString(R.string.me));
        return options;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        EndpointActivity.start(this, position,
                getIntent().getStringExtra("access_token"),
                getIntent().getStringExtra("token_type"));
    }

}
