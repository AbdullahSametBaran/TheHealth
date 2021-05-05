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

public class MainMenuActivity extends AppCompatActivity {

    public void showNutritionActivity(View view) {

        Intent intent = new Intent(getApplicationContext(), NutritionActivity.class);
        startActivity(intent);

    }

    public void showStretchActivity(View view) {

        Intent intent = new Intent(getApplicationContext(), StretchActivity.class);
        startActivity(intent);

    }

    public void showWorkoutActivity(View view) {

        Intent intent = new Intent(getApplicationContext(), WorkoutActivity.class);
        startActivity(intent);

    }

    public void showHintActivity(View view) {

        Intent intent = new Intent(getApplicationContext(), HintActivity.class);
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
        setContentView(R.layout.activity_main_menu);

        setTitle("Main Menu");
    }
}
