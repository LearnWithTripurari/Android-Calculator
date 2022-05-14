package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText display;
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonDec, buttonEqual, buttonPlus, buttonMinus, buttonMul, buttonDiv;

    public static String nums = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button0 = findViewById(R.id.button0);

        buttonDec = findViewById(R.id.buttonDecimal);
        buttonEqual = findViewById(R.id.buttonEqual);

        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMul = findViewById(R.id.buttonMultiplication);
        buttonDiv = findViewById(R.id.buttonDivision);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);


        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);

        buttonDec.setOnClickListener(this);

        buttonEqual.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button1:
                nums = nums + "1";
                display.setText(nums);
                break;

            case R.id.button2:
                nums = nums + "2";
                display.setText(nums);
                break;

            case R.id.button3:
                nums = nums + "3";
                display.setText(nums);
                break;

            case R.id.button4:
                nums = nums + "4";
                display.setText(nums);
                break;

            case R.id.button5:
                nums = nums + "5";
                display.setText(nums);
                break;

            case R.id.button6:
                nums = nums + "6";
                display.setText(nums);
                break;

            case R.id.button7:
                nums = nums + "7";
                display.setText(nums);
                break;

            case R.id.button8:
                nums = nums + "8";
                display.setText(nums);
                break;

            case R.id.button9:
                nums = nums + "9";
                display.setText(nums);
                break;

            case R.id.button0:
                nums = nums + "0";
                display.setText(nums);
                break;

            case R.id.buttonDecimal:
                nums = nums + ".";
                display.setText(nums);
                break;

            case R.id.buttonPlus:
                if (nums.equals("")) {
                    return;
                }
                nums = nums + "+";
                display.setText(nums);
                break;

            case R.id.buttonMinus:
                if (nums.equals("")) {
                    return;
                }
                nums = nums + "-";
                display.setText(nums);
                break;

            case R.id.buttonMultiplication:
                if (nums.equals("")) {
                    return;
                }
                nums = nums + "*";
                display.setText(nums);
                break;

            case R.id.buttonDivision:
                if (nums.equals("")) {
                    return;
                }
                nums = nums + "/";
                display.setText(nums);
                break;

            case R.id.buttonEqual:

                String validatedSequence = validateSequence();

                String[] _nums = validatedSequence.split("(?<=[\\d.])(?=[^\\d.])|(?<=[^\\d.])(?=[\\d.])");

                if (_nums.length == 1) {
                    return;
                }

                double res = calculate(_nums);

                display.setText(String.valueOf(res));

                nums = "";

                validatedSequence = "";

                break;
        }
    }

    private static double calculate(String[] _nums) {

        int i = 0;
        double res = 0.0;

        while (i < _nums.length - 1) {

            if (_nums[i + 1].equals("+")) {

                if (res > 0) {

                    res = res + Double.parseDouble(_nums[i + 2]);
                } else {
                    res = Double.parseDouble(_nums[i]) + Double.parseDouble(_nums[i + 2]);
                }

                i = i + 2;
            } else if (_nums[i + 1].equals("-")) {

                if (res > 0) {

                    res = res - Double.parseDouble(_nums[i + 2]);
                } else {
                    res = Double.parseDouble(_nums[i]) - Double.parseDouble(_nums[i + 2]);
                }

                i = i + 2;
            } else if (_nums[i + 1].equals("*")) {

                if (res > 0) {

                    res = res * Double.parseDouble(_nums[i + 2]);
                } else {
                    res = Double.parseDouble(_nums[i]) * Double.parseDouble(_nums[i + 2]);
                }

                i = i + 2;
            } else if (_nums[i + 1].equals("/")) {

                if (res > 0) {

                    res = res * Double.parseDouble(_nums[i + 2]);
                } else {
                    res = Double.parseDouble(_nums[i]) * Double.parseDouble(_nums[i + 2]);
                }

                i = i + 2;
            }

        }

        return res;
    }


    private static String validateSequence() {

        char lastChar = nums.charAt(nums.length() - 1);

        if (lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/') {
            String newNums = nums.substring(0, nums.length() - 1);

            return newNums;
        }

        return nums;
    }
}