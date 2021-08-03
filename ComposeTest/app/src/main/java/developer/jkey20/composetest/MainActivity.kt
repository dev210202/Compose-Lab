package developer.jkey20.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import developer.jkey20.composetest.ui.theme.ComposeTestTheme


/*
Compose basic 코스를 따라해봅니다.
https://developer.android.com/jetpack/compose/tutorial?hl=ko&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%3Fhl%3Dko%23article-https%3A%2F%2Fdeveloper.android.com%2Fjetpack%2Fcompose%2Ftutorial

 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {        // setContent로 view를 보여줌
            ComposeTestTheme { // 프로젝트명으로 테마가 자동생성됨. 테마는
                MaterialPractice3Style()
            }
        }
    }
}

@Composable // @Composable 주석을 사용하여 Composable 함수를 정의
fun TextPractice1PrintText() {
    Text("practice 1 : 단순 텍스트 출력")
}

@Composable
fun TextPractice2ColumnRowText() {
    Column { // Column을 사용하면 vertical로 정렬됨
        Text("practice 2: 텍스트 vertical 정렬1")
        Text("practice 2: 텍스트 vertical 정렬2")
        Text("practice 2: 텍스트 vertical 정렬3")
        Row { // Row 사용하면 horizontal로 정렬됨
            Text("row 정렬1")
            Text("row 정렬2")
            Text("row 정렬3")
            Text("row 정렬4")
            Text("row 정렬5")
        }
    }
}

@Composable
fun TextPractice3PaddingText() {
    Column(Modifier.padding(24.dp)) {       // modifier를 사용해서 레이아웃을 설정하도록 함
        Text("practice3: Padding1")
        Text("practice3: Padding2")
        Text("practice3: Padding3")
    }
}

@Composable
fun ImagePractice1PrintImage() {
    Image(
        painter = painterResource(id = R.drawable.image),
        contentDescription = null
    )
}

@Composable
fun ImagePractice2ModifyImage() {
    Image(
        painter = painterResource(id = R.drawable.image),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        contentScale = ContentScale.Crop // 적절한 높이를 설정하기 위해서 필요하다면 잘리게 설정

    )

}

@Composable
fun ImagePractice3Spacer() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp)) // 빈 공간을 만들어줌
        Text("고요속의 타오름")
    }
}

@Composable
fun MaterialPractice1Clip() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(shape = RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun MaterialPractice2ApplyMaterialTheme() {
    Column {
        MaterialTheme {
            Text("Apply Material")
        }
        Text("not Apply Material")
    }

}

@Composable
fun MaterialPractice3Style() {
    Column {
        MaterialTheme {
            Text(
                "Apply Material style h1",
                style = MaterialTheme.typography.h1
            ) // style로 MaterialTheme의 스타일 적용
            Text(
                "Apply Material style h1 long",
                style = MaterialTheme.typography.h1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            ) // maxLine으로 표시되는 최대 줄 수 설정, overflow로 텍스트가 줄을 넘길때 처리
            Text("Apply Material style body2", style = MaterialTheme.typography.body2)
        }
        Text("not Apply Material")
    }
}


@Composable
fun MainView() {

}


@Composable
fun MaterialTitleText() { // material 폰트를 Text에 적용해본다.

    Text("링크를 입력해주세요", modifier = Modifier.padding(start = 24.dp))

}


@Preview // @Preview 주석을 사용하여 미리보기.
@Composable
fun Preview() {
    MaterialPractice3Style()
}