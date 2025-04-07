package com.example.farenheittocelciusconvertor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import com.example.farenheittocelciusconvertor.databinding.ActivityFtoCactivityBinding;

import java.util.Locale;


public class FToCActivity extends AppCompatActivity {

    private static final String CONVERTED_VALUE_EXTRA_KEY = "FtoCActivity_Received_value";

    ActivityFtoCactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFtoCactivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        double fahrenheit = getIntent().getDoubleExtra(CONVERTED_VALUE_EXTRA_KEY, 0.0);
        binding.FtoCEditText.setText(String.format(Locale.ENGLISH,"%.2f",fahrenheit));

        binding.FToCTitleTextView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = MainActivity.MainActivityIntentFactory(getApplicationContext(),42.0);
                startActivity(intent);
                return false;
            }
        });

        }

    }

    public static Intent fToCIntentFactory(Context context, double fahrenheitValue){
        Intent intent = new Intent(context, FToCActivity.class);
        intent.putExtra(CONVERTED_VALUE_EXTRA_KEY, fahrenheitValue);
        return intent;
    }
}