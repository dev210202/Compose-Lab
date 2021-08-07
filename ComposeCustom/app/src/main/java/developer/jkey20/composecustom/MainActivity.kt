package developer.jkey20.composecustom

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.font.FontWeight.Companion.Black
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import developer.jkey20.composecustom.ui.theme.ComposeCustomTheme

class MainActivity : ComponentActivity() {
    private val mainViewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCustomTheme {
                Surface(color = MaterialTheme.colors.background) {
                    BodyContent()
                }
            }
        }
    }

    @Composable
    fun TextField(
        modifier: Modifier = Modifier,
        currentInput: String,
        onChangeCurrentInput: (String) -> Unit,

        ) {
        OutlinedTextField(
            modifier = modifier,
            value = currentInput,
            onValueChange = {
                onChangeCurrentInput(it)
            }
        )
    }

    @Composable
    fun AddButton(
        modifier: Modifier = Modifier,
        currentInput: String,
        onAddItem: (String) -> Unit,

        ) {
        Button(onClick = {
            onAddItem(currentInput)
        }, modifier = modifier) {
            Text("ADD")
        }

    }

    @Composable
    fun Screen(
        items: List<String>,
        currentInput: String,
        onAddItem: (String) -> Unit,
        onChangeCurrentInput: (String) -> Unit
    ) {
        Column {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                items(items = items) { item ->
                    Text(text = item)
                    Log.i("item :", item)
                }
            }

            Divider(color = Color.Black, modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))

            TextField(modifier = Modifier.fillMaxWidth(), currentInput, onChangeCurrentInput)
            AddButton(modifier = Modifier.fillMaxWidth(), currentInput, onAddItem)
        }
    }


    @Composable
    fun BodyContent() {

        Screen(
            items = mainViewModel.inputList,
            currentInput = mainViewModel.currentInput.value,
            onAddItem = mainViewModel::addInput,
            onChangeCurrentInput = mainViewModel::changeCurrentInput
        )
    }

}

