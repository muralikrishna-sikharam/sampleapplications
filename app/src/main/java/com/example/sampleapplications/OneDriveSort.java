package com.example.sampleapplications;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OneDriveSort extends AppCompatActivity {

    private EditText editText1, editText2, editText3;
    private TextView resultTextView;
    private Button computeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_drive_sort);

        editText1 = findViewById(R.id.et_input1);
        editText2 = findViewById(R.id.et_input2);
        editText3 = findViewById(R.id.et_input3);
        resultTextView = findViewById(R.id.tv_output1);
        computeButton = findViewById(R.id.btn_calculate);

        computeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = editText1.getText().toString();
                String input2 = editText2.getText().toString();
                String input3 = editText3.getText().toString();

                List<Integer> list1 = parseInput(input1);
                List<Integer> list2 = parseInput(input2);
                List<Integer> list3 = parseInput(input3);

                List<Integer> union = computeUnion(list1, list2, list3);
                List<Integer> intersection = computeIntersection(list1, list2, list3);

                Integer maxUnion = findMax(union);
                Integer maxIntersection = findMax(intersection);

                resultTextView.setText(
                        "Union: " + union + "\n" +
                                "Intersection: " + intersection + "\n" +
                                "Max in Union: " + (maxUnion != null ? maxUnion : "N/A") + "\n" +
                                "Max in Intersection: " + (maxIntersection != null ? maxIntersection : "N/A")
                );
            }
        });
    }

    private List<Integer> parseInput(String input) {
        List<Integer> list = new ArrayList<>();
        if (!TextUtils.isEmpty(input)) {
            String[] numbers = input.split(",");
            for (String number : numbers) {
                try {
                    list.add(Integer.parseInt(number.trim()));
                } catch (NumberFormatException e) {
                    e.printStackTrace(); // Handle the error
                }
            }
        }
        return list;
    }

    private List<Integer> computeUnion(List<Integer> list1, List<Integer> list2, List<Integer> list3) {
        List<Integer> union = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();
        for (Integer num : list1) {
            if (!map.containsKey(num)) {
                union.add(num);
                map.put(num, true);
            }
        }
        for (Integer num : list2) {
            if (!map.containsKey(num)) {
                union.add(num);
                map.put(num, true);
            }
        }
        for (Integer num : list3) {
            if (!map.containsKey(num)) {
                union.add(num);
                map.put(num, true);
            }
        }
        return union;
    }

    private List<Integer> computeIntersection(List<Integer> list1, List<Integer> list2, List<Integer> list3) {
        List<Integer> intersection = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : list1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer num : list2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer num : list3) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 3) { // Present in all three lists
                intersection.add(entry.getKey());
            }
        }
        return intersection;
    }

    private Integer findMax(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        Integer max = Integer.MIN_VALUE;
        for (Integer number : list) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
}
