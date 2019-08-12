package com.milanps.martialartsclub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AddMartialArtActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_martial_art);

        Toast.makeText(AddMartialArtActivity.this, "This is add Martial Art Activity", Toast.LENGTH_SHORT).show();
    }
}
