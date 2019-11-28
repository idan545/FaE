package com.example.fae;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText pNumber;
    Intent t;
    FirebaseAuth fbA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        pNumber = (EditText) findViewById(R.id.editText);
        fbA = FirebaseAuth.getInstance();
    }

    public void createAccount() {

    }
}
