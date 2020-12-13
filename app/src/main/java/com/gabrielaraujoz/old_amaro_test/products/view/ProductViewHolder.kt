package com.gabrielaraujoz.old_amaro_test.products.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gabrielaraujoz.old_amaro_test.R
import com.gabrielaraujoz.old_amaro_test.products.model.ProductModel
import com.squareup.picasso.Picasso

class ProductViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    private val productName = view.findViewById<TextView>(R.id.txtProductItemName)
    private val productImage = view.findViewById<ImageView>(R.id.imgProductItem)
    private val productPrice = view.findViewById<TextView>(R.id.txtProductItemPrice)

    fun bind(productModel: ProductModel) {
        productName.text = productModel.name

        if (productModel.image.isNullOrEmpty()){
            productImage.setImageResource(R.drawable.no_image_available)
        } else {
            Picasso.get()
                .load(productModel.image)
                .into(productImage)
        }

        if (productModel.on_sale) {
            productPrice.text = productModel.actual_price
        } else {
            productPrice.text = productModel.regular_price
        }
    }

}
