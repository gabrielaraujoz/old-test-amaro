package com.gabrielaraujoz.old_amaro_test.products.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.gabrielaraujoz.old_amaro_test.R
import com.gabrielaraujoz.old_amaro_test.products.model.ProductModel
import com.squareup.picasso.Picasso


class ProductDetailsFragment : Fragment() {

    private lateinit var _product: ProductModel
    private lateinit var _productName: TextView
    private lateinit var _productImage: ImageView
    private lateinit var _productPrice: TextView
    private lateinit var _productInstallments: TextView
    private lateinit var _productOnSale: TextView
    private lateinit var _productSalePrice: TextView
    private lateinit var _productSizes: TextView
    private lateinit var _listSizes: MutableList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _product = requireArguments().get("Product") as ProductModel
        _productName = view.findViewById(R.id.txtProductDetailsName)
        _productImage = view.findViewById(R.id.imgProductDetails)
        _productPrice = view.findViewById(R.id.txtProductDetailsPrice)
        _productInstallments = view.findViewById(R.id.txtProductDetailsInstallments)
        _productOnSale = view.findViewById(R.id.txtProductDetailsPromotionTrue)
        _productSalePrice = view.findViewById(R.id.txtProductDetailsPromotionPrice)
        _productSizes = view.findViewById(R.id.txtProductDetailsSizes)

        _productName.text = _product.name

        Picasso.get()
            .load(_product.image)
            .into(_productImage)

        _productPrice.text = _product.regular_price
        _productInstallments.text = _product.installments

        if (_product.on_sale) {
            _productSalePrice.text = _product.actual_price
        } else {
            _productOnSale.visibility = View.GONE
            _productSalePrice.visibility = View.GONE
        }

        _product.sizes.forEach() {
            if (it.available) {
                _listSizes.add(it.size)
            }
        }

        _productSizes.text = _listSizes.toString()


    }

}