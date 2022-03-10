package com.example.equipmentinspectionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText login_email_field;
    private EditText login_password_field;
    Button login_login_button;
    Button login_register_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_email_field = findViewById(R.id.login_email_field);
        login_password_field = findViewById(R.id.login_password_field);
        login_login_button = findViewById(R.id.login_login_button);
        login_register_button = findViewById(R.id.login_register_button);

        setupListeners();

    }

    private void setupListeners() {
        login_register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        login_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("ok", "yes");
                startActivity(intent);
            }
        });
    }

    private boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    private boolean isEmpty(EditText text) {
        CharSequence string = text.getText().toString();
        return TextUtils.isEmpty(string);
    }

    private void checkLogin(){
        boolean isValid = true;
          if (isEmpty(login_email_field)) {
              login_email_field.setError("Enter email !");
              isValid = false;
          } else {
              if (!isEmail(login_email_field)) {
                  login_email_field.setError("Enter valid email !");
                  isValid = false;
              }
          }
          if (isEmpty(login_password_field)) {
              login_password_field.setError("Enter password !");
              isValid = false;
          }
        if (isValid) {
            String emailValue = login_email_field.getText().toString();
            String passwordValue = login_password_field.getText().toString();



           /* if (emailValue.equals(email) && passwordValue.equals(password)) {
                Toast toast = Toast.makeText(this, "Login successfull", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                this.finish();
           } else {
                  Toast toast = Toast.makeText(this, "Wrong login", Toast.LENGTH_SHORT);
                  toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                  toast.show();
             }
             */
        }

    }
}