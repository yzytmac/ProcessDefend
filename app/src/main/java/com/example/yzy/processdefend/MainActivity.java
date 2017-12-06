package com.example.yzy.processdefend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static MainActivity instance=null;
    public static MainActivity getInstance(){
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;
        startService(new Intent(this,AService.class));
        startService(new Intent(this,BService.class));
        Toast.makeText(this, "干死我呀,死了算我输", Toast.LENGTH_SHORT).show();
    }


}
