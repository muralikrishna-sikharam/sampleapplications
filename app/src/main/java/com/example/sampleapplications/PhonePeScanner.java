package com.example.sampleapplications;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.util.HashMap;
import java.util.Map;

public class PhonePeScanner extends AppCompatActivity {
    ImageView qrCodeImageView;
    Button generateQRButton;
    EditText phonepeNumber, phonePeAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_pe_scanner);

        phonepeNumber = findViewById(R.id.phonepeNumber);
        phonePeAmount = findViewById(R.id.phonepeAmount);
        generateQRButton = findViewById(R.id.generateQRButton);
        qrCodeImageView = findViewById(R.id.qrCodeImageView);

        // Replace these with your actual values

        generateQRButton.setOnClickListener(v -> {
            // String text = phonepeNumber.getText().toString();
            if (!phonepeNumber.getText().toString().isEmpty() && phonepeNumber.getText().toString().length() == 10) {
                try {
                    String payeeAddress = phonepeNumber.getText().toString() + "@ybl";  // UPI ID
                    String payeeName = "PhonePe";     // Merchant or payee name
                    String amount = phonePeAmount.getText().toString();
                    if (!phonePeAmount.getText().toString().isEmpty()
                            && Integer.parseInt(phonePeAmount.getText().toString()) > 0) {// Amount in INR
                        String upiLink = "upi://pay?pa=" + payeeAddress + "&pn=" + payeeName + "&am=" + amount + "&cu=INR";
                        generateQRCode(upiLink);
                    } else {
                        Toast.makeText(this, "Please enter valid Amount", Toast.LENGTH_SHORT).show();
                    }
                  /*  MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.encodeBitmap(text, BarcodeFormat.QR_CODE, 300, 300);
                    qrCodeImageView.setImageBitmap(bitmap);*/
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(this, "Please enter valid mobile number", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Generate UPI payment QR code


    private void generateQRCode(String data) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

            BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 200, 200, hints);

            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    bitmap.setPixel(x, y, bitMatrix.get(x, y) ? android.graphics.Color.BLACK : android.graphics.Color.WHITE);
                }
            }

            qrCodeImageView.setImageBitmap(bitmap);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
