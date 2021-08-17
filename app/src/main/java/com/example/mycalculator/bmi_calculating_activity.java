package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bmi_calculating_activity extends AppCompatActivity {

    private EditText height_et;
    private EditText weight_et;
    private Button bmi_calculate_btn, contacts;
    private float height=0, weight=0, bmi=0;
    private TextView final_result;
    private String bmi_result="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculating_activity);
        Intialization();
        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), context_menu_with_list_view.class);
                startActivity(intent);
            }
        });
        bmi_calculate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                height = Float.parseFloat(height_et.getText().toString()) / 100;
                weight = Float.parseFloat(weight_et.getText().toString());
                bmi = weight / (height * height);

                if(bmi < 16)
                    bmi_result = "poor under weight";
                else if(bmi < 18.5)
                    bmi_result = "under weight";
                else if(bmi >= 18.5 && bmi<= 24.9)
                    bmi_result = "Normal weight";
                else if(bmi >= 25 && bmi <= 29.9)
                    bmi_result = "over weight";
                else
                    bmi_result = "obese";

                final_result.setText(bmi_result);
                height_et.setText("");
                weight_et.setText("");
            }
        });
    }

    private void Intialization() {
        this.height_et = findViewById(R.id.height);
        this.weight_et = findViewById(R.id.weight);
        this.bmi_calculate_btn = findViewById(R.id.bmi_cal);
        this.final_result = findViewById(R.id.result);
        this.contacts = findViewById(R.id.contacts);
    }
}
