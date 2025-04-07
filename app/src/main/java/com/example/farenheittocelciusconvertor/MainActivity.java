package com.example.farenheittocelciusconvertor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.farenheittocelciusconvertor.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String CONVERTED_VALUE_EXTRA_KEY = "MainActivity_Converted_value_double";

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.CtoFTitleTextToView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hey ... it worked!", Toast.LENGTH_SHORT).show();
            }
        });

        binding.CtoFConvertButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Intent intent = FToCActivity.fToCIntentFactory(getApplicationContext(), convertValue());
                startActivity(intent);
                return false;
            }
        });
    }

    private double convertValue(){
        double valueToConvert = 0.0;
        String enteredValue = binding.CelsiusValueEditTextNumberSigned.getText().toString();
        if(!enteredValue.isEmpty()){
            valueToConvert = Double.parseDouble(enteredValue);
        }
        valueToConvert = Utils.cToF(valueToConvert);
        return valueToConvert;
    }
    public void displayConvertedValue(View v){
        binding.CtoFConvertedValueTextView.setText(getString(R.string.degrees_fahrenheit, convertValue()));

    }

    public static Intent MainActivityIntentFactory(Context context, double receivedValue){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(CONVERTED_VALUE_EXTRA_KEY, receivedValue);
        return intent;
    }
}