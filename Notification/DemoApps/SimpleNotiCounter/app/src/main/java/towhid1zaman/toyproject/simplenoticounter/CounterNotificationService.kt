package towhid1zaman.toyproject.simplenoticounter

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.getSystemService


class CounterNotificationService(private val context: Context) {
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification(counter: Int) {
        val activityIntent = Intent(context, MainActivity::class.java)
        val activityPendingIntent = PendingIntent.getActivity(
             context,
            1,
            activityIntent,
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )
        val incremnetIntent = PendingIntent.getBroadcast(
            context, 2,
            Intent(context, CounterNotificationReceiver::class.java).apply {
                putExtra("my_extra", 5)
            },
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )
        val notification = NotificationCompat.Builder(context, COUNTER_CHANNEL_ID)
            .setSmallIcon(R.drawable.baseline_baby_changing_station_24)
            .setContentTitle("Inreament Counter")
            .setContentText("The count is $counter")
            .setContentIntent(activityPendingIntent)
            .addAction(
                R.drawable.baseline_baby_changing_station_24,
                "Incremnet",
                incremnetIntent
                )
            .build()

        notificationManager.notify(1, notification)
    }

    companion object{
        const val COUNTER_CHANNEL_ID = "counter_channel"
    }
}