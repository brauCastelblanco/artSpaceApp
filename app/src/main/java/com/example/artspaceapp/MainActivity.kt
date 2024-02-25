package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
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
fun ArtSpaceApp(){
    var currentStep by remember { mutableStateOf(1) }
    when(currentStep){
        1 -> {
            ArtSpace(
                image = R.drawable.pexels_diego_gonzalez_13360379,
                imageName = R.string.pic1,
                author = R.string.pic1_author,
                onPreviousClick = {
                    currentStep = 3
                        },
                onNextClick = {
                    currentStep = 2
                        }
            )
        }
        2 -> {
            ArtSpace(
                image = R.drawable.pexels_gustavo_solmott_16808476,
                imageName = R.string.pic2,
                author = R.string.pic2_author,
                onPreviousClick = {
                    currentStep = 1
                    },
                onNextClick = {
                    currentStep = 3
                    }
                )
            }
        3 ->{
            ArtSpace(
                image = R.drawable.pexels_nubia_navarro__nubikini__6381088,
                imageName = R.string.pic3,
                author = R.string.pic3_author,
                onPreviousClick = {
                    currentStep = 2
                        },
                onNextClick = {
                    currentStep = 1
                        }
                    )
            }
    }

}


@Composable
fun ArtSpace(
    image: Int,
    imageName: Int,
    author: Int,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val MyCustomColor = Color(0xFFF4EFF8)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Surface(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            shape = RectangleShape,
            shadowElevation = 15.dp


        ) {
            Image(
                modifier = Modifier.padding(30.dp),
                painter = painterResource(id = image),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .background(MyCustomColor)){
            Text(text = stringResource(id = imageName))
            Text(text = stringResource(id = author))
        }
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                modifier = Modifier.size(140.dp, 40.dp),
                onClick = onPreviousClick
            ) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                modifier = Modifier.size(140.dp, 40.dp),
                onClick = onNextClick
            ) {
                Text(text = "Next")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}