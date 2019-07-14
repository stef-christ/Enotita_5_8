package com.example.enotita_4_7;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView txtVw_id = findViewById(R.id.txtVw_id);
        TextView txtVw_recTitle = findViewById(R.id.txtVw_recTitle);
        TextView txtVw_recDescription = findViewById(R.id.txtVw_recDescription);

        String txtVw_Id = getIntent().getExtras().getString("id", "default text");
        String txtVw_title = getIntent().getExtras().getString("title", "default text");
        String txtVw_description = getIntent().getExtras().getString("description", "default text");

        txtVw_id.setText(txtVw_Id);
        txtVw_recTitle.setText(txtVw_title);
        txtVw_recDescription.setText(txtVw_description);
        txtVw_recDescription.setMovementMethod(new ScrollingMovementMethod());
    }
}
