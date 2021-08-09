package com.example.databasesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText editText;
TextView tv;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextTextPersonName);
        tv = findViewById(R.id.textView1);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = editText.getText().toString();
                SharedPreferences sp = getSharedPreferences("sp1",MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                ed.putString("name",val);
                ed.apply();
                tv.setText(val);
            }
        });

        SharedPreferences sp = getSharedPreferences("sp1",MODE_PRIVATE);
        String val = sp.getString("name","No value till now");
        tv.setText(val);
    }
}