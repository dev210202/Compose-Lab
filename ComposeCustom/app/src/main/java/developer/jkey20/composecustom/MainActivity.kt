package developer.jkey20.composecustom

import android.os.Bundle
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
import developer.jkey20.composecustom.ui.theme.ComposeCustomTheme

class MainActivity : ComponentActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCustomTheme {
                Surface(color = MaterialTheme.colors.background) {
                    BodyContent(mainViewModel)
                }
            }
        }
    }
}

@Composable
fun TextField(
    currentInput: String,
    onChangeCurrentInput: (String) -> Unit,
    modifier: Modifier
) {
    OutlinedTextField(value = currentInput, onValueChange = {
        onChangeCurrentInput(it)
    }, modifier = modifier)
}

@Composable
fun AddButton(
    currentInput: String,
    onAddItem: (String) -> Unit,
    modifier: Modifier
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
            }
        }

        Divider(color = Color.Black, modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))

        TextField(currentInput, onChangeCurrentInput, modifier = Modifier.fillMaxWidth())
        AddButton(currentInput, onAddItem, modifier = Modifier.fillMaxWidth())
    }
}


@Composable
fun BodyContent(viewModel: MainViewModel) {
    Screen(
        items = viewModel.inputList,
        currentInput = viewModel.currentInput.value,
        onAddItem = viewModel::addInput,
        onChangeCurrentInput = viewModel::changeCurrentInput
    )
}
