package com.epicodus.headlamp.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.epicodus.headlamp.R;

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
        Typeface minecraftFont = Typeface.createFromAsset(getAssets(), "fonts/Minecrafter.Reg.ttf");
        mUserDetailTextView.setTypeface(minecraftFont);
        Intent intent = getIntent();
        mUserName = intent.getStringExtra("userName");
        Log.i(TAG, "Username: " + mUserName);
        mUserDetailTextView.setText(mUserName);
    }
}
