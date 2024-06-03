package com.example.e_motorcycle

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.cardview.widget.CardView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.example.e_motorcycle.ui.theme.EMotorcycleTheme
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val speed=57
        val battery=73
        val temperature=56
        val distance=3.6

        val d_speed="$speed Km/H"
        val d_battery="$battery %"
        val d_temperature="$temperature °C"
        val d_distance="$distance Km"

        val kecepatanTextView: TextView = findViewById(R.id.kecepatan)
        val dayaTextView: TextView = findViewById(R.id.daya)
        val suhuTextView: TextView = findViewById(R.id.suhu)
        val jarakTextView: TextView = findViewById(R.id.jarak)

        kecepatanTextView.text=d_speed
        dayaTextView.text=d_battery
        suhuTextView.text=d_temperature
        jarakTextView.text=d_distance

        val outerCardView: CardView = findViewById(R.id.outerCircle)
        when {
            battery > 75 -> {
                outerCardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.batt_green))
            }
            battery in 51..75 -> {
                outerCardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.batt_yellow))
            }
            else -> {
                outerCardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.batt_red))
            }
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EMotorcycleTheme {
        Greeting("Android")
    }
}

@Composable
fun MainActivityLayout(){

}