package com.example.rediexpressapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rediexpressapp.ApiBuilders.ApiBuilder;
import com.example.rediexpressapp.Model.Registration.RegistrationReq;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

public class MainActivitySignUp extends AppCompatActivity {

    EditText txtName;
    EditText txtPhone;
    EditText etxtEmail;
    EditText etxtpassword;
    EditText etxtRetryPassword;


    CheckBox checkBoxPolicy;

    Button ButtonSignUp;
    Button ButtonSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sign_up);

        txtPhone = findViewById(R.id.etxtphone);
        txtName = findViewById(R.id.etxtname);
        etxtEmail = findViewById(R.id.txtEmail);
        etxtpassword = findViewById(R.id.txtPassword);
        etxtRetryPassword = findViewById(R.id.txtPassword2);

        checkBoxPolicy = findViewById(R.id.cbPolicy);

        ButtonSignUp = findViewById(R.id.buttonSignUp);
        ButtonSignIn = findViewById(R.id.ButtonSignIn);

        txtName.addTextChangedListener(etxtButTF);
        txtPhone.addTextChangedListener(etxtButTF);
        etxtEmail.addTextChangedListener(etxtButTF);
        etxtpassword.addTextChangedListener(etxtButTF);
        etxtRetryPassword.addTextChangedListener(etxtButTF);


        ButtonSignUp.setEnabled(false);

        checkBoxPolicy.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {

                          if(checkBoxPolicy.isChecked()) {
                              ButtonSignUp.setEnabled(true);
                          }
                          else
                          {
                              ButtonSignUp.setEnabled(false);
                          }
                      }
                  });

        ButtonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivitySignUp.this, MainActivitySignIn.class);
                startActivity(i);
                finish();
            }
        });

        ButtonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!etxtpassword.getText().toString().trim().equals(etxtRetryPassword.getText().toString()))
                {
                    Toast.makeText(MainActivitySignUp.this, R.string.DontMatch, Toast.LENGTH_SHORT).show();
                }
                else
                {

                    RegistrationReq registrationReq = new RegistrationReq(etxtEmail.getText().toString(), etxtpassword.getText().toString());

                    ApiBuilder.getREPApi().postRegisterInfo("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InRod3p4a2FqY3Fscmt2dG9xaXVrIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDg5MzQ0OTEsImV4cCI6MjAyNDUxMDQ5MX0.8k6uBTbNsW-GBmFvacD_8_P1m4Z1F4Q7RKZzteMrz-w", registrationReq).enqueue(new Callback<RegistrationReq>() {
                        @Override
                        public void onResponse(Call<RegistrationReq> call, Response<RegistrationReq> response) {

                            if(response.code() == 429)
                            {
                                Toast.makeText(MainActivitySignUp.this, "Email rate limit exceeded", Toast.LENGTH_SHORT).show();
                            }
                            else if (response.code() == 200) {

                            Toast.makeText(MainActivitySignUp.this, "Confirm your email", Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(MainActivitySignUp.this, MainActivitySignIn.class);
                            i.putExtra("etxtName", txtName.getText().toString().trim());
                            i.putExtra("etxtPhone", txtPhone.getText().toString().trim());
                            startActivity(i);
                            finish();

                            }
                        }

                        @Override
                        public void onFailure(Call<RegistrationReq> call, Throwable t) {

                        }
                    });



                }


            }
        });


    }


    TextWatcher etxtButTF = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String userName = txtName.getText().toString().trim();
            String userPhone = txtPhone.getText().toString().trim();

            String userEmail = etxtEmail.getText().toString().trim();
            String userPassword = etxtpassword.getText().toString().trim();
            String userRetryPassword = etxtRetryPassword.getText().toString().trim();

            ButtonSignUp.setEnabled(!userName.isEmpty() && !userPhone.isEmpty() && !userEmail.isEmpty()
                    && !userPassword.isEmpty() && !userRetryPassword.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}