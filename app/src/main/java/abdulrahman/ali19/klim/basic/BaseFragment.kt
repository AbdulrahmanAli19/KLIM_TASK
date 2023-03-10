package abdulrahman.ali19.klim.basic

import abdulrahman.ali19.klim.R
import abdulrahman.ali19.klim.data.pojo.DinosaurResponse
import abdulrahman.ali19.klim.databinding.DialogLayoutBinding
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseFragment : Fragment() {

    private var rootView: View? = null

    private var dialog: AlertDialog? = null

    open val retryBtn: () -> Unit = {
        dialog?.dismiss()
        dialog = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rootView = view
    }

    fun showDialog(res: ResultState<List<DinosaurResponse>>) {
        rootView?.isVisible = false

        val binding = DialogLayoutBinding.inflate(LayoutInflater.from(requireContext()))

        when (res) {
            is ResultState.Error, ResultState.EmptyResult -> {
                val errorMsg =
                    if (res is ResultState.Error) res.errorString else getString(R.string.no_data)
                binding.apply {
                    message.text = errorMsg
                    message.isVisible = true
                    image.isVisible = true
                    retryBtn.isVisible = true
                    progressCircular.isVisible = false
                    retryBtn.setOnClickListener { retryBtn() }
                }
            }
            ResultState.Loading -> {
                binding.apply {
                    progressCircular.isVisible = true
                    retryBtn.isVisible = false
                    image.isVisible = false
                    message.isVisible = false
                }
            }
            else -> Unit
        }

        dialog?.dismiss()
        dialog = null

        AlertDialog
            .Builder(requireContext(), R.style.alert_dialog_theme)
            .apply {
                setView(binding.root)
                dialog = create()
            }


        dialog?.window?.apply {
            setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT
            )
            setDimAmount(0f)
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setGravity(Gravity.CENTER)

        }

        dialog?.show()
    }

    fun showData() {
        rootView?.isVisible = true
        dialog?.dismiss()
        dialog = null
    }

}