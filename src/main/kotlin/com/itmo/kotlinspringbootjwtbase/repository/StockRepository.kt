package com.itmo.kotlinspringbootjwtbase.repository

import com.itmo.kotlinspringbootjwtbase.model.Stock
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class StockRepository {
    private val stocks= listOf(
        Stock(id = UUID.randomUUID(), name ="Cber", current_price=1),
        Stock(id = UUID.randomUUID(), name ="Tinkoff", current_price=1),
        Stock(id = UUID.randomUUID(), name ="ITMO", current_price=1),
        Stock(id = UUID.randomUUID(), name ="Saint", current_price=1),
    )
    fun findAll(): List<Stock> = stocks
}