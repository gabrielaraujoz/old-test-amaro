package com.gabrielaraujoz.old_amaro_test.products.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.gabrielaraujoz.old_amaro_test.products.model.ProductModel
import com.gabrielaraujoz.old_amaro_test.products.repository.ProductRepository
import kotlinx.coroutines.Dispatchers

class ProductViewModel (
    private val repository: ProductRepository
): ViewModel() {

    private var _products: List<ProductModel> = listOf()

    fun getList() = liveData(Dispatchers.IO) {
        val response = repository.getProducts()

        _products = response.products

        emit(response.products)
    }

    class ProductViewModelFactory(
        private val repository: ProductRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ProductViewModel(repository) as T
        }
    }

}