package com.epicodus.headlamp.models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

/**
 * Created by CGrahamS on 12/2/16.
 */
public class Server {
    private String mServerName;
    private String mMessageOfTheDay;
    private int mPlayersOnline;
    private int mMaxPlayers;
    private int mServerPing;
    private Bitmap mFavIcon;

    public Server(String serverName, String messageOfTheDay, int playersOnline, int maxPlayers, int serverPing, String favIcon) {
        this.mServerName = serverName;
        this.mMessageOfTheDay = messageOfTheDay;
        this.mPlayersOnline = playersOnline;
        this.mMaxPlayers = maxPlayers;
        this.mServerPing = serverPing;

        //Decode favicon from string into bytes and bytes into BitMap
        byte[] decodedFavIcon = Base64.decode(favIcon, Base64.DEFAULT);
        Bitmap bitMapFavIcon = BitmapFactory.decodeByteArray(decodedFavIcon, 0, decodedFavIcon.length);
        this.mFavIcon = bitMapFavIcon;
    }

    public String getServerName() {
        return mServerName;
    }

    public String getMessageOfTheDay() {
        return mMessageOfTheDay;
    }

    public int getPlayersOnline() {
        return mPlayersOnline;
    }

    public int getMaxPlayers() {
        return mMaxPlayers;
    }

    public int getServerPing() {
        return mServerPing;
    }

    public Bitmap getFavIcon() {
        return mFavIcon;
    }

}


