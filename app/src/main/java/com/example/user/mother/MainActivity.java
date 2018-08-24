package com.example.user.mother;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //static DBManager dbManager;

    private BackPressCloseHandler backPressCloseHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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



        //투데이 버튼 누를때 화면 전환하기
        todayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent todayIntent = new Intent(MainActivity.this,ReviewActivity.class);
                MainActivity.this.startActivity(todayIntent);

            }
        });

        //스케쥴 버튼 누를때 화면 전환하기
        schduelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent schduelIntent = new Intent(MainActivity.this,SchduelActivity.class);
                MainActivity.this.startActivity(schduelIntent);

            }
        });

        //타이머 버튼 누를때 화면 전환하기
        timmerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent timmerIntent = new Intent(MainActivity.this,TimmerActivity.class);

                String goname = "한전";


                Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();//Display toast if edittext is empty
             //   MainActivity.this.startActivity(timmerIntent);

            }
        });

        //캘린더 버튼 누를때 화면 전환하기
        calandarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calandarIntent = new Intent(MainActivity.this,CalandarActivity.class);
                MainActivity.this.startActivity(calandarIntent);

            }
        });

        //도서관 버튼 누를때 화면 전환하기
        libraryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent libraryIntent = new Intent(MainActivity.this,LibraryActivity.class);
                MainActivity.this.startActivity(libraryIntent);

            }
        });


        //설정버튼 누를 때 전환하기

   /*     settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settingIntent = new Intent(MainActivity.this,SettingActivity.class);
                MainActivity.this.startActivity(settingIntent);
            }
        });

*/
       backPressCloseHandler = new BackPressCloseHandler(this);



    }
   @Override
public void onBackPressed() {
        backPressCloseHandler.onBackPressed();
    }





}
