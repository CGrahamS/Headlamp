package com.epicodus.headlamp.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.headlamp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.serverLabel) TextView mServerLabel;
    @Bind(R.id.userLabel) TextView mUserLabel;
    @Bind(R.id.serverEditText) EditText mServerEditText;
    @Bind(R.id.serverButton) Button mServerButton;
    @Bind(R.id.userEditText) EditText mUserEditText;
    @Bind(R.id.userButton) Button mUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Typeface minecraftFont = Typeface.createFromAsset(getAssets(), "fonts/Minecrafter.Reg.ttf");
        mServerButton.setTypeface(minecraftFont);
        mUserButton.setTypeface(minecraftFont);
        mServerLabel.setTypeface(minecraftFont);
        mUserLabel.setTypeface(minecraftFont);
        mServerButton.setOnClickListener(this);
        mUserButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mServerButton) {
            String serverDomain = mServerEditText.getText().toString();
            if(serverDomain.trim().matches("")) {
                Toast.makeText(MainActivity.this, "Enter a Server Domain Name!", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(MainActivity.this, ServerDetailsActivity.class);
                intent.putExtra("serverDomain", serverDomain);
                startActivity(intent);
            }
        } else if (v == mUserButton) {
            String userName = mUserEditText.getText().toString();
            if(userName.trim().matches("")) {
                Toast.makeText(MainActivity.this, "Enter a User Name!", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(MainActivity.this, UserDetailsActivity.class);
                intent.putExtra("userName", userName);
                startActivity(intent);
            }
        }
    }
}
