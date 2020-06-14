package com.example.simplemvvmdemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


/**
 *Created by Ankit Bajaj on 11-06-2020.
 */
class ProductViewModel : ViewModel() {

    private val product : Lazy<ProductDetails> = ProductDetails(1, "")
    private val productDetails = MutableLiveData<ProductDetails>()

    init {
        // This method either call in button click or call in load of the screen
        loadProductDetails()
        product.value
    }


    // This will be disallow to update data on View
    fun getProductDetailsToUI() : LiveData<ProductDetails> = productDetails

    fun loadProductDetails() = productDetails.apply {
        CoroutineScope(IO).launch {
            val result = getProductDetails()
            withContext(Main)
            {
                value = result
            }
        }

        //value = ProductDetails(1, "This is first Product")
    }
    // Assume you get the data from server
    //productDetails.value = ProductDetails(1, "This is first Product")



    suspend fun getProductDetails(): ProductDetails {
        Log.d("ProductViewModelLog", "Making network call")
        delay(3000)
        Log.d("ProductViewModelLog", "Finished network call")
        return ProductDetails(1, "This is first Product")
    }
}


//    fun getProductDetails() {
//        loadProductDetails()
//    }
