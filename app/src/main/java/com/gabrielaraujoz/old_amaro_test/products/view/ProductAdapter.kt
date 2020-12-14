package com.gabrielaraujoz.old_amaro_test.products.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gabrielaraujoz.old_amaro_test.R
import com.gabrielaraujoz.old_amaro_test.products.model.ProductModel

class ProductAdapter(private var products: MutableList<ProductModel>, private val listener: (ProductModel) -> Unit): RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = products[position]

        holder.bind(item)

        holder.itemView.setOnClickListener{ listener(item) }
    }

    override fun getItemCount() = products.size


}