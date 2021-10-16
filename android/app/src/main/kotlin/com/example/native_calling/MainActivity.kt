package com.example.native_calling

import android.widget.Toast
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import org.jetbrains.annotations.NotNull

class MainActivity : FlutterActivity() {

    private val channel = "jd.flutter.native/battery"

    override fun configureFlutterEngine(@NotNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)


        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, channel).setMethodCallHandler { call, result ->
            if (call.method == "getBatteryLevel") {
                // val batteryLevel = getBatteryLevel()

                Toast.makeText(this, "inside kotlin native", Toast.LENGTH_LONG).show()

                result.success("13 from kotlin native")

                // if (batteryLevel != -1) {
                //     result.success(batteryLevel)
                // } else {
                //     result.error("UNAVAILABLE", "Battery level not available.", null)
                // }
            } else {
                result.notImplemented()
            }
        }

    }
}
