package developer.jkey20.composechat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import developer.jkey20.composechat.ui.theme.ComposeChatTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeChatTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Screen()
                }
            }
        }
    }

    @Composable
    fun ChatImage() {

    }

    @Composable
    fun ChatBallon() {

    }

    @Composable
    fun InputButton() {

    }

    @Composable
    fun ChatContent(
        item: String
    ) {

    }

    @Composable
    fun BottomLayout(
        modifier: Modifier,
        text: String,
        onChangeCurrentInput: (String) -> Unit
    ) {
        Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
            IconButton(
                modifier = Modifier.padding(start = 8.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(32.dp)),
                onClick = { /*TODO*/ }

            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = null)
            }
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = text,
                onValueChange = { onChangeCurrentInput(it) },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    placeholderColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                trailingIcon = {
                    IconButton(onClick = { /*TODO*/ },  modifier = Modifier.padding(end = 8.dp)
                        .background(color = Color.Magenta, shape = RoundedCornerShape(32.dp))
                    ) {
                        Icon(imageVector = Icons.Outlined.Send, contentDescription = null)
                    }
                }

            )
        }
    }


    @Composable
    fun Screen() {
        val lightBlue = Color(red = 248, green = 248, blue = 248)
        Column {
            LazyColumn(modifier = Modifier.weight(9f)) {
                items(items = viewModel.inputList) { item ->
                    ChatContent(item)
                }
            }
            Divider(color = Color.Black, modifier = Modifier.padding(16.dp))
            BottomLayout(
                modifier = Modifier
                    .weight(1f)
                    .background(color = lightBlue, shape = RoundedCornerShape(30.dp))
                    .fillMaxWidth(),
                text = viewModel.currentInput.value,
                onChangeCurrentInput = viewModel::changeCurrentInput
            )
        }

    }
}



