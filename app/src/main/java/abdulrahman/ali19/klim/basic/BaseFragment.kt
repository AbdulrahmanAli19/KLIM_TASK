package abdulrahman.ali19.klim.basic

import abdulrahman.ali19.klim.R
import abdulrahman.ali19.klim.data.pojo.DinosaurResponse
import abdulrahman.ali19.klim.databinding.DialogLayoutBinding
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseFragment : Fragment() {

    var _baseBinding: ViewBinding? = null
    open val retryBtn: () -> Unit = {}
    private var dialog: AlertDialog? = null

    fun showData() {
        _baseBinding?.root?.isVisible = true
        dialog?.dismiss()
    }

    fun showDialog(res: ResultState<List<DinosaurResponse>>) {
        _baseBinding?.root?.isVisible = false

        val builder = AlertDialog.Builder(requireContext(), R.style.alert_dialog_theme)
        val binding = DialogLayoutBinding.inflate(LayoutInflater.from(requireContext()))
        builder.setView(binding.root)
        dialog = builder.create()

        dialog?.window?.apply {
            setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT
            )
            setBackgroundDrawable(ColorDrawable(Color.WHITE))
            setGravity(Gravity.CENTER)
        }


        when (res) {
            ResultState.EmptyResult -> {
                binding.message.text = getString(R.string.no_data)
                binding.retryBtn.isVisible = true
                binding.message.isVisible = true
                binding.progressCircular.isVisible = false
                binding.retryBtn.setOnClickListener { retryBtn() }
            }
            is ResultState.Error -> {
                binding.message.text = res.errorString
                binding.retryBtn.isVisible = true
                binding.message.isVisible = true
                binding.progressCircular.isVisible = false
                binding.retryBtn.setOnClickListener { retryBtn() }
            }
            ResultState.Loading -> {
                binding.progressCircular.isVisible = true
                binding.retryBtn.isVisible = false
                binding.image.isVisible = false
            }
            else -> {}
        }
        dialog?.show()
    }

}