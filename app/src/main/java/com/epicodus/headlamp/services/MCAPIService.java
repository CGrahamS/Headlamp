package com.epicodus.headlamp.services;

import android.graphics.Bitmap;
import android.util.Log;

import com.epicodus.headlamp.Constants;
import com.epicodus.headlamp.models.Server;
import com.epicodus.headlamp.ui.ServerDetailsActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by CGrahamS on 12/2/16.
 */
public class MCAPIService {
    public static final String TAG = MCAPIService.class.getSimpleName();
    public static void retrieveServerInfo(String server, Callback callback) {


        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MCAPI_BASE_URL).newBuilder();
        //retrieve ServeDomain variable from ServerDetails
        urlBuilder.addPathSegment(ServerDetailsActivity.getServerDomain());
        //Add info query parameter
        urlBuilder.addPathSegment(Constants.MCAPI_SERVER_INFO_QUERY_PARAMETER);
        String url = urlBuilder.build().toString();
        Log.v(TAG, url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Server> processResults(Response response) {
        ArrayList<Server> servers = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject mineCraftJSON = new JSONObject(jsonData);
                JSONObject serverJSON = mineCraftJSON.getJSONObject("server");
                String serverName = serverJSON.getString("hostname");
                String messageOfTheDay = serverJSON.getString("motd");
                int playersOnline = serverJSON.getJSONObject("players")
                        .getInt("online");
                int maxPlayers = serverJSON.getJSONObject("players")
                        .getInt("max");
                int serverPing = serverJSON.getInt("ping");
                String favIcon = serverJSON.getString("favicon");
                Server server = new Server(serverName, messageOfTheDay, playersOnline, maxPlayers, serverPing, favIcon);
                servers.add(server);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return servers;
    }

}
