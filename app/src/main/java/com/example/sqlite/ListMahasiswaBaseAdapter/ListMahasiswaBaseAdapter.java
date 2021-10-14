package com.example.sqlite.ListMahasiswaBaseAdapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sqlite.R;

import java.util.ArrayList;

public class ListMahasiswaBaseAdapter extends BaseAdapter {

    Context context;
    ArrayList _id,nama,nim,umur;
    LayoutInflater inflter;
    public ListMahasiswaBaseAdapter(Context context, ArrayList _id, ArrayList nama, ArrayList nim, ArrayList umur) {
        this.context = context;
        this._id = _id;
        this.nama = nama;
        this.nim = nim;
        this.umur = umur;
        inflter = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return _id.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView _id_txt,nama_mhs_txt,nim_mhs_txt,umur_mhs_txt;
        view = inflter.inflate(R.layout.item_list,null);

        _id_txt = view.findViewById(R.id._id);
        nama_mhs_txt = view.findViewById(R.id.nama_mhs);
        nim_mhs_txt = view.findViewById(R.id.nim_mhs);
        umur_mhs_txt = view.findViewById(R.id.umur_mhs);

        _id_txt.setText(String.valueOf(_id.get(i)));
        nama_mhs_txt.setText(String.valueOf(nama.get(i)));
        nim_mhs_txt.setText(String.valueOf(nim.get(i)));
        umur_mhs_txt.setText(String.valueOf(umur.get(i)));


        return view;


    }
}
