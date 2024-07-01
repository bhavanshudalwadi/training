
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.q14.databinding.Fragment1Binding


class Fragment1 : Fragment() {

    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!

    private var progressBarVisible = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment1Binding.inflate(inflater, container, false)
        val view = binding.root

        binding.imageView.visibility = View.GONE
        binding.button.setOnClickListener {
            toggleProgressBar()
        }

        return view
    }

    private fun toggleProgressBar() {
        if (progressBarVisible) {
            binding.progressBar.visibility = View.GONE
            binding.imageView.visibility = View.GONE
        } else {
            binding.progressBar.visibility = View.VISIBLE
            binding.imageView.visibility = View.VISIBLE
        }
        progressBarVisible = !progressBarVisible
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
