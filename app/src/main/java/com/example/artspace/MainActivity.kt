package com.example.artspace

import android.graphics.Paint
import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    var imageResource = when(result) {
        1 -> R.drawable.screenshot_2023_05_13_105237
        else -> R.drawable.screenshot_2023_05_13_105328
    }
    var imageContent = when(result) {
        1 -> R.string.contentImage_1
        else -> R.string.contentImage_2
    }
    var artworkTitle = when(result) {
        1 -> R.string.artwork_title_1
        else -> R.string.artwork_title_2
    }
    var artistName = when(result) {
        1 -> R.string.artist_name_1
        else -> R.string.artist_name_2
    }
    var year = when(result) {
        1 -> R.string.year_1
        else -> R.string.year_2
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    modifier = modifier)
    {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = stringResource(id = imageContent),
            modifier = modifier
                .padding(20.dp)
                .size(500.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = modifier.height(25.dp))
        Column(
            modifier = modifier
                .padding(50.dp)
                .background(Color.Cyan)
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(
                text = stringResource(id = artworkTitle),
                fontSize = 20.sp,
                textAlign = TextAlign.Left
            )
            Row(modifier = modifier)
            {
                Text(
                    text = stringResource(id = artistName),
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
                Text(
                    text = stringResource(id = year),
                    fontSize = 12.sp
                )
            }
        }

        Spacer(modifier = modifier.height(30.dp))



        Row(modifier = modifier) {
            Button(
                onClick = {
                    result = 2
                },

                ) {
                Text(text = stringResource(id = R.string.prev_button))
            }
            Spacer(modifier = modifier.width(200.dp))
            Button(
                onClick = {
                    result = 1
                },
            ) {
                Text(text = stringResource(id = R.string.next_button))
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}