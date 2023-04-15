package com.edex.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.edex.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                // A surface container using the 'background' color from the theme
                DiceRolling()
            }
        }
    }
}

@Preview
@Composable
fun DiceRollingApp(){
    DiceRolling(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(align = Alignment.Center))
}

@Composable
fun DiceRolling(modifier: Modifier= Modifier){
    var rolling =1
    val ImageResource = when(rolling){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {


    Image(painter = painterResource(id = ImageResource), contentDescription =rolling.toString() )

    Button(onClick = { rolling= (1..6).random()}) {
        Text(text = stringResource(id = R.string.roll_button))
    }

}
}
