package com.itmo.kotlinspringbootjwtbase.controller.stock

import java.util.*

data class StockResponse(
    val id: UUID,
    val name: String,
    val current_price:Int,
)
