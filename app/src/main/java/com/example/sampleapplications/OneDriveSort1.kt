package com.example.sampleapplications

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class OneDriveSort1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_drive_sort)
        val btn_calculate: Button
        val et_input1: EditText
        val et_input2: EditText
        val et_input3: EditText
        val tv_output1: TextView
        val tv_output2: TextView
        val tv_output3: TextView
        btn_calculate = findViewById(R.id.btn_calculate)
        et_input1 = findViewById(R.id.et_input1)
        et_input2 = findViewById(R.id.et_input2)
        et_input3 = findViewById(R.id.et_input3)
        tv_output1 = findViewById(R.id.tv_output1)
        tv_output2 = findViewById(R.id.tv_output2)
        tv_output3 = findViewById(R.id.tv_output3)
        btn_calculate.setOnClickListener {
            val input1 = et_input1.text.toString()
            val input2 = et_input2.text.toString()
            val input3 = et_input3.text.toString()
            if (input3.isEmpty() || input1.isEmpty() || input2.isEmpty()) {
                Toast.makeText(
                    this@OneDriveSort1,
                    "Please give input in all the lists",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val list1 = parseInputToList(input1)
                val list2 = parseInputToList(input2)
                val list3 = parseInputToList(input3)

                val union: MutableSet<Int> =
                    HashSet(list1)
                union.addAll(list2)
                union.addAll(list3)

                val maxUnion = findMax(union)

                val intersection = getIntersection(list1, list2, list3)

                tv_output1.text = "Intersection of Lists :$intersection"
                tv_output2.text = "Union of Lists: $union"
                tv_output3.text = "Biggest Number of Lists: " + maxUnion.toString()
            }
        }
    }

    private fun parseInputToList(input: String): List<Int> {
        val list: MutableList<Int> = ArrayList()
        val numbers = input.split(",".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()
        for (number in numbers) {
            list.add(number.trim { it <= ' ' }.toInt())
        }
        return list
    }

    private fun getIntersection(list1: List<Int>, list2: List<Int>, list3: List<Int>): Set<Int> {
        val set1: MutableSet<Int> = HashSet(list1)
        val set2: Set<Int> = HashSet(list2)
        val set3: Set<Int> = HashSet(list3)
        set1.retainAll(set2)
        set1.retainAll(set3)
        return set1
    }

    private fun findMax(set: Set<Int>): Int? {
        if (set.isEmpty()) {
            return null
        }
        var max = Int.MIN_VALUE
        for (number in set) {
            if (number > max) {
                max = number
            }
        }
        return max
    }
}