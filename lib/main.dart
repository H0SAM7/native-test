import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  static const platform = MethodChannel('com.example.native_test/mada');

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text('Mada App Launcher')),
        body: Center(
          child: ElevatedButton(
            onPressed: _openMadaApp,
            child: Text('Open Mada App'),
          ),
        ),
      ),
    );
  }

  Future<void> _openMadaApp() async {
    try {
      final result = await platform.invokeMethod('openMadaApp');
      print(result);  // Mada App opened
    } on PlatformException catch (e) {
      print("Failed to open Mada app: '${e.message}'.");
    }
  }
}
