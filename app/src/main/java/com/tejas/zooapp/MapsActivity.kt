package com.tejas.zooapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.lifecycleScope

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
import com.tejas.zooapp.misc.CameraAndViewport
import com.tejas.zooapp.misc.TypeAndStyle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    //Lazy initialization
    private val typeAndStyle by lazy { TypeAndStyle() }

    private val cameraAndViewport by lazy { CameraAndViewport() }



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
          typeAndStyle.setMapType(item, map)
        return true
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // Add a marker in Sydney and move the camera
        val vilnius = LatLng(54.693461077718155, 25.28255200044458)
        val kaunas = LatLng(54.90331961212234, 23.886743940615055)
        map.addMarker(MarkerOptions().position(vilnius).title("Marker in Vilnius"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(vilnius,10f))
      //  map.moveCamera(CameraUpdateFactory.newCameraPosition(cameraAndViewport.vilnius)) //this method gives a Zoom level in the range 1-20

        map.uiSettings.apply {
            isZoomControlsEnabled=true

        }




        typeAndStyle.createStyle(map,this)
        typeAndStyle.createNightMode(map,this)


        //move cameraLocation to new location
       lifecycleScope.launch {

           delay(4000L)
           //map.moveCamera(CameraUpdateFactory.newLatLng(kaunas)) //moving from Vilnius to Kaunas co-ordinates
          // map.moveCamera(CameraUpdateFactory.scrollBy(-200f,100f))  //moving map location by specified parameters

           //Deciding map location Bounds
           map.moveCamera(CameraUpdateFactory.newLatLngBounds(cameraAndViewport.kaunasBounds,100))
       }

    }


}