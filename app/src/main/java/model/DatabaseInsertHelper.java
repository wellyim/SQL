package model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import javax.sql.DataSource;

public class DatabaseInsertHelper extends SQLiteOpenHelper {

    Context context;
    private static final String dbname = "pratikumsql.db";
    private static final int dbversion = 5;
    private static final String tbl_mhs_ = "master_mahasiswa";
    private static final String tbl_mhs_id = "id";
    private static final String tbl_mhs_nama = "nama";
    private static final String tbl_mhs_nim = "nim";
    private static final String tbl_mhs_umur = "umur";

    private static final String tbl_user_transaction = "user_trans";
    private static final String tbl_user_id = "userid";
    private static final String tbl_user_nim = "usernim";
    private static final String tbl_user_pass= "password";

    public DatabaseInsertHelper(@Nullable Context context){
        super(context, dbname, null, dbversion);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_table_mhs_ = "CREATE TABLE IF NOT EXISTS " + tbl_mhs_ + " ( "
                + tbl_mhs_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + tbl_mhs_nama + " VARCHAR,"
                + tbl_mhs_nim + " INTEGER,"
                + tbl_mhs_umur + " INTEGER);";

        String create_table_user_ = "CREATE TABLE IF NOT EXISTS " + tbl_user_transaction + " ( "
                + tbl_user_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + tbl_user_nim + " INTEGER,"
                + tbl_user_pass + " VARCHAR);";
        try {
            sqLiteDatabase.execSQL(create_table_mhs_);
            sqLiteDatabase.execSQL(create_table_user_);
            Toast.makeText(context,"Database Berhasil Dibuat",
                    Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Database Gagal Dibuat",
                    Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + tbl_mhs_ );
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + tbl_user_transaction );
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
            Toast.makeText(context,"Gagal Menyimpan Data Mahasiswa",
                    Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Berhasil Menyimpan Data Mahasiswa",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void insertData2(int usernim, String password) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv2 = new ContentValues();
        cv2.put(tbl_user_nim,usernim);
        cv2.put(tbl_user_pass,password);

        long hasil2 = sqLiteDatabase.insert(tbl_user_transaction,null,cv2);
        if(hasil2 == -1){
            Toast.makeText(context,"Gagal Menyimpan Data TRANS",
                    Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Berhasil Menyimpan Data TRANS",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor SemuaMahasiswa(){
        String sql_mahasiswa = "SELECT * FROM " + tbl_mhs_;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(sql_mahasiswa, null);
        }

        return  cursor;
    }


}
