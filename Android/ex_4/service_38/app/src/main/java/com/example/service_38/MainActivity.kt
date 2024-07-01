import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.service_38.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startService(view: android.view.View) {
        val serviceIntent = Intent(this, RandomNumberService::class.java)
        startService(serviceIntent)
        Toast.makeText(this, "Service started", Toast.LENGTH_SHORT).show()
    }

    fun stopService(view: android.view.View) {
        val serviceIntent = Intent(this, RandomNumberService::class.java)
        stopService(serviceIntent)
        Toast.makeText(this, "Service stopped", Toast.LENGTH_SHORT).show()
    }
}
