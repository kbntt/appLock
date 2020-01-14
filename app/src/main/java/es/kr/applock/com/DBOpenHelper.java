package es.kr.applock.com;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper {
    private static final String DATABASE_NAME = "applock.db";
    private static final int DATABASE_VERSION = 1;
    private Context context;
    private DatabaseHelper dbHelper;
    public static SQLiteDatabase db;

    private class DatabaseHelper extends SQLiteOpenHelper{

        public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context,name,factory,version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(DataBase.CreateAppLockTable.CREATE_SQL);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+DataBase.CreateAppLockTable.TABLE_NAME);
            onCreate(sqLiteDatabase);
        }
    }

    public DBOpenHelper(Context context){
        this.context = context;
    }
    public DBOpenHelper open() throws SQLException {
        dbHelper = new DatabaseHelper(context, DATABASE_NAME, null,DATABASE_VERSION );
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public boolean selectTable(String tableName){
        boolean result = true;
        if( db != null){
            System.out.println("select Table db != null");
            String sql ="SELECT name FROM sqlite_master WHERE type='table' AND name = '"+tableName+"'";
            Cursor cursor = db.rawQuery(sql,null);
            cursor.moveToFirst();
            System.out.println("====================================");
            System.out.println(sql);
            System.out.println(cursor.getCount());
            if( cursor.getCount() > 0){
                result = true;
            }else{
                result = false;
            }

        }else{
            System.out.println("selectTable db == null");
        }

        return result;
    }

}
