package abdulrahman.ali19.klim.basic

import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment : Fragment() {

    abstract var _baseBinding: ViewBinding?

    fun showLoading() {
        _baseBinding?.root?.isVisible = false
    }

    fun showData(){
        _baseBinding?.root?.isVisible = true
    }


}