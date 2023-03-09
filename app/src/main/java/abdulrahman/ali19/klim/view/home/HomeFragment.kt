package abdulrahman.ali19.klim.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import abdulrahman.ali19.klim.R
import abdulrahman.ali19.klim.basic.BaseFragment
import abdulrahman.ali19.klim.view.home.viewmodel.HomeViewModel

class HomeFragment : BaseFragment() {

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}