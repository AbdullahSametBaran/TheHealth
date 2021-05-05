package com.orkuncoskun.healthdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {

    Boolean signUpModeActive = true;

    TextView changeSignUpModeTextView;

    EditText passwordEditText;

    public void showMainMenuActivity() {

        Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
        startActivity(intent);

    }

    public void showBmiTestActivity() {

        Intent intent = new Intent(getApplicationContext(), BmiTestActivity.class);
        startActivity(intent);

    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {

        if (keyCode == event.KEYCODE_ENTER && event.getAction() == event.ACTION_DOWN) {

            signUp(v);

        }

        return false;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.changeSignUpModeTextView) {

            Button signUpButton = (Button) findViewById(R.id.signUpButton);

            if (signUpModeActive) {

                signUpModeActive = false;
                signUpButton.setText("Login");
                changeSignUpModeTextView.setText("Or, Sign Up");

            } else {

                signUpModeActive = true;
                signUpButton.setText("Sign Up");
                changeSignUpModeTextView.setText("Or, Login");


            }

        } else if (v.getId() == R.id.backgroundConstraintLayout) {

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

        }

    }

    public void signUp(View view) {

        EditText usernameEditText = (EditText) findViewById(R.id.usernameEditText);

        if (usernameEditText.getText().toString().matches("") || passwordEditText.getText().toString().matches("")) {

            Toast.makeText(this, "A username and password are required", Toast.LENGTH_SHORT).show();

        } else {

            if (signUpModeActive) {

                ParseUser user = new ParseUser();

                user.setUsername(usernameEditText.getText().toString().trim());
                user.setPassword(passwordEditText.getText().toString().trim());

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {

                        if (e == null) {

                            //Log.i("Sign Up", "Successful");

                            showBmiTestActivity();

                        } else {

                            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                        }

                    }
                });

            } else {

                ParseUser.logInInBackground(usernameEditText.getText().toString().trim(), passwordEditText.getText().toString().trim(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {

                        if (user != null) {

                            //Log.i("Sign Up", "Login Successful");

                            showMainMenuActivity();

                        } else {

                            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                        }

                    }
                });

            }

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Health");

        changeSignUpModeTextView = (TextView) findViewById(R.id.changeSignUpModeTextView);

        changeSignUpModeTextView.setOnClickListener(this);

        ConstraintLayout backgroundConstraintLayout = (ConstraintLayout) findViewById(R.id.backgroundConstraintLayout);

        backgroundConstraintLayout.setOnClickListener(this);

        passwordEditText = (EditText) findViewById(R.id.passwordEditText);

        passwordEditText.setOnKeyListener(this);


        //if we already logged in it will directly go to the profile activity
        if (ParseUser.getCurrentUser() != null) {

            showMainMenuActivity();

        }

        ParseAnalytics.trackAppOpenedInBackground(getIntent());

        // Add this line and run your application
        //ParseUser.getCurrentUser().logOut();
    }

}