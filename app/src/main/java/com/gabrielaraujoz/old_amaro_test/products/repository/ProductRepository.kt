package com.gabrielaraujoz.old_amaro_test.products.repository

class ProductRepository {
    private val client = ProductEndpoint.endpoint

    suspend fun getProducts() = client.getProducts()
}