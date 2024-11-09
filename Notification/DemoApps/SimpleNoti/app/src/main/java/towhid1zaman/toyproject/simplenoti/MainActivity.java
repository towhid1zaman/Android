package towhid1zaman.toyproject.simplenoti;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

    /**
     *  For display notification need 3 things,
     *      1. Notification channel
     *      2. Notification Builder
     *      3. Notification Manager
     *
     *      Again, for Notification channel, need 3 things,
     *          1. Channel ID
     *          2. Channel Name
     *          3. Channel Description
     *
     * */

    private static final String CHANNEL_ID = "Simple_Noti";
    private static final String CHANNEL_NAME = "Simple Notification";
    private static final String CHANNEL_DESC = "Simple Android Notifications";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription(CHANNEL_DESC);

        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel);

        findViewById(R.id.buttonNotify).setOnClickListener(v -> displayNotification());
    }
    
    private void displayNotification() {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this,CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_notication)
                        .setContentTitle("Yes!! This is working..")
                        .setContentText("Your First Notification")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat mNotificationMgr = NotificationManagerCompat.from(this);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
            mNotificationMgr.notify(1, mBuilder.build());
        }
    }

}