package com.example.enotita_4_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = findViewById(R.id.txtVw_recipe);

        String txtVw_recipe = getIntent().getExtras().getString("title", "default text");

        textView.setText(txtVw_recipe);
    }
}
