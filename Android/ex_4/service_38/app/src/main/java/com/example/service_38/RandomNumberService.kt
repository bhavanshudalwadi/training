import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.util.*

class RandomNumberService : Service() {

    private val binder = RandomNumberBinder()
    private val random = Random()

    inner class RandomNumberBinder : Binder() {
        fun getService(): RandomNumberService {
            return this@RandomNumberService
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    fun getRandomNumber(): Int {
        return random.nextInt(100)
    }
}
