package com.example.pienyritysappi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void logInButtonClicked(View view)
    {

    }

    public void registerCustomerButtonClicked(View view)
    {
        Intent intent = new Intent(getApplicationContext(),Register.class);
        startActivity(intent);
    }

    public void registerCompanyButtonClicked(View view)
    {
        Intent intent = new Intent(getApplicationContext(),Register.class);
        startActivity(intent);
    }
}