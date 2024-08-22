package org.example.yugiohkmmtest.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun ShowingMap() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Text(text = "Map", fontSize = 30.sp)
            MyGoogleMaps()
        }
    }
}

@Composable
fun MyGoogleMaps() {
//    val newYork = LatLng(28.270833, -16.63916)
//    val cameraPosition = CameraPosition.fromLatLngZoom(newYork, 10f)
//    val cameraState = rememberCameraPositionState() {
//        position = cameraPosition
//    }
    Box(modifier = Modifier
        .padding(bottom = 80.dp)
        .fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Map", fontSize = 80.sp)
            //"AIzaSyCuGMaBbELjW52__4fCkx0S3ZBUBBYDbuE
        }

//        GoogleMap(
//            modifier = Modifier.fillMaxSize()){
//            Marker(position = LatLng(27.270833, -17.63916))
//            Marker(position = LatLng(27.270933, -17.63350))
//        }
    }
}

//google-maps = { group = "com.google.android.gms", name = "play-services-maps", version = "1.0.0" }
//google-location = { group = "com.google.android.gms", name = "play-services-location", version = "18.0.0" }