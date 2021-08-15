package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button bmi_btn;
    private String operand1="", operator="", operand2="";
    private String viewText="", temp = "";
    private int result = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textView = findViewById(R.id.textView);
        bmi_btn = findViewById(R.id.bmi);
        bmi_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), bmi_calculating_activity.class));
            }
        });
    }

    public void clickedObject(View view){
        //Get the clicked button using tag.
        String clickedObject = view.getTag().toString();
        //variable to check whether the user has clicked any operators or not.
        boolean x = ((clickedObject.equals("+")) || (clickedObject.equals("-")) || (clickedObject.equals("x"))
                || (clickedObject.equals("/")) || (clickedObject.equals("%")));
        //variable to check whether all the operators and operands are null or not null.
        boolean y = ((this.operand1.equals("")) || (this.operator.equals("")) || this.operand2.equals(""));
        if((this.operand1.equals("")) && x){
            Toast.makeText(getApplicationContext(), "Enter the number first", Toast.LENGTH_SHORT).show();
        }
        else if(clickedObject.equals("=") && y){
            Toast.makeText(getApplicationContext(), "Please enter the operands and operators correctly", Toast.LENGTH_SHORT).show();
        }
        else if(clickedObject.equals("C")){
            this.operator = this.operand1 = this.operand2 = this.viewText = this.temp = "";
            this.result  = 0;
            this.setText("");
        }
        else{
            if((this.operand1.isEmpty()) || (this.operand2.isEmpty() && this.operator.isEmpty() && !x)){
                this.operand1 = this.operand1 + clickedObject;
                this.viewText ="";
                this.viewText = this.viewText +this.operand1;
                this.setText(viewText);
            }
            else if(x && !this.operator.isEmpty()){
                Toast.makeText(getApplicationContext(), "Invalid operator", Toast.LENGTH_SHORT).show();
            }
            else if(x){
                this.operator = clickedObject;
                this.viewText = this.viewText +this.operator;
                temp = this.viewText;
                this.setText(viewText);
            }
            else if(clickedObject.equals("=")){
                this.textView.setText("");
                this.calculate();
            }
            else{
                this.operand2 = this.operand2 + clickedObject;
                this.viewText = temp + this.operand2;
                this.setText(viewText);
            }
        }
    }

    private void calculate() {
        int a = Integer.parseInt(operand1);
        int b = Integer.parseInt(operand2);
        switch (this.operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "x":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                result = a % b;
                break;
        }
        this.setText(Integer.toString(result));
    }

    private void setText(String text){
        this.textView.setText(text);
    }

}