package com.milanps.martialartsclub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMartialArtActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtPrice;
    EditText edtColor;
    Button btnAddMartialArt;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_martial_art);

        edtName = (EditText) findViewById(R.id.edtName);
        edtPrice = (EditText) findViewById(R.id.edtPrice);
        edtColor = (EditText) findViewById(R.id.edtColor);

        btnAddMartialArt = (Button) findViewById(R.id.btnAddMartialArt);
        btnBack = (Button) findViewById(R.id.btnGoBack);


    }
}
