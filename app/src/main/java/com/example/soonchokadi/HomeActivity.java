package com.example.soonchokadi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

FirebaseFirestore db = FirebaseFirestore.getInstance();
public class HomeActivity extends AppCompatActivity {

    public void  online(View v){

        Intent send = new Intent(HomeActivity.this, MainActivity.class);
        startActivity(send);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}