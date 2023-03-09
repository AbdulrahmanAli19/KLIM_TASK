package abdulrahman.ali19.klim.view.home.viewmodel

import abdulrahman.ali19.klim.data.repo.HomeRepo
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    homeRepo: HomeRepo
) : ViewModel(){

}