package com.tejas.zooapp.model

data class Data(
    val activities: List<Activity>,
    val addresses: List<Addresse>,
    val contacts: Contacts,
    val description: String,
    val designation: String,
    val directionsInfo: String,
    val directionsUrl: String,
    val entranceFees: List<EntranceFee>,
    val entrancePasses: List<EntrancePasse>,
    val fees: List<Any>,
    val fullName: String,
    val id: String,
    val images: List<Image>,
    val latLong: String,
    val latitude: String,
    val longitude: String,
    val name: String,
    val operatingHours: List<OperatingHour>,
    val parkCode: String,
    val states: String,
    val topics: List<Topic>,
    val url: String,
    val weatherInfo: String
)