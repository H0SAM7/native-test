package com.example.your_project_name;

import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.plugin.common.MethodChannel;
import android.content.Context;

public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "com.example.native_test/mada";

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
            .setMethodCallHandler(
                (call, result) -> {
                    if (call.method.equals("openMadaApp")) {
                        openMadaApp();
                        result.success("Mada App opened");
                    } else {
                        result.notImplemented();
                    }
                }
            );
    }

    private void openMadaApp() {
        Intent intent = new Intent();
        intent.setAction("com.intersoft.payment");
        intent.setPackage("com.intersoft.payment");
        intent.putExtra("CHANNEL_ID", "acquire");
        intent.putExtra("TRANS_TYPE", 9000);
        intent.putExtra("OUT_ORDERNO", "printImage");
        intent.putExtra("IS_OPEN_ADMIN", 1);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
