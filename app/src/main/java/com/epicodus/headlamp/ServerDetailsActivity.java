package com.epicodus.headlamp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ServerDetailsActivity extends AppCompatActivity {
    public static final String TAG = ServerDetailsActivity.class.getSimpleName();
    private String mServerDomain;
    @Bind(R.id.serverDomainTextView) TextView mServerDomainTextView;

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
    }
}
