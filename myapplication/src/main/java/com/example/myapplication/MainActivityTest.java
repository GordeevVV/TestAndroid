package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivityTest extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        setTitle("Home");
    }

    public void launchSettings(View view){
        Intent intent = new Intent(this, SettingsActivity.class);
        intent.putExtra("Cool", ((EditText)findViewById(R.id.writeMe)).getText().toString());
        startActivity(intent);

    }
}
