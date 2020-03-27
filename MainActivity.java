package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //declare viarable for the design items
    EditText weight, height;
    Button calc, clear;
    TextView BMI, category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize the design items
        weight = findViewById(R.id.txtWeight);
        height = findViewById(R.id.txtHeight);
        calc = findViewById(R.id.btnCalc);
        clear = findViewById(R.id.btnClear);
        BMI = findViewById(R.id.tvBMI);
        category = findViewById(R.id.tvCat);
        //set buttons as listeners
        calc.setOnClickListener(this);
        clear.setOnClickListener(this);

    }
    //in this method where we write the code of the actions
    @Override
    public void onClick(View view) {
    //check the event source which means the button that gets clicked
    if(view.getId()==R.id.btnCalc) {
        if(height.getText().toString().equals("") || weight.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(),"Please enter your wight and height", Toast.LENGTH_LONG).show();
        else{
            double h = Double.parseDouble(height.getText().toString());
            double w = Double.parseDouble(weight.getText().toString());
            double bmi = w/((h/100)*(h/100));
            String c;
            if(bmi<18.5)
                c="under weight";
            else if(bmi<24.9)
                c="normal";
            else if(bmi<29.9)
                c="over weight";
            else
                c="obese";
            category.setText(c);
            String b = String.format("%.1f",bmi);
            BMI.setText(b);

        }

    }
    else {
        weight.setText("");
        height.setText("");
        BMI.setText("");
        category.setText("");
    }

    }
}

