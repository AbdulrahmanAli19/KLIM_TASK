package abdulrahman.ali19.klim.basic

sealed class ResultState<out R> {

    object Loading : ResultState<Nothing>()

    object EmptyResult : ResultState<Nothing>()

    data class Error(val errorString: String) : ResultState<Nothing>()

    data class Success<T>(val data: T) : ResultState<T>()
}