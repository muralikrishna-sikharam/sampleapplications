package com.example.sampleapplications


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.biometric.BiometricPrompt.PromptInfo
import androidx.core.content.ContextCompat


class MainLoginFingerPrint : AppCompatActivity() {
    lateinit var swipeButton1: ImageView
    lateinit var swipeText1: TextView
    var initialX = 0f
    var dX = 0f
    var isSwiped = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login_finger_print)

        // Initialising msgtext and loginbutton
        val msgtex = findViewById<TextView>(R.id.msgtext)
        val loginbutton = findViewById<Button>(R.id.login)
        swipeButton1 = findViewById<ImageView>(R.id.swipeButton1)
        swipeText1 = findViewById<TextView>(R.id.swipeText1)
        val swipeButtonBackground = findViewById<View>(R.id.swipeButtonBackground1)
        swipeButton1.setOnTouchListener(OnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    initialX = swipeButton1.x
                    dX = swipeButton1.x - event.rawX
                    return@OnTouchListener true
                }

                MotionEvent.ACTION_MOVE -> {
                    val newX = event.rawX + dX

                    // Constrain the swipe button within the bounds of the background
                    if (newX > initialX && newX + swipeButton1.width < swipeButtonBackground.width) {
                        swipeButton1.x = newX
                    }
                    return@OnTouchListener true
                }

                MotionEvent.ACTION_UP -> {
                    // Check if swipe is successful (button moved at least 70% of the way)
                    if (swipeButton1.x > swipeButtonBackground.width * 0.7) {
                        // Do something on successful swipe
                        swipeText1.text = "Login Confirmed"
                        isSwiped = true
                        if (isSwiped) {
                            val intent1 =
                                Intent(this@MainLoginFingerPrint, MainActivity::class.java)
                            startActivity(intent1)
                        } else {
                            Toast.makeText(
                                this@MainLoginFingerPrint,
                                "Swipe till End to get Main Activity.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(
                            this@MainLoginFingerPrint,
                            "Swipe till End to get Main Activity.",
                            Toast.LENGTH_SHORT
                        ).show()
                        // Reset position if not fully swiped
                        swipeButton1.animate().x(initialX).setDuration(200).start()
                    }
                    return@OnTouchListener true
                }
            }
            false
        })


        // creating a variable for our BiometricManager
        // and lets check if our user can use biometric sensor or not
        val biometricManager = BiometricManager.from(this)
        when (biometricManager.canAuthenticate()) {
            BiometricManager.BIOMETRIC_SUCCESS -> {
                msgtex.text = "You can use the fingerprint sensor to login"
                msgtex.setTextColor(Color.parseColor("#fafafa"))
            }

            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
                msgtex.text = "This device doesnot have a fingerprint sensor"
                loginbutton.visibility = View.GONE
            }

            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
                msgtex.text = "The biometric sensor is currently unavailable"
                loginbutton.visibility = View.GONE
            }

            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
                msgtex.text =
                    "Your device doesn't have fingerprint saved,please check your security settings"
                loginbutton.visibility = View.GONE
            }
        }
        // creating a variable for our Executor
        val executor = ContextCompat.getMainExecutor(this)
        // this will give us result of AUTHENTICATION
        val biometricPrompt = BiometricPrompt(
            this@MainLoginFingerPrint,
            executor,
            object : BiometricPrompt.AuthenticationCallback() {

                // THIS METHOD IS CALLED WHEN AUTHENTICATION IS SUCCESS
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    Toast.makeText(applicationContext, "Login Success", Toast.LENGTH_SHORT).show()
                    //loginbutton.text = "Login Successful"
                    val intent1 = Intent(this@MainLoginFingerPrint, MainActivity::class.java)
                    startActivity(intent1)
                }

            })
        // creating a variable for our promptInfo
        // BIOMETRIC DIALOG
        val promptInfo = PromptInfo.Builder().setTitle("Login here")
            .setDescription("Use your fingerprint to login ").setNegativeButtonText("Cancel")
            .build()
        loginbutton.setOnClickListener { biometricPrompt.authenticate(promptInfo) }
    }

    override fun onResume() {
        super.onResume()
        // Reset swipe button position and text when the activity resumes
        swipeButton1?.x = initialX
        swipeText1?.text = "Swipe to Login"
    }
}

