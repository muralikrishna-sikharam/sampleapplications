package com.example.sampleapplications

import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


class TorchLightActivity : AppCompatActivity() {
    private var toggleFlashLightOnOff: ToggleButton? = null
    private var cameraManager: CameraManager? = null
    private var getCameraID: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_torch_light)

        // Register the ToggleButton with specific ID
        toggleFlashLightOnOff = findViewById(R.id.toggle_flashlight)

        // cameraManager to interact with camera devices
        cameraManager = getSystemService(CAMERA_SERVICE) as CameraManager

        // Exception is handled, because to check whether
        // the camera resource is being used by another
        // service or not.
        try {
            // O means back camera unit,
            // 1 means front camera unit
            getCameraID = cameraManager!!.cameraIdList[0]
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "App is closing", Toast.LENGTH_SHORT).show()
    }

    // RequiresApi is set because, the devices which are
    // below API level 10 don't have the flash unit with
    // camera.
    @RequiresApi(api = Build.VERSION_CODES.M)
    fun toggleFlashLight(view: View?) {
        if (toggleFlashLightOnOff!!.isChecked) {
            // Exception is handled, because to check
            // whether the camera resource is being used by
            // another service or not.
            try {
                // true sets the torch in ON mode
                cameraManager!!.setTorchMode(getCameraID!!, true)

                // Inform the user about the flashlight
                // status using Toast message
                Toast.makeText(
                    this@TorchLightActivity,
                    "Flashlight is turned ON",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } catch (e: CameraAccessException) {
                // prints stack trace on standard error
                // output error stream
                e.printStackTrace()
            }
        } else {
            // Exception is handled, because to check
            // whether the camera resource is being used by
            // another service or not.
            try {
                // true sets the torch in OFF mode
                cameraManager!!.setTorchMode(getCameraID!!, false)

                // Inform the user about the flashlight
                // status using Toast message
                Toast.makeText(
                    this@TorchLightActivity,
                    "Flashlight is turned OFF",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } catch (e: CameraAccessException) {
                // prints stack trace on standard error
                // output error stream
                e.printStackTrace()
            }
        }
    }

    // when you click on button and torch open and
    // you do not close the torch again this code
    // will off the torch automatically
    @RequiresApi(api = Build.VERSION_CODES.M)
    override fun finish() {
        super.finish()
        try {
            // true sets the torch in OFF mode
            cameraManager!!.setTorchMode(getCameraID!!, false)

            // Inform the user about the flashlight
            // status using Toast message
            Toast.makeText(this, "Flashlight is turned OFF", Toast.LENGTH_SHORT).show()
        } catch (e: CameraAccessException) {
            // prints stack trace on standard error
            // output error stream
            e.printStackTrace()
        }
    }
}


/*class TorchLightActivity : AppCompatActivity() {

    private lateinit var cameraManager: CameraManager
    private lateinit var cameraId: String
    private var isFlashlightOn = false

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_torch_light)

        val flashlightButton: Button = findViewById(R.id.flashlight_button)
        cameraManager = getSystemService(CAMERA_SERVICE) as CameraManager

        try {
            cameraId = cameraManager.cameraIdList[0]
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }

        flashlightButton.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 50)
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    toggleFlashlight()
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun toggleFlashlight() {
        try {
            if (isFlashlightOn) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    cameraManager.setTorchMode(cameraId, false)
                }
                isFlashlightOn = false
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cameraManager.setTorchMode(cameraId, true)
                }
                isFlashlightOn = true
            }
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }
}*/
