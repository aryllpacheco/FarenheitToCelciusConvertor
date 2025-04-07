package com.example.farenheittocelciusconvertor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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

        binding.CtoFTitleTextToView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hey ... it worked!", Toast.LENGTH_SHORT).show();
            }
        });

        binding.CtoFConvertButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = FToCActivity.fToCIntentFactory(getApplicationContext());
                startActivity(intent);
                return false;
            }
        });
    }

    public void cToFConversion(View v){
        double celsiusValue = 0.0;
        String enteredValue = binding.CelsiusValueEditTextNumberSigned.getText().toString();
        if(!enteredValue.isEmpty()){
            celsiusValue = Double.parseDouble(enteredValue);
        }

        double fahrenheitValue = Utils.cToF(celsiusValue);
        binding.CtoFConvertedValueTextView.setText(getString(R.string.degrees_fahrenheit,fahrenheitValue));

    }
}