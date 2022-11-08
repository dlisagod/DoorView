package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ZtlApi.ZtlManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ZtlManager.GetInstance().setContext(this);
        findViewById(R.id.tv_01).setOnClickListener(view -> ZtlManager.GetInstance().openSystemBar(true));
        findViewById(R.id.tv_02).setOnClickListener(view -> ZtlManager.GetInstance().openSystemBar(false));
//        findViewById(R.id.tv_03).setOnClickListener(view -> ZtlManager.GetInstance().reboot(0));
        findViewById(R.id.tv_03).setOnClickListener(view -> startActivity(new Intent(this, MainActivity2.class)));
    }

}