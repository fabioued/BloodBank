package com.example.bloodbank;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import static com.example.bloodbank.R.id.aller_field;
import static com.example.bloodbank.R.id.username;

public class EditProfile extends AppCompatActivity {
    public String Username;
    public String Password;
    public JSONObject edit_results;

    public String uname;
    public String pass;
    public String name;
    public String blood_t;
    public String location;
    public String allergies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        //Getting the data from the previous Intent and disabling textfields
        Bundle bundle = getIntent().getExtras();
        Username = bundle.getString("uname");
        Password = bundle.getString("pass");
        (findViewById(R.id.uname_field)).setEnabled(false);
        (findViewById(R.id.bloodtype_field)).setEnabled(false);

        //The URL to which GET request is sent
        String GETDATA_URL = ("http://dheerajprojects.gear.host/web_server.php?login=''&username='" + Uri.encode(Username) + "'&password=\"" + Uri.encode(Password) + "\"");

        //Contact the server to get the data from the server
        StringRequest stringRequest = new StringRequest(Request.Method.GET, GETDATA_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            edit_results = new JSONObject(response);

                            uname = edit_results.getString("UserName");
                            pass = edit_results.getString("Password");
                            name = edit_results.getString("Name");
                            blood_t = edit_results.getString("BloodType");
                            location = edit_results.getString("Location");
                            allergies = edit_results.getString("Allergies");

                            ((EditText) findViewById(R.id.uname_field)).setText(uname);
                            ((EditText) findViewById(R.id.pass_field)).setText(pass);
                            ((EditText) findViewById(R.id.name_field)).setText(name);
                            ((EditText) findViewById(R.id.bloodtype_field)).setText(blood_t);
                            ((EditText) findViewById(R.id.loc_field)).setText(location);
                            ((EditText) findViewById(R.id.aller_field)).setText(allergies);
                        }

                        catch (Exception e){
                            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
                    }
                });

        //Add the server request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void ModifyDetails(View view){
        uname = ((EditText) findViewById(R.id.uname_field)).getText().toString();
        pass = ((EditText) findViewById(R.id.pass_field)).getText().toString();
        name = ((EditText) findViewById(R.id.name_field)).getText().toString();
        blood_t = ((EditText) findViewById(R.id.bloodtype_field)).getText().toString();
        location = ((EditText) findViewById(R.id.loc_field)).getText().toString();
        allergies = ((EditText) findViewById(R.id.aller_field)).getText().toString();

        String MODIFY_URL = ("http://dheerajprojects.gear.host/web_server.php?modify=''&username='" + Uri.encode(Username) + "'&mpass=\"" + pass + "\"&mname='" + name + "'&mblood='" + blood_t + "'&mloc='" + location + "'&maller='" + allergies + "'");

        //Contact the server to modify the data from the server
        StringRequest stringRequest = new StringRequest(Request.Method.GET, MODIFY_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
                    }
                });

        //Add the server request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
