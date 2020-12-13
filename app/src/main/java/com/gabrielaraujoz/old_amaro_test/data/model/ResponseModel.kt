package com.gabrielaraujoz.old_amaro_test.data.model

import com.gabrielaraujoz.old_amaro_test.products.model.ProductModel

data class ResponseModel<T> (
    val products: List<T>
)
