package com.gabrielaraujoz.old_amaro_test.products.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gabrielaraujoz.old_amaro_test.R
import com.gabrielaraujoz.old_amaro_test.products.model.ProductModel
import com.gabrielaraujoz.old_amaro_test.products.repository.ProductRepository
import com.gabrielaraujoz.old_amaro_test.products.viewmodel.ProductViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var _viewModel: ProductViewModel
    private lateinit var _productAdapter: ProductAdapter

    private var _productList = mutableListOf<ProductModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list =  findViewById<RecyclerView>(R.id.recyclerProducts)
        val manager = GridLayoutManager(this, 2)

        _productList = mutableListOf()
        _productAdapter = ProductAdapter(_productList) {
            val bundle = bundleOf("Product" to it)

        }

        list.apply{
            setHasFixedSize(true)

            layoutManager = manager
            adapter = _productAdapter
        }


        _viewModel = ViewModelProvider(
            this,
            ProductViewModel.ProductViewModelFactory(ProductRepository())
        ).get(ProductViewModel::class.java)

        _viewModel.getList().observe(this, {
            showResults(it)
        })

        showLoading(true)

    }

    private fun showResults(list: List<ProductModel>?) {
        showLoading(false)

        list?.isNotEmpty()?.let { notfound(it) }

        list?.let{
            _productList.addAll(it)
        }

        _productAdapter.notifyDataSetChanged()
    }

    fun showLoading(isLoading: Boolean) {
        val viewLoading = findViewById<View>(R.id.loading)

        if (isLoading) {
            viewLoading.visibility = View.VISIBLE
        } else {
            viewLoading.visibility = View.GONE
        }
    }

    fun notfound(notfound: Boolean) {
        if (notfound) {
            findViewById<View>(R.id.layoutNotFound).visibility = View.GONE
        } else {
            findViewById<View>(R.id.layoutNotFound).visibility = View.VISIBLE
        }
    }

}