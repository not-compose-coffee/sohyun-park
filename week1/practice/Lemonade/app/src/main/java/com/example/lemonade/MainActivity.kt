package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeApp(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
) {

    var result by remember {
        mutableStateOf(1)
    }

    val imageResource = when (result) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_squeeze
        4 -> R.drawable.lemon_squeeze
        5 -> R.drawable.lemon_squeeze
        6 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val imageDescription = when (result) {
        1 -> R.string.lemon_tree
        2 -> R.string.lemon
        3 -> R.string.lemon
        4 -> R.string.lemon
        5 -> R.string.lemon
        6 -> R.string.lemon_tree
        else -> R.string.empty_glass
    }

    val text = when (result) {
        1 -> R.string.tap_the_lemon_tree_to_select_a_lemon
        2 -> R.string.keep_tapping_the_lemon_to_squeeze_it
        3 -> R.string.keep_tapping_the_lemon_to_squeeze_it
        4 -> R.string.keep_tapping_the_lemon_to_squeeze_it
        5 -> R.string.keep_tapping_the_lemon_to_squeeze_it
        6 -> R.string.tap_the_lemonade_to_drink_it
        else -> R.string.tap_the_empty_glass_to_start_again

    }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = stringResource(text), fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .wrapContentSize(Alignment.Center)
                .border(
                    width = 2.dp,
                    shape = RoundedCornerShape(4.dp),
                    color = Color(105, 205, 216)
                )
                .clickable {
                    result = when (result) {
                        1 -> (2..4).random()
                        2 -> 3
                        3 -> 4
                        4 -> 5
                        5 -> 6
                        6 -> 7
                        else -> 1
                    }
                }
        ) {

            Image(
                painter = painterResource(imageResource),
                contentDescription = imageDescription.toString()
            )

        }

    }


}


@Preview
@Composable
fun LemonadePreview() {

    LemonadeApp()

}