package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sqlite.ListMahasiswaBaseAdapter.ListMahasiswaBaseAdapter;

import java.util.ArrayList;

import model.DatabaseInsertHelper;

public class DaftarMahasiswa extends AppCompatActivity {

    DatabaseInsertHelper myDb;
    ArrayList<String> _id, nama, nim, umur;
    ListView listMahasiwa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_mahasiswa);
        listMahasiwa = findViewById(R.id.listMahasiwa);

        myDb = new DatabaseInsertHelper(DaftarMahasiswa.this);
        _id  = new ArrayList<>();
        nama = new ArrayList<>();
        nim  = new ArrayList<>();
        umur = new ArrayList<>();
        displayData();

        ListMahasiswaBaseAdapter listMahasiswaBaseAdapter = new ListMahasiswaBaseAdapter(DaftarMahasiswa.this,_id,nama,nim,umur);
        listMahasiwa.setAdapter(listMahasiswaBaseAdapter);
    }

    private void displayData() {
        Cursor cursor = myDb.SemuaMahasiswa();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"Data Mahasiswa Kosong!", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                _id.add(cursor.getString(0));
                nama.add(cursor.getString(1));
                nim.add(cursor.getString(2));
                umur.add(cursor.getString(3));
            }
        }

    }


}