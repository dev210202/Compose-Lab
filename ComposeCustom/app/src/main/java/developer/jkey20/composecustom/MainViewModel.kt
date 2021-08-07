package developer.jkey20.composecustom

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _inputList = mutableStateListOf<String>()
    val inputList : List<String> get() = _inputList
    private val _currentInput = mutableStateOf("")
    val currentInput : State<String> get()= _currentInput

    fun addInput(input : String){
        _inputList.add(input)
    }
    fun changeCurrentInput(input :String){
        _currentInput.value = input
    }

}