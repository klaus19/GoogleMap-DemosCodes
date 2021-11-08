package com.tejas.zooapp.misc

import android.content.Context
import android.util.Log
import android.view.MenuItem
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.MapStyleOptions
import com.tejas.zooapp.R

class TypeAndStyle {

    //Create a style for the Map
     fun createStyle(googleMap: GoogleMap,context: Context){

        try {
            val success = googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                    context,
                    R.raw.style
                )

            )
            if(!success){
                Log.d("maps","Failed to add style")
            }
        }catch (e:Exception){
            Log.d("Maps",e.toString())
        }
    }

    //Create a style for nightmode

    fun createNightMode(googleMap: GoogleMap,context: Context){
        try{
            val success = googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                    context,
                    R.raw.night
                )
            )
            if(!success){
                Log.d("maps","Failed to add style")
            }
        }catch (e:java.lang.Exception){
            Log.d("Maps",e.toString())
        }
    }

    fun setMapType(item:MenuItem,map: GoogleMap){
        when(item.itemId) {
            R.id.normal_map->{
                map.mapType = GoogleMap.MAP_TYPE_NORMAL
            }

            R.id.hybrid_map->{
                map.mapType = GoogleMap.MAP_TYPE_HYBRID

            }
            R.id.satellite_map->{
                map.mapType = GoogleMap.MAP_TYPE_SATELLITE
            }
            R.id.terrain_map->{
                map.mapType = GoogleMap.MAP_TYPE_TERRAIN
            }
            R.id.none_map->{
                map.mapType = GoogleMap.MAP_TYPE_NONE

            }
        }
    }


}