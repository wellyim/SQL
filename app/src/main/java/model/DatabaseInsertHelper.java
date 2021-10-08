package model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import javax.sql.DataSource;

public class DatabaseInsertHelper extends SQLiteOpenHelper {

    Context context;
    private static final String dbname = "pratikumsqlite.db";
    private static final int dbversion = 1;
    private static final String tbl_mhs_ = "master_mahasiswa";
    private static final String tbl_mhs_id = "_id";
    private static final String tbl_mhs_nama = "nama";
    private static final String tbl_mhs_nim = "nim";
    private static final String tbl_mhs_umur = "umur";

    public DatabaseInsertHelper(@Nullable Context context){
        super(context, dbname, null, dbversion);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_table_mhs_ = "CREATE TABLE IF NOT EXISTS " + tbl_mhs_ + " ( "
                + tbl_mhs_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + tbl_mhs_nama + " TEXT,"
                + tbl_mhs_nim + " NUMERIC,"
                + tbl_mhs_umur + " TEXT);";
        try {
            sqLiteDatabase.execSQL(create_table_mhs_);
            Toast.makeText(context,"Database Berhasil Dibuat",
                    Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Database Gagal Dibuat",
                    Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + tbl_mhs_);
        onCreate(sqLiteDatabase);
    }

    public void insertData(String nama,int nim,int umur){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(tbl_mhs_nama,nama);
        cv.put(tbl_mhs_nim,nim);
        cv.put(tbl_mhs_umur,umur);
        long hasil = sqLiteDatabase.insert(tbl_mhs_,null,cv);
        if(hasil == -1){
            Toast.makeText(context,"Gagal Menyimpan Data",
                    Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Berhasil Menyimpan Data",
                    Toast.LENGTH_SHORT).show();
        }
    }

}
