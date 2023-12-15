package com.itmo.kotlinspringbootjwtbase.controller.stock

import com.itmo.kotlinspringbootjwtbase.model.Stock
import com.itmo.kotlinspringbootjwtbase.service.StockService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/stock")
class StockController (private val stockService: StockService) {
        @GetMapping
        fun listAll():List<StockResponse> = stockService.findAll().map{it.toResponse()}

    private fun Stock.toResponse():StockResponse = StockResponse(
        id=this.id,
        name = this.name,
        current_price = this.current_price
    )
}