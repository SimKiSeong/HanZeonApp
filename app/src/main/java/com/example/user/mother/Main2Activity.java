package com.example.user.mother;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {

    static DBManager dbManager;
    private static int ONE_MINUTE = 5626;


    private BackPressCloseHandler backPressCloseHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        dbManager = new DBManager(getApplicationContext(), "Study.db", null, 1);
        dbManager.getReadableDatabase();


        final ImageButton listButton = (ImageButton) findViewById(R.id.listButton);
        final ImageButton addButton = (ImageButton) findViewById(R.id.addButton);
        final ImageButton settingButton = (ImageButton) findViewById(R.id.settingButton);

        if(dbManager.first()){

            dbManager.insert("insert into KEPCO_LIST values(null, '" + "1807310001" + "','" + "김한전" + "','"+ "한국전력공사"+ "','"+ "941003" +"');");
            dbManager.insert("insert into KEPCO_LIST values(null, '" + "1807310002" + "','" + "김켑코" + "','"+ "전남대학교 공대7호관"+ "','"+ "941003" +"');");
            dbManager.insert("insert into KEPCO_LIST values(null, '" + "1807310003" + "','" + "박전력" + "','"+ "전남 순천시 조례동 남양휴튼"+ "','"+ "941003" +"');");
            dbManager.insert("insert into KEPCO_LIST values(null, '" + "1807310004" + "','" + "전력란" + "','"+ "주소"+ "','"+ "941003" +"');");
            dbManager.insert("insert into KEPCO_LIST values(null, '" + "1807310005" + "','" + "이래도" + "','"+ "주소"+ "','"+ "941003" +"');");

            Toast.makeText(getApplicationContext(), "성공적으로 추가되었습니다", Toast.LENGTH_SHORT).show();
        }


        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent todayIntent = new Intent(Main2Activity.this,ReviewActivity.class);
                Main2Activity.this.startActivity(todayIntent);

            }
        });


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent todayIntent = new Intent(Main2Activity.this,TodayActivity.class);
                Main2Activity.this.startActivity(todayIntent);

            }
        });


        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent todayIntent = new Intent(Main2Activity.this,SettingActivity.class);
                Main2Activity.this.startActivity(todayIntent);

            }
        });


    }




}


