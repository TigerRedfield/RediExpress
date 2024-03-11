package com.example.rediexpressapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rediexpressapp.ApiBuilders.ApiBuilder;
import com.example.rediexpressapp.Model.Auth.ForgetPasswordReq;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityForgotPassword extends AppCompatActivity {

    EditText etxtEmail;
    Button butReset;

    Button butSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_forgot_password);

        butReset = findViewById(R.id.buttonForgotPassword);

        etxtEmail = findViewById(R.id.txtEmail);

        etxtEmail.addTextChangedListener(txtemail);

        butSignIn = findViewById(R.id.butSignInNotForget);

        butReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ForgetPasswordReq forgetPasswordReq = new ForgetPasswordReq(etxtEmail.getText().toString().trim());

                ApiBuilder.getREPApi().PostForgetPassInfo("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InRod3p4a2FqY3Fscmt2dG9xaXVrIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDg5MzQ0OTEsImV4cCI6MjAyNDUxMDQ5MX0.8k6uBTbNsW-GBmFvacD_8_P1m4Z1F4Q7RKZzteMrz-w", forgetPasswordReq).enqueue(new Callback<ForgetPasswordReq>() {
                    @Override
                    public void onResponse(Call<ForgetPasswordReq> call, Response<ForgetPasswordReq> response) {
                        if(response.code() == 200)
                        {
                            Intent i = new Intent(MainActivityForgotPassword.this, MainActivityOTPVerif.class);
                            i.putExtra("EmailEditText", etxtEmail.getText().toString());
                            startActivity(i);
                            finish();
                        }
                        else if(response.code() == 429)
                        {
                            Toast.makeText(MainActivityForgotPassword.this, "Wait one minute to resend", Toast.LENGTH_SHORT );
                        }
                    }

                    @Override
                    public void onFailure(Call<ForgetPasswordReq> call, Throwable t) {

                    }
                });

            }
        });


        butSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivityForgotPassword.this, MainActivitySignIn.class);
                startActivity(i);
                finish();
            }
        });





    }



    TextWatcher txtemail = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String userEmail = etxtEmail.getText().toString().trim();

            butReset.setEnabled(!userEmail.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}