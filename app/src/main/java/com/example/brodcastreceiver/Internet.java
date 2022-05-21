package com.example.brodcastreceiver;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;

import androidx.annotation.RequiresApi;


public class Internet {
    @RequiresApi(api = Build.VERSION_CODES.M)
    public  static String getNetwork(Context context){

        String status = null;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        Network networkInfo = connectivityManager.getActiveNetwork();
        if(networkInfo != null)
        {
            status = "connected";
            return  status;
        }else {
            status = "Disconnected";
            return status;
        }
    }
}
