package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class RegisterActivity extends AppCompatActivity {


    private Button btnRegister;
    private EditText etFullName, etEmail, etPassword, etConfirmPassword, etPhone;
    private TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.btnRegister);
        etConfirmPassword =  findViewById(R.id.etConfirmPassword);
        etFullName =  findViewById(R.id.etFullName);
        etEmail =  findViewById(R.id.etEmail);
        etPhone =  findViewById(R.id.etPhone);
        etPassword =  findViewById(R.id.etPassword);
        tvLogin =  findViewById(R.id.tvLogin);

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ParseUser parseUser = new ParseUser();
                parseUser.setUsername(etFullName.getText().toString());
                parseUser.setPassword(etPassword.getText().toString());

                parseUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {

                        if (e == null) {
                            FancyToast.makeText(RegisterActivity.this, parseUser.get("Username") + " is signed up succesfully", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                        } else {
                            FancyToast.makeText(RegisterActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                        }
                    }
                });
            }
        });

    }
}
