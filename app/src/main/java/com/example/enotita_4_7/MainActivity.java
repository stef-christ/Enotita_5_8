package com.example.enotita_4_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = findViewById(R.id.listvw);
        ArrayList<Recipe> recipes = DataSource.getAllRecipes();

        MyAdapter adapter = new MyAdapter(MainActivity.this, recipes);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtVw_recTitle = view.findViewById(R.id.txtVw_recTitle);
                TextView txtVwDesc = view.findViewById(R.id.txtVw_recDescription);
                TextView txtVwHidden = view.findViewById(R.id.txtVw_hidden);
                ImageView img = view.findViewById(R.id.imgid);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("title", txtVw_recTitle.getText().toString());
                intent.putExtra("description", txtVwHidden.getText().toString());

                startActivity(intent);
            }
        });
    }
}