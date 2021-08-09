package developer.jkey20.composechat

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _inputList = mutableListOf<String>()
    val inputList : List<String> get() = _inputList

    private val _currentInput = mutableStateOf("")
    val currentInput : State<String> get() = _currentInput

    fun addInputList(input : String){
        _inputList.add(input)
    }

    fun changeCurrentInput(input : String){
        _currentInput.value = input
    }

}