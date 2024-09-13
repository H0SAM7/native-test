package com.example.native_test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity // Ensure this import is present

class DetailActivity : AppCompatActivity() { // Ensure the superclass is correct
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail) // Ensure the layout resource is correct
    }
}
