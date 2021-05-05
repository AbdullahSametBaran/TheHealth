package com.orkuncoskun.healthdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseUser;

public class BmiTestActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText heightEditText,weightEditText;
    private TextView resultTextView;

    @Override
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

    public void CalculateBMI(View view) {
        String heightStr = heightEditText.getText().toString();
        String weightStr = weightEditText.getText().toString();

        if (heightStr != null && !"".equals(heightStr) && weightStr !=null && !"".equals(weightStr)) {

            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);

            displayBMI(bmi);

        } else {

            Toast.makeText(this, "Height and Weight are required", Toast.LENGTH_SHORT).show();

        }


    }

    public void showMainMenuActivity(View view) {

        Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
        startActivity(intent);


    }

    private void displayBMI(float bmi) {

        String bmiLabel = "";

        if (Float.compare(bmi, 15f) <= 0) {

            bmiLabel = getString(R.string.very_severely_underweight);

        } else if (Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0) {

            bmiLabel = getString(R.string.severely_underweight);

        } else if (Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <= 0) {

            bmiLabel = getString(R.string.underweight);

        } else if (Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 25f) <= 0) {

            bmiLabel = getString(R.string.normal);

        } else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0) {

            bmiLabel = getString(R.string.overweight);

        } else if (Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <= 0) {

            bmiLabel = getString(R.string.obese_class_i);

        } else if (Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <= 0) {

            bmiLabel = getString(R.string.obese_class_ii);

        } else {

            bmiLabel = getString(R.string.obese_class_iii);

        }

        bmiLabel = bmi + "\n" + bmiLabel;
        resultTextView.setText(bmiLabel);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_test);
        setTitle("Bmi Test");

        ConstraintLayout backgroundConstraintLayout = (ConstraintLayout) findViewById(R.id.backgroundConstraintLayout);

        backgroundConstraintLayout.setOnClickListener(this);

        heightEditText = (EditText) findViewById(R.id.heightEditText);

        weightEditText = (EditText) findViewById(R.id.weightEditText);

        resultTextView = (TextView) findViewById(R.id.resultTextView);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.backgroundConstraintLayout) {

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

        }

    }
}
