package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String operand1="", operator="", operand2="";
    private String viewText="", temp = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textView = findViewById(R.id.textView);
    }

    public void clickedObject(View view){
        String clickedObject = view.getTag().toString();
        boolean x = ((clickedObject.equals("+")) || (clickedObject.equals("-")) || (clickedObject.equals("x"))
                || (clickedObject.equals("/")) || (clickedObject.equals("%")));
        boolean y = ((this.operand1.equals("")) || (this.operator.equals("")) || this.operand2.equals(""));
        if((this.operand1.equals("")) && x){
            Toast.makeText(getApplicationContext(), "Enter the number first", Toast.LENGTH_SHORT).show();
        }
        else if(clickedObject.equals("=") && y){
            Toast.makeText(getApplicationContext(), "Please enter the operands and operators correctly", Toast.LENGTH_SHORT).show();
        }
        else if(clickedObject.equals("C")){
            this.operator = this.operand1 = this.operand2 = this.viewText = this.temp = "";
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
        int c;
        switch (this.operator) {
            case "+":
                c = a + b;
                break;
            case "-":
                c = a - b;
                break;
            case "x":
                c = a * b;
                break;
            case "/":
                c = a / b;
                break;
            default:
                c = a % b;
                break;
        }
        this.setText(Integer.toString(c));
    }

    private void setText(String text){
        this.textView.setText(text);
    }

}