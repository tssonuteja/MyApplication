package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Name = (EditText) findViewById(R.id.etName);
        Password = (EditText) findViewById(R.id.etPassword);
        Info = (TextView) findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.btnLogin);

        Info.setText("No of attempts remaining: ");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());

            }
        });
    }

    private void validate(String userName, String userPassword) {
        if ((userName.equals("Admin")) && (userPassword.equals("1234"))) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }


        if(userName.isEmpty() && userPassword.equals("1234"))
        {
            Name.setError("empty");
            Info.setText("EMPTY USERNAME");
        }
        else if(userName.equals("Admin") && userPassword.isEmpty()) {
            Password.setError("empty");
            Info.setText("Password is empty");
        }

        else if(userName.equals("Admin") && userPassword!="1234"){
            Password.setError("invalid password");
        }
        else if(userName!="Admin"&& userPassword.equals("1234")){
            Name.setError("invalid username");
        }


        else if(userName!="Admin" || userPassword!="1234"){

            Name.setError("invalid");
            Password.setError("invalid");

            //Info.setError("invalid credentials");
           Info.setText("invalid");



        }

        else{
            Info.setText("Success");
        }











    }
}




