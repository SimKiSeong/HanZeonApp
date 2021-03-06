package com.example.user.mother;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 2018-01-02.
 */

public class DBManager extends SQLiteOpenHelper {

public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
    super(context, name, factory, version);
}





    @Override
    public void onCreate(SQLiteDatabase db) {
    // 새로운 태이블 생성하는 곳
        // create table 태이블 명(컬럼명 타입 옵션);
        // STUDY_LIST라는 테이블은 자동 값 증가하는 id컬럼, title이라는 택스트, content이라는 택스트, 날짜

        db.execSQL("CREATE TABLE STUDY_LIST(_id INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT,content TEXT,studydate TEXT, nextdate TEXT)");
        db.execSQL("CREATE TABLE TIMETABLE_LIST(_id INTEGER PRIMARY KEY AUTOINCREMENT, ttTitle TEXT, ttTime TEXT, ttRoom TEXT, ttProfes TEXT)");

        db.execSQL("CREATE TABLE CUSTOMER_LIST(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, address TEXT, number TEXT, birth TEXT ,state TEXT,time TEXT)");

        db.execSQL("CREATE TABLE USE_ELE(_id INTEGER PRIMARY KEY AUTOINCREMENT, one INTEGER, two INTEGER, three INTEGER, four INTEGER, five INTEGER, six INTEGER, seven INTEGER, eight INTEGER, nine INTEGER, ten INTEGER, eleven INTEGER, twelve INTEGER)");

        db.execSQL("CREATE TABLE KEPCO_LIST(_id INTEGER PRIMARY KEY AUTOINCREMENT, number TEXT, name TEXT, address TEXT, birth TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // insert 함수
    public void insert(String _query){
    SQLiteDatabase db = getWritableDatabase();
    db.execSQL(_query);
    db.close();
    }

    public void update(String _query){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public void delete(String _query){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }


    public String PrintData(){
        SQLiteDatabase db = getReadableDatabase();
        String str = "";

        Cursor cursor = db.rawQuery("select * from STUDY_LIST", null);
        while(cursor.moveToNext()) {


            str += /*cursor.getInt(0)
                    +*/ "  제목 : "
                    + cursor.getString(1)
                    + ", 내용 : "
                    + cursor.getString(2)
                    + ",공부 날짜 : "
                    + cursor.getString(3)
                    + ",복습 날짜 : "
                    + cursor.getString(4)
                    + "\n";
        }


        return str;
}

    public String PrintData2(){
        SQLiteDatabase db = getReadableDatabase();
        String str = "";

        Cursor cursor = db.rawQuery("select * from TIMETABLE_LIST", null);
        while(cursor.moveToNext()) {


            str +=
                    " 과목 : "
                    + cursor.getString(1)
                    + " , 시간 : "
                    + cursor.getString(2)
                    + ", 장소 : "
                    + cursor.getString(3)
                    + ", 교수명 : "
                    + cursor.getString(4)
                    + "\n";
        }


        return str;




    }
    public String PrintData3(){
        SQLiteDatabase db = getReadableDatabase();
        String str = "";

        Cursor cursor = db.rawQuery("select * from TIMETABLE_LIST", null);
        while(cursor.moveToNext()) {


            str +=  cursor.getString(2)
                    + ","
                    + cursor.getString(1)
                    + ",";
        }


        return str;




    }

    public Boolean first(){
        SQLiteDatabase db = getReadableDatabase();
        String str = "";
        boolean first = true;
        Cursor cursor = db.rawQuery("select * from KEPCO_LIST", null);

        while(cursor.moveToNext()) {

            str +=  cursor.getString(2)
                    + ","
                    + cursor.getString(1)
                    + ",";

            first = false;
        }


        return first;
    }


    public Cursor kepcoNotice(){
        SQLiteDatabase db = getReadableDatabase();
        String str = "";


        Cursor cursor = db.rawQuery("select * from KEPCO_LIST", null);


        return cursor;
    }



    public Cursor userNotice(){
        SQLiteDatabase db = getReadableDatabase();
        String str = "";


        Cursor cursor = db.rawQuery("select * from CUSTOMER_LIST", null);


        return cursor;
    }




    public Cursor dateNotice(){
        SQLiteDatabase db = getReadableDatabase();
        String str = "";


        Cursor cursor = db.rawQuery("select * from STUDY_LIST", null);


        return cursor;
    }

}
