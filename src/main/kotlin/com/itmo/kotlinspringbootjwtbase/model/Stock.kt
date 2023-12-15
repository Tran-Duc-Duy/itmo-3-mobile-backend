package com.itmo.kotlinspringbootjwtbase.model

import java.util.UUID

data class Stock (
    val id:UUID,
    val name: String,
    val current_price:Int,
//    val number:Int,
//    val buying_price: Double,
//    val precentage_of_value:Double,
//    val profit:Double
)