package com.example.turtle.subteapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameET;
    private EditText passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameET = findViewById(R.id.usernameET);
        passwordET = findViewById(R.id.passwordET);
        Button loginbtn = findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new LoginOnClickListener());

        if (!(loggedIn())){
            loginbtn.setOnClickListener(new LoginOnClickListener());
        }else{
            goToMainScreen();
        }
    }

    private boolean loggedIn() {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        return (sharedPreferences.contains("username") && sharedPreferences.contains("password"));
    }

    public class LoginOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String user = usernameET.getText().toString();
            String pw = passwordET.getText().toString();

            if (login(user,pw)){
                SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
                sharedPreferences.edit()
                        .putString("username", user)
                        .putString("password", pw)
                        .commit();
                goToMainScreen();
            }
        }
    }

    public void goToMainScreen(){
        Intent intent = new Intent(LoginActivity.this, MainScreenActivity.class);
        LoginActivity.this.startActivity(intent);
        finish();
    }

    public boolean login(String user, String password){
        return (user.equals("jorge1") && password.equals("12345"));
    }
}
