package com.example.enotita_4_7;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<Recipe> recipes;

    public MyAdapter(Context context, ArrayList<Recipe> recipes) {
        this.context = context;
        this.recipes = recipes;
    }

    @Override
    public int getCount() {
        return this.recipes.size();
    }

    @Override
    public Object getItem(int position) {
        return recipes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return recipes.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        TextView txtVw_id = convertView.findViewById(R.id.txtVw_id);
        TextView txtVw_recTitle = convertView.findViewById(R.id.txtVw_recTitle);
        TextView txtVw_recDescription = convertView.findViewById(R.id.txtVw_recDescription);
        ImageView img = convertView.findViewById(R.id.imageView);

        Recipe recipe_pos = recipes.get(position);

        txtVw_id.setText(String.valueOf(recipe_pos.getId()));
        txtVw_recTitle.setText(recipe_pos.getRecTitle());
        txtVw_recDescription.setText(recipe_pos.getRecDescription().substring(0, 100));
        Picasso.with(context).load(recipes.get(position).getImg()).into(img);
        Picasso.with(context).setLoggingEnabled(true);

        return convertView;
    }
}
