package com.example.artgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artgallery.ui.theme.ArtGalleryTheme

const val IMAGE_QUANTITY = 8;

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtGalleryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp() {
    var imageIndex by remember {mutableStateOf(0)};

    Column(
        modifier = Modifier.padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(elevation = 10.dp, border = BorderStroke(5.dp, Color.Gray)) {
            getImage(imageIndex);
        }
        Surface(elevation = 10.dp, border = BorderStroke(3.dp, Color.Black)) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = getText(imageIndex = imageIndex),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(6.dp)
                )
                Text(text = "Taken By: Alec Currie", modifier = Modifier.padding(7.dp))
            }
        }
        Row(modifier = Modifier.padding(10.dp)) {
            Button(
                onClick = {
                    if (imageIndex == 0) imageIndex = IMAGE_QUANTITY
                    else imageIndex--
                }, modifier = Modifier.width(100.dp)
            ) {
                Text("Previous")
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Button(
                onClick = {
                    if (imageIndex == IMAGE_QUANTITY) imageIndex = 0
                    else imageIndex++
                }, modifier = Modifier.width(100.dp)
            ) {
                Text("Next")
            }
        }
        Text(text = "All photos were taken in the game Surviving Mars", fontSize = 8.sp)
    }
}

@Composable
fun getImage(imageIndex: Int) {
    return when (imageIndex) {
        0 -> Image(painter = painterResource(R.drawable.screenshot0000), contentDescription = "0")
        1 -> Image(painter = painterResource(R.drawable.screenshot0001), contentDescription = "1")
        2 -> Image(painter = painterResource(R.drawable.screenshot0003), contentDescription = "2")
        3 -> Image(painter = painterResource(R.drawable.screenshot0004), contentDescription = "3")
        4 -> Image(painter = painterResource(R.drawable.screenshot0005), contentDescription = "4")
        5 -> Image(painter = painterResource(R.drawable.screenshot0006), contentDescription = "5")
        6 -> Image(painter = painterResource(R.drawable.screenshot0007), contentDescription = "6")
        7 -> Image(painter = painterResource(R.drawable.screenshot0008), contentDescription = "7")
        else -> Image(
            painter = painterResource(R.drawable.screenshot0009),
            contentDescription = "8"
        )
    }
}

@Composable
fun getText(imageIndex: Int): String {
    return when (imageIndex) {
        0 -> stringResource(R.string.img0_name);
        1 -> stringResource(R.string.img1_name)
        2 -> stringResource(R.string.img2_name)
        3 -> stringResource(R.string.img3_name)
        4 -> stringResource(R.string.img4_name)
        5 -> stringResource(R.string.img5_name)
        6 -> stringResource(R.string.img6_name)
        7 -> stringResource(R.string.img7_name)
        else -> stringResource(R.string.img8_name)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtGalleryTheme {
        MainApp();
    }
}