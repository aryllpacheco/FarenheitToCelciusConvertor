package com.example.farenheittocelciusconvertor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;


public class FToCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fto_cactivity);

    }

    public static Intent fToCIntentFactory(Context context){
        Intent intent = new Intent(context, FToCActivity.class);
        return intent;
    }
}