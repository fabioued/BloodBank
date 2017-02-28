package com.example.bloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void openDonorList(View view){
        Intent i = new Intent(this,DonorList.class);
        startActivity(i);
    }

    public void openCreateList(View view){
        Intent i = new Intent(this,CreateList.class);
        startActivity(i);
    }
}
