package com.example.user.mother;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CustomerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);


        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");


        //  dbManager = new DBManager(getApplicationContext(), "Study.db", null, 1);

        // 버튼 따오는 구간 각각 버튼이 먼지는 잘 알거라 믿는다
        final ImageButton todayButton = (ImageButton) findViewById(R.id.todayButton);
        final ImageButton schduelButton = (ImageButton) findViewById(R.id.schduelButton);
        final ImageButton timmerButton = (ImageButton) findViewById(R.id.timmerButton);
        final ImageButton calandarButton = (ImageButton) findViewById(R.id.calandarButton);
        final ImageButton libraryButton = (ImageButton) findViewById(R.id.libraryButton);
        //   final ImageButton settingButton = (ImageButton) findViewById(R.id.settingButton);

        TextView nametag = (TextView) findViewById(R.id.nameTag);

        nametag.setText(name+"님의 생활정보");



        //투데이 버튼 누를때 화면 전환하기
        todayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent todayIntent = new Intent(CustomerActivity.this,ReviewActivity.class);
                CustomerActivity.this.startActivity(todayIntent);

            }
        });

        //스케쥴 버튼 누를때 화면 전환하기
        schduelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent schduelIntent = new Intent(CustomerActivity.this,SchduelActivity.class);
                CustomerActivity.this.startActivity(schduelIntent);

            }
        });

        //타이머 버튼 누를때 화면 전환하기
        timmerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent timmerIntent = new Intent(CustomerActivity.this,TimmerActivity.class);

                timmerIntent.putExtra("name",name);



                CustomerActivity.this.startActivity(timmerIntent);

            }
        });

        //캘린더 버튼 누를때 화면 전환하기
        calandarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sms = name+"님꼐 연락부탁드립니다.";

                try {
                    //전송
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("01086016710", null, sms, null, null);

                    Toast.makeText(getApplicationContext(), "전송 완료!", Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "SMS 권한 설정을 해주세요", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }
        });

        //도서관 버튼 누를때 화면 전환하기
        libraryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent libraryIntent = new Intent(CustomerActivity.this,LibraryActivity.class);
                CustomerActivity.this.startActivity(libraryIntent);

            }
        });




    }
}
