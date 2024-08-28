package com.example.sampleapplications

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.qrcode.QRCodeWriter
import java.io.InputStream
import java.net.URL


class ImageViewKotlin : AppCompatActivity() {
    var imageView: ImageView? = null
    var btn_click: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view_kotlin)
        imageView = findViewById(R.id.image_View)
        btn_click = findViewById(R.id.btn_Image_View)
        btn_click?.setOnClickListener {

            if (/*isNetworkAvailable(this)||*/true) {
                var imageDownLoaderTask: ImageDownLoaderTask =
                    ImageDownLoaderTask(this@ImageViewKotlin)
                imageDownLoaderTask.execute("https://i.stack.imgur.com/VMz26.jpg")
            } else {
                Toast.makeText(
                    this,
                    "Please Enable Mobile Network...!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            /*  val recipientMobile = "9292555808"
              val businessId = "9292555808@ybl"

              // Replace this with the desired amount

              // Replace this with the desired amount
              val amount = 100.0

              // Optional transaction note

              // Optional transaction note
              val transactionNote = "Payment for XYZ"

              // Construct the PhonePe URL

              // Construct the PhonePe URL
              val phonePeUrl = String.format(
                  "https://phon.pe/pay?p=%s&pn=%s&t=u&am=%.2f&tn=%s",
                  recipientMobile, businessId, amount, transactionNote
              )

              // Open the PhonePe URL in a browser or a browser-like intent

              // Open the PhonePe URL in a browser or a browser-like intent
              try {
                  val intent = Intent(Intent.ACTION_VIEW, Uri.parse(phonePeUrl))
                  startActivity(intent)
              } catch (e: java.lang.Exception) {
                  Toast.makeText(
                      this,
                      "Failed to open PhonePe. Please ensure you have the app installed.",
                      Toast.LENGTH_SHORT
                  ).show()
                  e.printStackTrace()
              }*/

        }

    }

    inner class ImageDownLoaderTask(context: Context) : AsyncTask<String, Void, Bitmap>() {
        var context: Context? = null
        var progressDialog: ProgressDialog? = null

        init {
            this.context = context
            progressDialog = ProgressDialog(context)
        }

        override fun onPreExecute() {
            super.onPreExecute()
            progressDialog!!.setMessage("Down loading Please wait...!")
            progressDialog!!.show()
        }

        override fun doInBackground(vararg p0: String?): Bitmap? {

            var bitmap: Bitmap? = null
            var stringUrl: String? = null
            stringUrl = p0[0]
            try {
                var url = URL(stringUrl)
                var inputStream: InputStream = url.openStream()
                bitmap = BitmapFactory.decodeStream(inputStream)
            } catch (e: Exception) {
                e.printStackTrace()
                e.message
            }
            return bitmap!!

        }

        override fun onPostExecute(result: Bitmap?) {
            super.onPostExecute(result)
            imageView!!.setImageBitmap(result)
            if (progressDialog!!.isShowing) {
                progressDialog!!.dismiss()
            }

        }

    }

    /*    fun isNetworkAvailable(context: Context?): Boolean {
            if (context == null) return false
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                if (capabilities != null) {
                    when {
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                            return true
                        }
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                            return true
                        }
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                            return true
                        }
                    }
                }
            } else {
                val activeNetworkInfo = connectivityManager.activeNetworkInfo
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                    return true
                }
            }
            return false
        }*/
    fun getQrCodeBitmap(ssid: String, password: String): Bitmap {
        val size = 512 //pixels
        val qrCodeContent = "WIFI:S:$ssid;T:WPA;P:$password;;"
        val hints = hashMapOf<EncodeHintType, Int>().also {
            it[EncodeHintType.MARGIN] = 1
        } // Make the QR code buffer border narrower
        val bits = QRCodeWriter().encode(qrCodeContent, BarcodeFormat.QR_CODE, size, size, hints)
        return Bitmap.createBitmap(size, size, Bitmap.Config.RGB_565).also {
            for (x in 0 until size) {
                for (y in 0 until size) {
                    it.setPixel(x, y, if (bits[x, y]) Color.BLACK else Color.WHITE)
                }
            }
        }
    }

}