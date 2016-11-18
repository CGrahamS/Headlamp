package com.epicodus.headlamp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ServerDetailsActivity extends AppCompatActivity {
    public static final String TAG = ServerDetailsActivity.class.getSimpleName();
    private String mServerDomain;
    private String[] mServerDetailLabels;
    private String[] mServerDetailValues; //Simulated values. These will eventually be retrieved via an API Get request
    private String mFormattedDetail;
    private List<String> mFormattedDetailArray = new ArrayList<String>();
    @Bind(R.id.serverDomainTextView) TextView mServerDomainTextView;
    @Bind(R.id.serverDetailListView) ListView mServerDetailListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_details);
        ButterKnife.bind(this);

        //Get intent
        Intent intent = getIntent();
        //declare variable equal to the string passed with intent
        mServerDomain = intent.getStringExtra("serverDomain");
        Log.i(TAG, "mServerDomain:" + mServerDomain);
        //set serverHeader textView text to new string variable
        mServerDomainTextView.setText(mServerDomain);
        //Populate serverDetails ArrayList with simulated values
        mServerDetailValues = getResources().getStringArray(R.array.server_detail_values);
        mServerDetailLabels = getResources().getStringArray(R.array.server_detail_labels);
        Log.i(TAG, "Status: " + mServerDetailValues[0]);
        Log.i(TAG, "MOTD: " + mServerDetailValues[1]);
        Log.i(TAG, "OL P: " + mServerDetailValues[2]);
        Log.i(TAG, "Max Players: " + mServerDetailValues[3]);
        for(int i = 0; i < mServerDetailLabels.length; i++) {
            mFormattedDetail = String.format(mServerDetailLabels[i], mServerDetailValues[0], mServerDetailValues[1], mServerDetailValues[2], mServerDetailValues[3]);
            mFormattedDetailArray.add(mFormattedDetail);

            Log.i(TAG, "Formatted Array: " + mFormattedDetailArray.get(i));
        }
        //create ArrayAdapter
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mFormattedDetailArray);
        mServerDetailListView.setAdapter(adapter);
    }
}
