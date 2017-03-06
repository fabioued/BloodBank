package com.example.bloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.id.message;
import static com.example.bloodbank.R.id.username;

public class Dashboard extends AppCompatActivity {
    public String Username;
    public String Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Bundle bundle = getIntent().getExtras();
        Username = bundle.getString("uname");
        Password = bundle.getString("pass");

        TextView hello_text = (TextView) findViewById(R.id.welcome_text);
        hello_text.setText("Hello " + Username + "!");
    }

    public void openEditProfile(View view){
        Intent i = new Intent(this,EditProfile.class);
        i.putExtra("uname", Username);
        i.putExtra("pass", Password);
        startActivity(i);
    }

    public void openCreateList(View view){
        Intent i = new Intent(this,DonorList.class);
        startActivity(i);
    }
}
