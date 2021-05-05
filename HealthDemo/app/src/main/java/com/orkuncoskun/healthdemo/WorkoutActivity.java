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

public class WorkoutActivity extends AppCompatActivity {

    public void showFullbodyActivity(View view) {

        Intent intent = new Intent(getApplicationContext(), FullbodyActivity.class);
        startActivity(intent);

    }

    public void showSplitActivity(View view) {

        Intent intent = new Intent(getApplicationContext(), SplitActivity.class);
        startActivity(intent);

    }

    public void showPushPullActivity(View view) {

        Intent intent = new Intent(getApplicationContext(), PushPullActivity.class);
        startActivity(intent);

    }

    public void showUpperLowerActivity(View view) {

        Intent intent = new Intent(getApplicationContext(), UpperLowerActivity.class);
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
        setContentView(R.layout.activity_workout);

        setTitle("Workout");
    }
}
