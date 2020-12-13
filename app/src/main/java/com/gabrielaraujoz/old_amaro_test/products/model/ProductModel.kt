package com.gabrielaraujoz.old_amaro_test.products.model

data class ProductModel(
    val name: String,
    val style: Int,
    val code_color: String,
    val color_slug: String,
    val on_sale: Boolean,
    val regular_price: String,
    val actual_price: String,
    val discount_percentage: String,
    val installments: String,
    val image: String?,
    val sizes: List<SizeModel>
)
