package com.tejas.zooapp.misc

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds

class CameraAndViewport {

    val vilnius:CameraPosition=CameraPosition.builder()
        .target(LatLng(54.693461077718155, 25.28255200044458))
        .zoom(17f)
        .bearing(100f)
        .tilt(45f)
        .build()

    val kaunasBounds=LatLngBounds(
        LatLng(54.86570774016023, 23.86943265495184),
       LatLng(54.86758471087152, 23.88938828960437)
    )
}