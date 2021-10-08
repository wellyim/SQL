package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import model.DatabaseInsertHelper;

public class MainActivity extends AppCompatActivity {

    Button simpan;
    EditText input_nama,input_nim,input_umur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpan = findViewById(R.id.simpan);
        input_nama = findViewById(R.id.name);
        input_nim = findViewById(R.id.nim);
        input_umur = findViewById(R.id.umur);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = input_nama.getText().toString();
                int nim =  Integer.parseInt(input_nim.getText().toString());
                int umur = Integer.parseInt(input_umur.getText().toString());
                DatabaseInsertHelper db = new DatabaseInsertHelper(MainActivity.this);
                db.insertData(nama,nim,umur);

            }
        });


    }
}