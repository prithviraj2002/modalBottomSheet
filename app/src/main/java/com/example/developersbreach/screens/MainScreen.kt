@file:OptIn(ExperimentalMaterialApi::class)

package com.example.developersbreach.screens

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.developersbreach.widgets.BottomSheetContent
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun ModalSheetLayout() {
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,

        //code to add animation
//        animationSpec = spring(
//            dampingRatio = Spring.DampingRatioHighBouncy
//        )
    )

    val showModalSheet = rememberSaveable {
        mutableStateOf(false)
    }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {
            BottomSheetContent()
    }){
        ModalSheetWithAnchor(sheetState, showModalSheet)
    }
}

@Composable
fun ModalSheetWithAnchor(sheetState: ModalBottomSheetState, showModalSheet: MutableState<Boolean>) {

    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()){
        Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = "",
            modifier = Modifier
                .clickable {
                    showModalSheet.value = !showModalSheet.value
                    scope.launch {
                        sheetState.show()
                    }
                }
                .align(alignment = Alignment.BottomCenter),)
    }
}