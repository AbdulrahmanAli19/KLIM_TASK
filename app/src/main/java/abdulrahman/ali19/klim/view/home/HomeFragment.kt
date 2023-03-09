package abdulrahman.ali19.klim.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import abdulrahman.ali19.klim.basic.BaseFragment
import abdulrahman.ali19.klim.basic.ResultState
import abdulrahman.ali19.klim.databinding.FragmentHomeBinding
import abdulrahman.ali19.klim.view.home.viewmodel.HomeViewModel
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.launch

class HomeFragment() : BaseFragment() {

    override var _baseBinding: ViewBinding? = binding
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleResponse()
    }

    private fun handleResponse() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.dinosaursState.collect { res ->
                    when (res) {
                        is ResultState.Success -> {
                            showData()
                        }
                        else -> showDialog(res)
                    }
                }
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        _baseBinding = null
    }
}