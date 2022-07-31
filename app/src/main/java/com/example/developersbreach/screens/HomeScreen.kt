@file:OptIn(ExperimentalMaterialApi::class)

package com.example.developersbreach.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.developersbreach.widgets.BottomSheetContent
import kotlinx.coroutines.launch

@Composable
fun BottomSheetWithAnchor(){

    val sheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)

    val sheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )
    val scope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = sheetScaffoldState,
        sheetElevation = 0.dp,
        sheetBackgroundColor = Color.Transparent,
        sheetPeekHeight = 49.dp,
        sheetContent = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                IconButton(onClick = {
                    scope.launch {
                        if(sheetState.isCollapsed){
                            sheetState.expand()
                        }
                        else if(sheetState.isExpanded){
                            sheetState.collapse()
                        }
                    }
                }) {
                    Icon(imageVector = if(sheetState.isExpanded){
                        Icons.Filled.KeyboardArrowDown
                    }
                    else{
                            Icons.Filled.KeyboardArrowUp
                    },
                        contentDescription = "Icon button")
                }
                BottomSheetContent()
            }
    }) {
//
    }
}