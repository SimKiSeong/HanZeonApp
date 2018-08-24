package com.example.user.mother;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class CalandarActivity extends AppCompatActivity {

    //리스트 관련
    private ListView noticeListView;
    private  NoticeListAdapter adapter;
    private List<Notice> noticeList;

    //db관련
    DBManager dbManager = Main2Activity.dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calandar);



        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String getTime = sdf.format(date);
        makenotice();


        CalendarView calendar = (CalendarView) findViewById(R.id.calendarView);


        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int dayOfMonth) {
                Toast.makeText(CalandarActivity.this, "" + year + "-" +
                        (month + 1) + "-" + dayOfMonth, 0).show();

                String space = "";
                if (month < 9){
                    space = "0";
                }
                         String date = Integer.toString(year)+"-"+space+Integer.toString(month + 1) +"-"+ Integer.toString(dayOfMonth);

             //   makenotice(date);

            }
        });

        FloatingActionButton addbtn = (FloatingActionButton) findViewById(R.id.floatingaddBtn);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent schduelIntent = new Intent(CalandarActivity.this,TodayActivity.class);
                CalandarActivity.this.startActivity(schduelIntent);

            }
        });

    }

    public void makenotice(){

        Cursor cursor;
        cursor = dbManager.kepcoNotice();
        noticeListView = (ListView) findViewById(R.id.noticeListView);
        noticeList = new ArrayList<>();
        while(cursor.moveToNext()) {
            int num;
            String title;
            String content;
            String studydate;
            String seconddate;

            num =   cursor.getInt(0);
            title = cursor.getString(1);
            content = cursor.getString(2);
            studydate = cursor.getString(3);
            seconddate = cursor.getString(4);


            noticeList.add(new Notice(title,content,studydate,seconddate));


        }

        adapter = new NoticeListAdapter(getApplicationContext(),noticeList);
        noticeListView.setAdapter(adapter);

    }




}
