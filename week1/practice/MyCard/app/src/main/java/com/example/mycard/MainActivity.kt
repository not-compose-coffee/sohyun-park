package com.example.mycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycard.ui.theme.MyCardTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCardTheme {
                MyCardApp()
            }
        }
    }
}

@Composable
fun MyCardApp() {

    MyCardScreen(
        imagePainter = painterResource(R.drawable.ic_android),
        fullName = stringResource(R.string.full_name),
        title = stringResource(R.string.title),
        phoneNumber = stringResource(R.string.phone_number),
        gitHubId = stringResource(R.string.git_hub_id),
        emailAddress = stringResource(R.string.email_address)
    )

}

@Composable
fun MyCardScreen(
    modifier: Modifier = Modifier,
    imagePainter: Painter,
    fullName: String,
    title: String,
    phoneNumber: String,
    gitHubId: String,
    emailAddress: String
) {


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(R.color.navy)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(painter = imagePainter, contentDescription = "image", Modifier.size(100.dp))
        Text(
            text = fullName,
            color = colorResource(R.color.white),
            fontSize = 50.sp,
            fontWeight = FontWeight.Light
        )
        Text(
            text = title,
            color = Color(0xFF3ddc84),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = modifier.fillMaxHeight(0.3f))

    }


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {


        detail(
            imagePainter = painterResource(R.drawable.ic_phone),
            information = phoneNumber
        )

        detail(
            imagePainter = painterResource(R.drawable.ic_share),
            information = gitHubId
        )

        detail(
            imagePainter = painterResource(R.drawable.ic_mail),
            information = emailAddress
        )

    }
}


@Composable
fun detail(modifier: Modifier = Modifier, imagePainter: Painter, information: String) {

    Divider(color = colorResource(R.color.gray))
    Row(
        modifier = modifier.fillMaxWidth(0.7f),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = imagePainter,
            contentDescription = "icon",
            modifier.padding(top = 10.dp, bottom = 10.dp, end = 20.dp)
        )
        Text(text = information, color = colorResource(R.color.white))
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyCardTheme {

        MyCardApp()

    }
}