package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnCalculateListener(View view){
        // Get the height
        final EditText heightText = (EditText) findViewById(R.id.heightInput);
        String heightStr = heightText.getText().toString();
        double height = Double.parseDouble(heightStr);

        // Get the weight
        final EditText weightText = (EditText) findViewById(R.id.weightInput);
        String weightStr = weightText.getText().toString();
        double weight = Double.parseDouble(weightStr);

        // Calculate the BMI
        double BMI = (weight)/(height*height);

        // Reduce the number of decimal places in BMI
        DecimalFormat df = new DecimalFormat("#.#");
        double BMI_trimmed = Double.parseDouble(df.format(BMI));

        // Display the BMI
        final EditText BMIResult = (EditText) findViewById(R.id.BMIResult);
        BMIResult.setText(Double.toString(BMI_trimmed));

        // Categorize the BMI
        String BMI_Cat;
        if (BMI < 15) BMI_Cat = "Very severely underweight";
        else if (BMI < 16) BMI_Cat = "Severely underweight";
        else if (BMI < 18.5) BMI_Cat = "Underweight";
        else if (BMI < 25) BMI_Cat = "Normal";
        else if (BMI < 30) BMI_Cat = "Overweight";
        else if (BMI < 35) BMI_Cat = "Obese Class 1 - Moderately Obese";
        else if (BMI < 40) BMI_Cat = "Obese Class 2 - Severely Obese";
        else BMI_Cat = "Obese Class 3 - Very Severely Obese";

        // Display the BMI Category
        final TextView BMICategory = (TextView) findViewById(R.id.BMICategory);
        BMICategory.setText(BMI_Cat);
    }
}