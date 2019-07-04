package com.example.enotita_4_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = findViewById(R.id.listvw);

        ArrayList<String> recipies = new ArrayList<>();

        recipies.add("Pork Schnitzel");
        recipies.add("Creamy Chive Chicken");
        recipies.add("Quick Beef Ragu Spaghetti");
        recipies.add("Firecracker Meatballs");
        recipies.add("Cheesy Pork Sausage Flatbreads");
        recipies.add("Classic Spaghetti and Meatballs");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.list_item, recipies);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("title", textView.getText().toString());

                startActivity(intent);
            }
        });

    }
}