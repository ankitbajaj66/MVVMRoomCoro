package com.example.simplemvvmdemo

/**
 *Created by Ankit Bajaj on 11-06-2020.
 */
data class ProductDetails(var productID: Int, var productDes: String) : Lazy<ProductDetails> {
    override val value: ProductDetails
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun isInitialized(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}