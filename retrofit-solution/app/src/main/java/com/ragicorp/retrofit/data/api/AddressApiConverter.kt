package com.ragicorp.retrofit.data.api

import com.ragicorp.retrofit.data.PlaceDomain

fun AddressApiResponse.toDomain(): List<PlaceDomain> =
    features.map { feature ->
        var address = ""

        val name = feature.properties.name
        if (name?.isNotBlank() == true) {
            address += "$name\n"
        }
        val number = feature.properties.houseNumber
        if (number?.isNotBlank() == true) {
            address += "$number "
        }
        val street = feature.properties.street
        if (street?.isNotBlank() == true) {
            address += street
        }

        if(address.isNotBlank()) {
            address += "\n"
        }
        if(feature.properties.postcode?.isNotBlank() == true) {
            address += "${feature.properties.postcode} "
        }
        if(feature.properties.city?.isNotBlank() == true) {
            address += feature.properties.city
        }

        address = address.trim()

        PlaceDomain(
            address,
            feature.geometry.coordinates[0],
            feature.geometry.coordinates[1]
        )
    }