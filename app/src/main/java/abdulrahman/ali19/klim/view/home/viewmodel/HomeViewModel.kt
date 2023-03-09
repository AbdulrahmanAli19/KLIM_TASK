package abdulrahman.ali19.klim.view.home.viewmodel

import abdulrahman.ali19.klim.basic.ResultState
import abdulrahman.ali19.klim.data.pojo.DinosaurResponse
import abdulrahman.ali19.klim.domain.usecase.GetDinosaurUseCase
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dinosaurUseCase: GetDinosaurUseCase
) : ViewModel() {

    val dinosaursState: Flow<ResultState<List<DinosaurResponse>>>
        get() = dinosaurUseCase()
}