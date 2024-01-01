package com.example.virtual_plant_pet.Presentation.screen.HomeScreen.FightSequenceScreens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.tooling.preview.Preview
import com.google.ar.core.Config
import io.github.sceneview.ar.ARScene
import io.github.sceneview.ar.node.ARCameraNode
import io.github.sceneview.node.ModelNode

@Composable
fun FightScreenAR() {
    val node = remember{
        mutableListOf<ARCameraNode>()
    }
    val armodelNode = remember{
        mutableStateOf<ModelNode?>(null)
    }
    ARScene(
        modifier = Modifier.fillMaxSize(),
        childNodes = node,
        planeRenderer = true,
        onViewCreated = {
            this.planeRenderer.isShadowReceiver =false
            

        }


    )
}

@Preview(showBackground = true)
@Composable
fun PreviewFightScreenAr() {
    FightScreenAR()
}