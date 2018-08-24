package com.example.user.mother;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReviewActivity extends AppCompatActivity {
    //리스트 관련
    private ListView noticeListView;
    private  NoticeListAdapter adapter;
    private List<Notice> noticeList;

    private ListView secondnoticeListView;
    private  SecondNoticeListAdapter Secondadapter;

    //db관련
    DBManager dbManager = Main2Activity.dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);


        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String getTime = sdf.format(date);
        makesecondnotice();

    }

    public void makesecondnotice() {

        Cursor cursor;
        cursor = dbManager.userNotice();
        secondnoticeListView = (ListView) findViewById(R.id.secondnoticeListView);
        noticeList = new ArrayList<>();

        while (cursor.moveToNext()) {
            int num;
            String number;
            String name;
            String address;
            String birth;
            String state;
            String time;

            num = cursor.getInt(0); // 키
            number = cursor.getString(1); // 이름
            name = cursor.getString(2); // 주소
            address = cursor.getString(3); // 숫자
            birth = cursor.getString(4); // 생일
            state = cursor.getString(5); // 상태
            time = cursor.getString(6); // 시간

            //String temp =birth;
            //String temp2 =birth;
            //String temp3 =birth;
            //birth = "19"+temp.substring(0,2)+"년 "+temp2.substring(2,5)+"월 "+temp3.substring(5,7)+"일";


            // 이름, 주소, 생일, 상태;
            noticeList.add(new Notice(number, state, birth, name));


        }


        Secondadapter = new SecondNoticeListAdapter(getApplicationContext(), noticeList);
        secondnoticeListView.setAdapter(Secondadapter);

        secondnoticeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String intentName = noticeList.get(position).notice;

                Intent newIntent = new Intent(ReviewActivity.this,CustomerActivity.class);
                newIntent.putExtra("name",intentName);

                ReviewActivity.this.startActivity(newIntent);

            }
        });



    }
}





    /*
    public void makesecondnotice(String date) {

        Cursor cursor;
        cursor = dbManager.dateNotice();
        secondnoticeListView = (ListView) findViewById(R.id.secondnoticeListView);
        noticeList = new ArrayList<>();
        while (cursor.moveToNext()) {
            int num;
            String title;
            String content;
            String studydate;
            String seconddate;

            num = cursor.getInt(0);
            title = cursor.getString(1);
            content = cursor.getString(2);
            studydate = cursor.getString(3);
            seconddate = cursor.getString(4);

            if (seconddate.equals(date)) {
                noticeList.add(new Notice(title, content, studydate, seconddate));

            }
        }
        Secondadapter = new SecondNoticeListAdapter(getApplicationContext(), noticeList);
        secondnoticeListView.setAdapter(Secondadapter);


    }
    */

