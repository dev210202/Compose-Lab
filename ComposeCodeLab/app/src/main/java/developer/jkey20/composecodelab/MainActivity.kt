package developer.jkey20.composecodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import developer.jkey20.composecodelab.ui.theme.ComposeCodeLabTheme

import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCodeLabTheme {
                CodeLab4Container {
                    CodeLab11ExtractDisplay()
                }
            }
        }
    }
}

@Composable
fun CodeLab1Surface(name: String) {
    Surface(color = Color.Yellow) { // Surface를 사용해서배경 설정
        Text(text = "Hello $name!")
    }
}

@Composable
fun CodeLab2Modifier(name: String) {
    Surface(color = Color.Yellow) {
        Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
    }
}

@Composable
fun CodeLab3Reusable() {
    Surface(color = Color.Yellow) {
        ReusableText(name = "android")
    }
}

@Composable
fun ReusableText(name: String) {
    Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
}

@Composable
fun CodeLab4Container(content: @Composable () -> Unit) {
    Surface(color = Color.Yellow) {
        content()
    }

}

@Composable
fun CodeLab5CallingComposableFunctions() {
    Column {
        ReusableText(name = "android")
        Divider(color = Color.Black) // divider로 공간을 분리할 수 있는 수평선을 만들어줌
        ReusableText(name = "there")
    }
}

@Composable
fun CodeLab6ComposeAndKotlin(names: List<String> = listOf("Android", "there")) {
    Column {
        for (name in names) {
            ReusableText(name = name)
            Divider(color = Color.Black)
        }
    }
}

@Composable
fun CodeLab7State() {
    val count = remember { mutableStateOf(0) } // 재구성시에 다른 상태를 가지지않게 remember를 사용해서 상태를 저장

    Button(onClick = { count.value++ }) {
        Text("Clicked ${count.value}")
    }
}

@Composable
fun CodeLab8StateApply(names: List<String> = listOf("Android", "there")) {
    Column {
        for (name in names) {
            ReusableText(name = name)
            Divider(color = Color.Black)
        }
        Divider(color = Color.Transparent, thickness = 64.dp)
        CodeLab7State()
    }
}

@Composable
fun CodeLab9StateHoisting(names: List<String> = listOf("Android", "there")) {
    val counterState = remember { mutableStateOf(0) }

    Column {
        for (name in names) {
            ReusableText(name = name)
            Divider(color = Color.Black)
        }
        Divider(color = Color.Transparent, thickness = 64.dp)
        CodeLab9Counter(
            count = counterState.value,
            updateCount = { newCount ->
                counterState.value = newCount
            }
        )
    }
}

@Composable
fun CodeLab9Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(onClick = { updateCount(count + 1) }) {
        Text("clicked $count")
    }
}

@Composable
fun CodeLab10FlexibleLayout(names: List<String> = listOf("Android", "there")) {
    val counterState = remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxHeight()) {
        Column(modifier = Modifier.weight(1f)) {
            for (name in names) {
                ReusableText(name = name)
                Divider(color = Color.Black)
            }
        }
        CodeLab10Counter(
            count = counterState.value,
            updateCount = { newCount ->
                counterState.value = newCount
            }
        )
    }
}

@Composable
fun CodeLab10Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(
        onClick = { updateCount(count + 1) },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (count > 5) Color.Green else Color.White
        )
    ) {
        Text("clicked $count")
    }
}

@Composable
fun CodeLab11ListExtract(names: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {   // LazyColumn을 사용하여 세로로 스크롤되는 목록을 생성
        items(items = names) { name ->
            AnimationText(name = name)
            Divider(color = Color.Black)
        }

    }
}

@Composable
fun CodeLab11ExtractDisplay(names: List<String> = List(1000) { "Hello Android #$it" }) {
    val counterState = remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxHeight()) {
        CodeLab11ListExtract(names = names, modifier = Modifier.weight(1f))
        CodeLab10Counter(
            count = counterState.value,
            updateCount = { newCount ->
                counterState.value = newCount
            }
        )
    }
}

@Composable
fun AnimationText(name: String) {
    var isSelected by remember { mutableStateOf(false) }
    val backgroundColor by animateColorAsState(
        if (isSelected) {
            Color.Red
        } else {
            Color.Transparent
        }
    )

    Text(
        text= "Hello $name!",
        modifier = Modifier
            .padding(24.dp)
            .background(color= backgroundColor)
            .clickable(onClick = {isSelected = !isSelected})
    )

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeCodeLabTheme {
        CodeLab9StateHoisting()
    }
}