package com.example.databasesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class dbActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        DbHandler handler = new DbHandler(this,"empdb",null,1);
//        handler.addEmployee(new Employee(10,"Amit",25.25));
//        handler.getEmployee(1);
//        handler.deleteEmployee(6);
        handler.updateEmployee(1);
        handler.getEmployee(1);
        handler.close();
    }
}