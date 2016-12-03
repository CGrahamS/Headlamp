package com.epicodus.headlamp.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.epicodus.headlamp.R;
import com.epicodus.headlamp.models.Server;
import com.epicodus.headlamp.services.MCAPIService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ServerDetailsActivity extends AppCompatActivity {
    public static final String TAG = ServerDetailsActivity.class.getSimpleName();
    private static String mServerDomain;
    private String[] mServerDetailLabels;
    private String[] mServerDetailValues; //Simulated values. These will eventually be retrieved via an API Get request
    private List<String> mFormattedDetailArray = new ArrayList<String>();
    @Bind(R.id.serverDomainTextView) TextView mServerDomainTextView;
    @Bind(R.id.serverDetailListView) ListView mServerDetailListView;

    ArrayList<Server> mServers = new ArrayList<>();

    public static String getServerDomain() {
        return mServerDomain;
    }

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
        Typeface minecraftFont = Typeface.createFromAsset(getAssets(), "fonts/Minecrafter.Reg.ttf");
        mServerDomainTextView.setTypeface(minecraftFont);
        //Populate serverDetails ArrayList with simulated values
        mServerDetailValues = getResources().getStringArray(R.array.server_detail_values);
        mServerDetailLabels = getResources().getStringArray(R.array.server_detail_labels);
        String formattedStatus = String.format(mServerDetailLabels[0], mServerDetailValues[0]);
        String formattedMOTD = String.format(mServerDetailLabels[1], mServerDetailValues[1]);
        String formattedPlayers = String.format(mServerDetailLabels[2], mServerDetailValues[2]);
        String formattedMaxPlayers = String.format(mServerDetailLabels[3], mServerDetailValues[3]);
        mFormattedDetailArray.add(formattedStatus);
        mFormattedDetailArray.add(formattedMOTD);
        mFormattedDetailArray.add(formattedPlayers);
        mFormattedDetailArray.add(formattedMaxPlayers);
//      formatDetails(mServerDetailLabels, mServerDetailValues);

        //create ArrayAdapter
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mFormattedDetailArray);
        mServerDetailListView.setAdapter(adapter);
        getServerInfo(mServerDomain);
    }

    private void getServerInfo(String server) {
        final MCAPIService mcapiService = new MCAPIService();
        mcapiService.retrieveServerInfo(server, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                Log.v(TAG, "Failure");
            }

            //FIXME Receives no JSON data.
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    Log.v(TAG, "JSON: " + jsonData);
                    Log.v(TAG, "Response!");
                    mServers = mcapiService.processResults(response);
                    Log.v(TAG, response.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //FIXME Formats first two strings with first argument twice. Likely because the variable names are not unique.
    private void formatDetails(String[] labels, String[] values) {
        for(int i = 0; i < labels.length; i++) {
            String j = Integer.toString(i);
            String formattedDetail = String.format(labels[i], values[0], values[1], values[2], values[3]);
            this.mFormattedDetailArray.add(formattedDetail);
            Log.i(TAG, "Formatted Array: " + this.mFormattedDetailArray.get(i));
        }
    };
}
