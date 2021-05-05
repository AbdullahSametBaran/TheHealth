package com.orkuncoskun.healthdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.parse.ParseUser;

public class NutritionActivity extends AppCompatActivity {

    public void showBreakfastActivity(View view) {

        Intent intent = new Intent(getApplicationContext(), BreakfastActivity.class);
        startActivity(intent);

    }

    public void showLunchActivity(View view) {

        Intent intent = new Intent(getApplicationContext(), LunchActivity.class);
        startActivity(intent);

    }

    public void showDinnerActivity(View view) {

        Intent intent = new Intent(getApplicationContext(), DinnerActivity.class);
        startActivity(intent);

    }

    public void showSnacksActivity(View view) {

        Intent intent = new Intent(getApplicationContext(), SnacksActivity.class);
        startActivity(intent);

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.logout_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.logout) {

            ParseUser.logOut();

            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);

        setTitle("Nutrition");
    }
}
