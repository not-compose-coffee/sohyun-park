package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                ComposeQuadrantApp(
                    firstTitle = stringResource(R.string.first_title),
                    firstDescription = stringResource(R.string.first_description),
                    secondTitle = stringResource(R.string.second_title),
                    secondDescription = stringResource(R.string.second_description),
                    thirdTitle = stringResource(R.string.third_title),
                    thirdDescription = stringResource(R.string.third_description),
                    fourthTitle = stringResource(R.string.fourth_title),
                    fourthDescription = stringResource(R.string.fourth_description)
                )
            }
        }
    }
}

@Composable
fun ComposeQuadrantApp(
    modifier: Modifier = Modifier,
    firstTitle: String,
    firstDescription: String,
    secondTitle: String,
    secondDescription: String,
    thirdTitle: String,
    thirdDescription: String,
    fourthTitle: String,
    fourthDescription: String
) {
    Column(
    ) {
        Row(
            modifier = modifier
                .fillMaxSize()
                .weight(1f)
        ) {

            ComposableInfoCard(
                title = firstTitle,
                description = firstDescription,
                backgroundColor = Color.Green,
                Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = secondTitle,
                description = secondDescription,
                backgroundColor = Color.Yellow,
                Modifier.weight(1f)
            )

        }
        Row(
            modifier = modifier
                .fillMaxSize()
                .weight(1f)
        ) {

            ComposableInfoCard(
                title = thirdTitle,
                description = thirdDescription,
                backgroundColor = Color.Cyan,
                Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = fourthTitle,
                description = fourthDescription,
                backgroundColor = Color.LightGray,
                Modifier.weight(1f)
            )

        }

    }
}

@Composable
private fun ComposableInfoCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantApp(
        firstTitle = stringResource(R.string.first_title),
        firstDescription = stringResource(R.string.first_description),
        secondTitle = stringResource(R.string.second_title),
        secondDescription = stringResource(R.string.second_description),
        thirdTitle = stringResource(R.string.third_title),
        thirdDescription = stringResource(R.string.third_description),
        fourthTitle = stringResource(R.string.fourth_title),
        fourthDescription = stringResource(R.string.fourth_description)
    )
}