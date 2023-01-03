package umc_android.week07.standardmission

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import umc_android.week07.standardmission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var started = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            started = true

            var timer = Integer.parseInt(binding.etTimer.text.toString())
            val handler = Handler(mainLooper)

            Thread() {
                while (started) {
                    if (timer == 0) {
                        started = false

                        // noti
                        var intent = Intent(this, NotiActivity::class.java)
                        intent.flags =
                            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                        var pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

                        val builder = NotificationCompat.Builder(this, "MY_CHANNEL")
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("TIMER")
                            .setContentText("TIME OUT")
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                            .addAction(R.drawable.ic_launcher_foreground, "noti", pendingIntent)
                            .setAutoCancel(true)

                        val notificationManager = NotificationManagerCompat.from(this)
                        val notificationId = 100
                        notificationManager.notify(notificationId, builder.build())

                    } else {
                        timer--;
                    }

                    handler.post {
                        binding.etTimer.setText(timer.toString())
                    }
                    Thread.sleep(1000)
                }
            }.start()
        }

        fun createNotificationChannel() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = getString(R.string.channel_name)
                val description = getString(R.string.channel_description)
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                var channel = NotificationChannel(getString(R.string.CHANNEL_ID), name, importance)
                channel.description = description

                var notificationManager = getSystemService(NotificationManager::class.java)
                notificationManager.createNotificationChannel(channel)
            }
        }

    }
}