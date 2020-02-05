package com.tamasszuhanszky.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view){

        EditText myUserTextField = (EditText)findViewById(R.id.myUserTextField);
        EditText myPwTextField = (EditText)findViewById(R.id.myPwTextField);

        Toast.makeText(this, "Hi there, " + myUserTextField.getText().toString() + "!", Toast.LENGTH_LONG).show();

        ImageView imageView = (ImageView)findViewById(R.id.pikaImageView);
        imageView.setVisibility(View.VISIBLE);

        Log.i("Info", "User name: " + myUserTextField.getText().toString() + "; Password: " + myPwTextField.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
