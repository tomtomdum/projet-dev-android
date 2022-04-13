package com.example.inf1030_tp1.Notifications;


import static androidx.core.app.NotificationManagerCompat.IMPORTANCE_DEFAULT;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.inf1030_tp1.Models.Pharmacy;
import com.example.inf1030_tp1.R;

public class NotificationHelper extends ContextWrapper {

    public static final String results_channel_id = "resultsChannel";
    NotificationManager manager;

    public NotificationHelper(Context base) {
        super(base);
    }

    public void sendResultNotification(Pharmacy pharmacie){
        String title = getResources().getString(R.string.request_channel);
        String content = getResources().getString(R.string.completed_Request);
        // défini comment la notification ressemble lorsqu'elle est affichée
        NotificationCompat.Builder notif = new NotificationCompat.Builder(getApplicationContext(), results_channel_id)
                .setContentTitle(title)
                .setContentTitle(pharmacie.getName() + " " + content)
                .setSmallIcon(R.drawable.ic_baseline_local_pharmacy_24);
        manager.notify(1, notif.build());
    }

    public void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getResources().getString(R.string.request_channel);
            String content = getResources().getString(R.string.request_channel_desc);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(results_channel_id, name, importance);
            channel.setDescription(content);

            // enregistre le channel dans le systeme
            manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }
    }

    // on pourra ensuite faire le meme précédé pour les notifs du pharmacien, il faudra créé un nouveau channel
}

