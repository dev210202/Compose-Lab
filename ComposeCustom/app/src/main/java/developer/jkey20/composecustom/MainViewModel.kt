package developer.jkey20.composecustom

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var inputList = mutableStateListOf<String>()
    var currentInput = mutableStateOf<String>("")

    fun addInput(input : String){
        inputList.add(input)
    }
    fun changeCurrentInput(input :String){
        currentInput.value = input
    }
}