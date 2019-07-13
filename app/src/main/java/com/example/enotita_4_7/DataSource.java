package com.example.enotita_4_7;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DataSource {

    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;

    private String[] allColumns = {SQLiteHelper.COLUMN_ID, SQLiteHelper.COLUMN_TITLE, SQLiteHelper.COLUMN_DESCRIPTION, SQLiteHelper.COLUMN_IMAGE_URL};

    public DataSource(Context context) {
        dbHelper = new SQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public ArrayList<Recipe> getAllRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<>();

        Cursor cursor = database.query(SQLiteHelper.TABLE_RECIPES, allColumns, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Recipe recipe = new Recipe();
            recipe.setId(cursor.getInt(0));
            recipe.setRecTitle(cursor.getString(1));
            recipe.setRecDescription(cursor.getString(2));
            recipe.setImg(cursor.getString(3));

            recipes.add(recipe);

            cursor.moveToNext();
        }
        return recipes;
    }


    public Recipe getRecipe(String id) {
        Recipe recipe = new Recipe();

        Cursor cursor = database.query(SQLiteHelper.TABLE_RECIPES, allColumns, "id=?", new String[]{id}, null, null, null);

        cursor.moveToFirst();
        recipe.setId(Integer.valueOf(id));
        recipe.setRecTitle(cursor.getString(1));
        recipe.setRecDescription(cursor.getString(2));
        recipe.setImg(cursor.getString(3));

        return recipe;

    }
}
