package com.example.equipmentinspectionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText register_email_field;
    private EditText register_password_field;
    private EditText register_name_field;
    private EditText register_firstname_field;

    Button register_register_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register_email_field = findViewById(R.id.register_email_field);
        register_password_field = findViewById(R.id.register_password_field);
        register_name_field = findViewById(R.id.register_name_field);
        register_register_button = findViewById(R.id.register_register_button);
        register_firstname_field = findViewById(R.id.register_firstname_field);

        setupListener();

    }

    private void setupListener() {
        register_register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //If all fields are completed, save new staff in database and return to login page
                if(checkFieldsCompletions()){

                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                else{
                    //If not, display error toast
                    Toast toast = Toast.makeText(RegisterActivity.this,"Please fill in all the fields !", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
            }
        });
    }

    private boolean isEmpty(EditText text) {
        CharSequence string = text.getText().toString();
        return TextUtils.isEmpty(string);
    }

    private boolean checkFieldsCompletions(){
        if(!isEmpty(register_firstname_field) && !isEmpty(register_name_field) && !isEmpty(register_email_field) && !isEmpty(register_password_field)){
            return true;
        }
        return false;
    }
}