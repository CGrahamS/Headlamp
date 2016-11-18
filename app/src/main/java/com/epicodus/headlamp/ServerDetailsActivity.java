package com.epicodus.headlamp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ServerDetailsActivity extends AppCompatActivity {
    public static final String TAG = ServerDetailsActivity.class.getSimpleName();
    private String mServerDomain;
    private String[] mServerDetailLabels;
    private String[] mServerDetailValues; //Simulated values. These will eventually be retrieved via an API Get request
    private String mFormattedDetail = "formattedDetail";
    private List<String> mFormattedDetailArray;
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
        Log.i(TAG, mServerDomain);
        //set serverHeader textView text to new string variable
        mServerDomainTextView.setText(mServerDomain);
        //Populate serverDetails ArrayList with simulated values
        mServerDetailValues = getResources().getStringArray(R.array.server_detail_values);
        mServerDetailLabels = getResources().getStringArray(R.array.server_detail_labels);
        mFormattedDetail = String.format(mServerDetailLabels[0], mServerDetailValues[0]);
//        mFormattedDetailArray.add(mFormattedDetail);
        //create ArrayAdapter
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);
        mServerDetailListView.setAdapter(adapter);
// FIXME  for(int i = 0; i < mServerDetailLabels.length; i++) {
//            mFormattedDetail+i = String.format(mServerDetailLabels[i], mServerDetailValues[i]);
//        }
    }
}
