package com.example.native_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {
    private val CHANNEL = "com.example.flutter/kotlin"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            when (call.method) {
                "goToSecondScreen" -> {
                    try {
                        // Start the second screen activity
                        val intent = Intent(this, DetailActivity::class.java)
                        startActivity(intent)
                        result.success("Navigated to second screen")
                    } catch (e: Exception) {
                        result.error("ERROR", "Failed to navigate: ${e.message}", null)
                    }
                }
                else -> result.notImplemented()
            }
        }
    }
}
