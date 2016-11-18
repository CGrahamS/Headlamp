package com.epicodus.headlamp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.serverEditText) EditText mServerEditText;
    @Bind(R.id.serverButton) Button mServerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mServerButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mServerButton) {
            String serverDomain = mServerEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, ServerDetailsActivity.class);
            intent.putExtra("serverDomain", serverDomain);
            startActivity(intent);
        }
    }
}
