package com.example.currency_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView amount_dollar_text;
    private TextView amount_LL_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amount_dollar_text = (TextView) findViewById(R.id.amount_dollar);
        amount_LL_text = (TextView) findViewById(R.id.LL_amount);
    }

    public void convert_amount(View v){
        if(!isNumeric(amount_LL_text) && !isNumeric(amount_dollar_text)){
            Toast.makeText(getApplicationContext(), "Enter numeric values only", Toast.LENGTH_LONG);
        }
        else if(isNumeric(amount_LL_text) && !isNumeric(amount_dollar_text)){
            amount_dollar_text.setText(Integer.parseInt(amount_LL_text.toString()) / 22000);
            Toast.makeText(getApplicationContext(), "The amount in L.L was converted into dollars", Toast.LENGTH_LONG);
        }
        else if(!isNumeric(amount_LL_text) && isNumeric(amount_dollar_text)){
            amount_dollar_text.setText(Integer.parseInt(amount_dollar_text.toString()) * 22000);
            Toast.makeText(getApplicationContext(), "The amount in dollars was converted into L.L.", Toast.LENGTH_LONG);
        }
        else{//if both dollars and LL were numeric
            Toast.makeText(getApplicationContext(), "Please enter the amount of either dollars or L.L to convert", Toast.LENGTH_LONG);
        }
    }

    public void reset(View v){
        amount_dollar_text.setText("Amount in Dollars $");
        amount_LL_text.setText("Amount in L.L");
        Toast.makeText(getApplicationContext(), "Values were reset", Toast.LENGTH_LONG);
    }

    private boolean isNumeric(TextView amount_ll_text) {
        String amount = amount_ll_text.toString();
        boolean result = false;
        try {
            int amount_int = Integer.parseInt(amount);
            result = true;
        }
        catch (NumberFormatException e){
            result = false;
        }
        return result;
    }

}