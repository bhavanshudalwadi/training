import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import com.example.service_q_37.R

class MusicService : Service() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.my_music) // Load the music file
        mediaPlayer.isLooping = true // Loop the music continuously
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer.start() // Start playing the music
        return START_STICKY // Ensure that the Service keeps running even if the app is in the background
    }

    override fun onDestroy() {
        mediaPlayer.stop() // Stop playing the music
        mediaPlayer.release() // Release the resources used by the MediaPlayer
        super.onDestroy()
    }
}
