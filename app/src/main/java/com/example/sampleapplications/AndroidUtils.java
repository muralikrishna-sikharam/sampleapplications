package com.example.sampleapplications;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AndroidUtils {

    private static FileWriter fileWriter = null;

    static int[] stringToReversedIntArray(String number) {// "123" converted as [3,2,1]
        int[] result = new int[number.length()];
        for (int i = 0; i < number.length(); i++)
            result[i] = Integer.parseInt(number.substring(i, i + 1));
        result = reverseArray(result);
        return result;
    }

    private static int[] reverseArray(int[] arrayData) {
        int[] result = new int[arrayData.length];
        for (int i = 0; i < arrayData.length; i++)
            result[i] = arrayData[arrayData.length - (i + 1)];
        return result;
    }

    public static String getQuotedString(String A_strText) {
        String strReplaceString;
        String Result = "''";
        if (A_strText != null) {
            strReplaceString = A_strText.replace("'", "''");
            Result = "'" + strReplaceString + "'";
        }
        return Result;
    }

    public static void logMessage(String msg) {
        try {
            fileWriter = new FileWriter(com.example.sampleapplications.Constants.DETAILED_LOGFILE, true);
            fileWriter.write(new SimpleDateFormat("ddMMMyyyy HH:mm:ss.SSS", Locale.ENGLISH).format(new java.util.Date()) + "- Version : "
                    + com.example.sampleapplications.Constants.APPLICATION_VERSION + "=> " + msg + "\r\n");
            Log.d("Murali TEST" + (new Date()), msg);

        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception ex) {
                ex.getMessage();
            }
        }
    }

    public static void createLogFile(Context context) {
        try {
            Date currentDate = new java.util.Date();
            String fileSuffix = new SimpleDateFormat("ddMMMyyyy", Locale.ENGLISH).format(currentDate);

            File directory = new File(Constants.EXTERNAL_ROOT_PATH, Constants.LOG_FILES_FOLDER);
            if (!directory.exists()) {
                directory.mkdir();
            }
            File logfile = new File(directory.getAbsolutePath(), "Log_" + fileSuffix + ".txt");
            if (!logfile.exists()) {
                logfile.createNewFile();
            }
            Constants.DETAILED_LOGFILE = logfile.getAbsolutePath();
        } catch (Exception e) {
            AndroidUtils.showMsg("Error in creating log file" + e.getMessage(), context);
        }
    }

    public static void showMsg(String message, Context context) {
        Toast t = Toast.makeText(context, message, Toast.LENGTH_LONG);
        t.show();

    }

    public static String getSDPath() {
        String filepath = "";
        String[] strPath = {"/storage/sdcard1", "/storage/extsdcard",
                "/storage/sdcard0/external_sdcard", "/mnt/extsdcard",
                "/mnt/sdcard/external_sd", "/mnt/external_sd",
                "/mnt/media_rw/sdcard1", "/removable/microsd", "/mnt/emmc",
                "/storage/external_SD", "/storage/ext_sd",
                "/storage/removable/sdcard1", "/data/sdext", "/data/sdext2",
                "/data/sdext3", "/data/sdext4", "/emmc", "/sdcard/sd",
                "/mnt/sdcard/bpemmctest", "/mnt/sdcard/_ExternalSD",
                "/mnt/sdcard-ext", "/mnt/Removable/MicroSD",
                "/Removable/MicroSD", "/mnt/external1", "/mnt/extSdCard",
                "/mnt/extsd", "/mnt/usb_storage", "/mnt/extSdCard",
                "/mnt/UsbDriveA", "/mnt/UsbDriveB"};

        for (String value : strPath) {
            File f = null;
            f = new File(value);
            if (f.exists() && f.isDirectory()) {
                filepath = value;
                break;
            }
        }
        return filepath;
    }

    public static Bitmap getBitmapfromUrl(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            return bitmap;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;

        }
    }

}
