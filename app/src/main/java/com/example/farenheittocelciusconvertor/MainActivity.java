package com.example.farenheittocelciusconvertor;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.farenheittocelciusconvertor.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.CtoFConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertValueFromDisplay();
            }
        });
    }

    private void convertValueFromDisplay(){
        double celsiusValue = 0.0;
        String enteredValue = binding.CtoFEnteredValueEditText.getText().toString();
        if(!enteredValue.isEmpty()){
            celsiusValue = Double.parseDouble(enteredValue);
        }

        double fahrenheitValue = Utils.cToF(celsiusValue);
        binding.CtoFConvertedValueTextView.setText(fahrenheitValue + " ");

    }

}