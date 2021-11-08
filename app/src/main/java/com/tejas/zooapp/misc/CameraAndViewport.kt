package com.tejas.zooapp.misc

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

class CameraAndViewport {

    val vilnius:CameraPosition=CameraPosition.builder()
        .target(LatLng(54.693461077718155, 25.28255200044458))
        .zoom(17f)
        .bearing(100f)
        .tilt(45f)
        .build()
}