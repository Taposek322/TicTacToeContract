package com.taposek322.tictactoecontract.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TicTacToeContainer(imageVector:ImageVector?,imageDescription:String?,onClick:()->Unit,modifier: Modifier = Modifier){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(5.dp)
            .clickable(enabled = (imageVector==null)){
                onClick()
            }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ){
            imageVector?.let {
                Icon(
                    imageVector = imageVector,
                    contentDescription = imageDescription,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = modifier
                        .fillMaxSize()
                )
            }
        }
    }
}

@Preview
@Composable
fun ContainerPreview(){
    //val imgVect = ImageVector.vectorResource(id = R.drawable.outline_os_24)
    //val imgDescr = "O"
    val imgVect = null
    val imgDescr = null
    TicTacToeContainer(
        imageVector = imgVect,
        imageDescription = imgDescr,
        onClick = { /*TODO*/ }
    )
}