package com.gabrielaraujoz.old_amaro_test.products.repository

import com.gabrielaraujoz.old_amaro_test.data.api.NetworkUtils
import com.gabrielaraujoz.old_amaro_test.data.model.ResponseModel
import com.gabrielaraujoz.old_amaro_test.products.model.ProductModel
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductEndpoint {
    @GET ("59b6a65a0f0000e90471257d")
    suspend fun getProducts(): ResponseModel<ProductModel>

    companion object {
        val endpoint: ProductEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(ProductEndpoint::class.java)
        }
    }
}