package com.example.brodcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
     BroadcastReceiver broadcastReceiver = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        broadcastReceiver = new MyReceiver();
        internetRec();
    }

      public  void saveData(View view){
//          EditText teamView = (EditText) findViewById(R.id.team);
          EditText devView = (EditText) findViewById(R.id.dev);
          EditText testView =(EditText) findViewById(R.id.name);


      }
     public  void internetRec(){
        registerReceiver(broadcastReceiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
     }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }



}
