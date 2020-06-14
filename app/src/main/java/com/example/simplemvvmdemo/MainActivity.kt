package com.example.simplemvvmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        viewModel.getProductDetailsToUI().observe(this, Observer {
            Log.d("MainActivityLog", "Data Received ${it.productDes}")
        })

    }
}
