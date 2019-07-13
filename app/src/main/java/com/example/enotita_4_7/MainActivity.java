package com.example.enotita_4_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = findViewById(R.id.listvw);

        DataSource source = new DataSource(MainActivity.this);

        source.open();
        final ArrayList<Recipe> recipes = source.getAllRecipes();
        source.close();

        MyAdapter adapter = new MyAdapter(MainActivity.this, recipes);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtVw_id = view.findViewById(R.id.txtVw_id);
                TextView txtVw_recTitle = view.findViewById(R.id.txtVw_recTitle);
                TextView txtVwDesc = view.findViewById(R.id.txtVw_recDescription);
                ImageView img = view.findViewById(R.id.imageView);
                //img.buildDrawingCache();
                //Bitmap bitmap = img.getDrawingCache();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("title", txtVw_recTitle.getText().toString());
                intent.putExtra("description", recipes.get(position).getRecDescription());
                intent.putExtra("id", txtVw_id.getText().toString());
                //intent.putExtra("image", bitmap);

                startActivity(intent);
            }
        });
    }
}