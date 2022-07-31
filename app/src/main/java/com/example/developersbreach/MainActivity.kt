package com.example.developersbreach

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.developersbreach.screens.BottomSheetWithAnchor
import com.example.developersbreach.screens.ModalSheetLayout
import com.example.developersbreach.ui.theme.DevelopersBreachTheme

@OptIn(ExperimentalMaterialApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevelopersBreachTheme {
                // A surface container using the 'background' color from the theme
                BottomSheetWithAnchor()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DevelopersBreachTheme {

    }
}