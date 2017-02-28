package com.example.bloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class CreateList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);

        Spinner spinner = (Spinner) findViewById(R.id.blood_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.blood_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    public void openHome(View view) {
        EditText name_value = (EditText) findViewById(R.id.name);
        EditText loc_value = (EditText) findViewById(R.id.location);

        if (name_value.getText().length() == 0 || loc_value.getText().length() == 0) {
            Toast.makeText(CreateList.this, "The fields have not been completed!", Toast.LENGTH_SHORT).show();
        }

        else{
            Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);

            Toast.makeText(CreateList.this, "Your account has been added! You can now login :)", Toast.LENGTH_SHORT).show();
        }
    }
}
