package com.example.birthdaycard

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdaycard.ui.theme.BirthdayCardTheme
import org.intellij.lang.annotations.JdkConstants.BoxLayoutAxis

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ) {
                }
            }

            BirthdayGreetingWithImage(stringResource(R.string.main_message), stringResource(R.string.main_from))
        }


    }
}

@Composable
fun BirthdayGreetingWithText(message:String,from:String,modifier: Modifier=Modifier){

    Column(modifier=modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text=message, fontSize = 36.sp,modifier=Modifier.padding(top=16.dp))
        Text(text = from, fontSize = 24.sp,modifier= Modifier
            .padding(top = 16.dp, end = 16.dp)
            .align(alignment = Alignment.End))

    }






}

@Composable
fun BirthdayGreetingWithImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(content = {
        BirthdayGreetingWithText(message = message, from =from )
    })
    Image(painter = image, contentDescription = null,modifier=modifier, contentScale = ContentScale.Crop)


}


@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    BirthdayCardTheme {
        BirthdayGreetingWithImage(stringResource(R.string.main_message), stringResource(R.string.main_from))
    }
}