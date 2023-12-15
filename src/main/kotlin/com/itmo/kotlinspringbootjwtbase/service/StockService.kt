package com.itmo.kotlinspringbootjwtbase.service

import com.itmo.kotlinspringbootjwtbase.model.Stock
import com.itmo.kotlinspringbootjwtbase.repository.StockRepository
import org.springframework.stereotype.Service

@Service
class StockService (private val stockRepository: StockRepository) {
    fun findAll(): List<Stock> = stockRepository.findAll()
}