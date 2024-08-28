package com.example.sampleapplications;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CourseGVAdapter extends ArrayAdapter<CourseModel> {

    public CourseGVAdapter(@NonNull Context context, ArrayList<CourseModel> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }

        CourseModel courseModel = getItem(position);
        TextView courseTV = listitemView.findViewById(R.id.idTVCourse);
        ImageView courseIV = listitemView.findViewById(R.id.idIVcourse);
        //  Glide.with(holder.iv_JsonResult.getContext()).load(user.getAvatarUrl()).into(holder.iv_JsonResult);
        courseTV.setText(courseModel.getId());
        Bitmap bmp = null;

        courseIV.setImageBitmap(bmp);
        //courseIV.setImageBitmap(courseModel.getAvatar_url());
       /* try {
            courseIV.setImageBitmap(BitmapFactory.decodeStream(new URL(courseModel.getAvatar_url()).openConnection().getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

      /*  URL newurl = null;
        Bitmap mIcon_val;
        try {
            newurl = new URL(courseModel.getAvatar_url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try {
            mIcon_val = BitmapFactory.decodeStream(newurl.openConnection() .getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        courseIV.setImageBitmap(mIcon_val);*/

        courseIV.setImageBitmap(AndroidUtils.getBitmapfromUrl(courseModel.getAvatar_url()));
        return listitemView;
    }
}



