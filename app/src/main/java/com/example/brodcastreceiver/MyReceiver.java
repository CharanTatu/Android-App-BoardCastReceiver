package com.example.brodcastreceiver;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class MyReceiver extends BroadcastReceiver {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onReceive(Context context, Intent intent) {
         String status = Internet.getNetwork(context);

       /*  AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Internet connect")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.e("TAG","Connection Successful");
                    }
                }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.e("TAG"," no Connection ");
            }
        });*/


         if(status.equals("connected")) {
             Toast.makeText(context, " connect internet ", Toast.LENGTH_SHORT).show();
             /*AlertDialog.Builder builder = new AlertDialog.Builder(context);
             builder.setMessage("Internet Connected").show();*/

         }
         else if(status.equals("Disconnected")){
             Toast.makeText(context,"Please connect internet ",Toast.LENGTH_SHORT).show();
             AlertDialog.Builder builder = new AlertDialog.Builder(context);
             builder.setMessage("Please Connect Internet?")
                     .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialogInterface, int i) {

                             Log.e("TAG","Connection Successful");
                         }
                     }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {

                     Log.e("TAG","Connection required ");

                 }
             }).show();
         }

    }
}