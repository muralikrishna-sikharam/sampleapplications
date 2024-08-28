package com.example.sampleapplications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Sparkles_Schedule_PickUp#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Sparkles_Schedule_PickUp extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Sparkles_Schedule_PickUp() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Sparkles_Schedule_PickUp.
     */
    // TODO: Rename and change types and number of parameters
    public static Sparkles_Schedule_PickUp newInstance(String param1, String param2) {
        Sparkles_Schedule_PickUp fragment = new Sparkles_Schedule_PickUp();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sparkles__schedule__pick_up, container, false);
        TextView tv_text1 = (TextView) rootView.findViewById(R.id.tv_text1);
        TextView tv_text2 = (TextView) rootView.findViewById(R.id.tv_text2);
        TextView tv_text3 = (TextView) rootView.findViewById(R.id.tv_text3);
        TextView tv_text4 = (TextView) rootView.findViewById(R.id.tv_text4);
        TextView tv_text5 = (TextView) rootView.findViewById(R.id.tv_text5);
        TextView tv_text6 = (TextView) rootView.findViewById(R.id.tv_text6);

        ImageView iv_Image1 = (ImageView) rootView.findViewById(R.id.iv_pic1);
        ImageView iv_Image2 = (ImageView) rootView.findViewById(R.id.iv_pic2);
        ImageView iv_Image3 = (ImageView) rootView.findViewById(R.id.iv_pic3);
        ImageView iv_Image4 = (ImageView) rootView.findViewById(R.id.iv_pic4);
        ImageView iv_Image5 = (ImageView) rootView.findViewById(R.id.iv_pic5);
        ImageView iv_Image6 = (ImageView) rootView.findViewById(R.id.iv_pic6);
        return rootView;
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_sparkles__schedule__pick_up, container, false);
    }

}