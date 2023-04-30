package com.example.tiptime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tiptime.ui.theme.TipTimeTheme
import java.io.StringReader

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipTimeTheme {
                Surface(){
                   TipTimeScreen()
                }

            }
        }
    }
}


@Composable
fun TipTimeScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier.padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

    }


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TipTimeTheme {
       TipTimeScreen()
    }
}