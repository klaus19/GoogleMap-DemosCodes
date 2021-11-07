package com.tejas.zooapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
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


        }
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

    }
}