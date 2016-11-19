package com.epicodus.headlamp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserDetailsActivity extends AppCompatActivity {
    public static final String TAG = UserDetailsActivity.class.getSimpleName();
    private String mUserName;
    @Bind(R.id.userDetailTextView) TextView mUserDetailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        mUserName = intent.getStringExtra("userName");
        Log.i(TAG, "Username: " + mUserName);
        mUserDetailTextView.setText(mUserName);
    }
}
