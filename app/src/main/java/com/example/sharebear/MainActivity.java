package com.example.sharebear;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText usernameInput;
    EditText passwordInput;
    TextView buckysText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Reference Variables
        usernameInput = (EditText) findViewById(R.id.usernameInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
        buckysText = (TextView) findViewById(R.id.buckysText);

    }

    //Save the users login info
    public void saveInfo(View view) {
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);  //userInfo file is only accessed by this activity         SharedPreferences.Editor editor = sharedPref.edit();
        SharedPreferences.Editor editor = sharedPref.edit();  //Edit the file
        editor.putString("username", usernameInput.getText().toString());//putString() takes value in key,value
        editor.putString("password", passwordInput.getText().toString());
        editor.apply();
        Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
    }

        //Print out the saved data
    public void displayData(View view){
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String name = sharedPref.getString("username", "");
        String pw = sharedPref.getString("password", "");
        buckysText.setText(name + " " + pw);
    }

}
