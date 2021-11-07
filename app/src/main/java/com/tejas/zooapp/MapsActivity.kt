package com.tejas.zooapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MapStyleOptions.loadRawResourceStyle
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.tejas.zooapp.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.map_types_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
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
            R.id.retro_map->{
                createStyle(map)
            }
            R.id.nightmode_map->{
                createNightMode(map)
            }

        }
        return true
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // Add a marker in Sydney and move the camera
        val vilnius = LatLng(54.693461077718155, 25.28255200044458)
        map.addMarker(MarkerOptions().position(vilnius).title("Marker in Vilnius"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(vilnius,10f)) //this method gives a Zoom level in the range 1-20

        map.uiSettings.apply {
            isZoomControlsEnabled=true

        }

        createStyle(map)
        createNightMode(map)

    }

    //Create a style for the Map
    private fun createStyle(googleMap:GoogleMap){

        try {
            val success = googleMap.setMapStyle(
                     MapStyleOptions.loadRawResourceStyle(
                         this,
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

    private fun createNightMode(googleMap: GoogleMap){
        try{
            val success = googleMap.setMapStyle(
                     MapStyleOptions.loadRawResourceStyle(
                         this,
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
}