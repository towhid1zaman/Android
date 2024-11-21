package towhid1zaman.toyproject.simplenoticounter

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import towhid1zaman.toyproject.simplenoticounter.Counter.value

class CounterNotificationReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        val service = CounterNotificationService(context!!)
        service.showNotification(++value)

    }

}