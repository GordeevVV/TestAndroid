package com.example.tabberion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityTestT extends AppCompatActivity {
    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
    }
    public void composeMessage(View view){
        Intent intent = new Intent(this, ComposeMessageActivity.class);
        String name = ((Button)view).getText().toString();
        intent.putExtra("name",name);
        startActivity(intent);
    }
}
