package com.example.brodcastreceiver;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class publicnotification extends FirebaseMessagingService {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);
        String title = message.getNotification().getTitle();
        String text = message.getNotification().getBody();
        final String CHANNEL_ID="DONE_Notification ";
        @SuppressLint("WrongConstant") NotificationChannel channel = new NotificationChannel(
              CHANNEL_ID,"done notification work",
                NotificationManager.IMPORTANCE_HIGH
        );
        getSystemService(NotificationManager.class).createNotificationChannel(channel);
        Notification.Builder notBuilder = new Notification.Builder(this, CHANNEL_ID)
                .setContentTitle(title)
                .setContentTitle(text)
                .setAutoCancel(true);
        NotificationManagerCompat.from(this).notify(1,notBuilder.build());
        super.onMessageReceived(message);
    }
}
