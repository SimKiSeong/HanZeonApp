package com.example.user.mother;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TimmerActivity extends AppCompatActivity {

    static DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timmer);


        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");




        dbManager = Main2Activity.dbManager;

        String birth = "941003";
        String address = "한국전력공사";
        String time = "12";


        Cursor cursor;
        cursor = dbManager.userNotice();

        while (cursor.moveToNext()) {
            int k_num;
            String k_number;
            String k_name;
            String k_address;
            String k_birth;
            String k_state;
            String k_time;

            k_num = cursor.getInt(0); // 키
            k_number = cursor.getString(1); // 이름
            k_name = cursor.getString(2); // 주소
            k_address = cursor.getString(3); // 숫자
            k_birth = cursor.getString(4); // 생일
            k_state = cursor.getString(5); // 상태
            k_time = cursor.getString(6); //시간



            // 이름, 주소, 생일, 상태;
                if(k_number.equals(name)) {
                    birth = k_birth;
                    address = k_name;
                    time = k_time;
                }
                }







        // DB에 저장 될 속성을 입력받는다
        final TextView etTitle = (TextView) findViewById(R.id.et_title); // 이름
        final TextView etstudyDate = (TextView) findViewById(R.id.et_studydate); // 생년월일
        final EditText etaddress = (EditText) findViewById(R.id.et_address); // 주소
        final EditText ettime = (EditText) findViewById(R.id.et_time); // 반응시간

        //String temp =birth;
        //String temp2 =birth;
        //String temp3 =birth;
       // birth = "19"+temp.substring(0,2)+"년 "+temp2.substring(2,5)+"월 "+temp3.substring(5,7)+"일";

        // 쿼리 결과 입력
        final TextView tvResult = (TextView) findViewById(R.id.tv_result);

        etTitle.setText(name);
        etstudyDate.setText(birth);
        etaddress.setText(address);
        ettime.setText(time);



        etaddress.setInputType(0);

        etaddress.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                // TODO Auto-generated method stub

                etaddress.setInputType(1);

                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

                mgr.showSoftInput(etaddress, InputMethodManager.SHOW_IMPLICIT);

            }

        });





        // Insert
        Button btnInsert = (Button) findViewById(R.id.btn_insert);
        btnInsert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                // insert into 테이블명 values (값, 값, 값...);

                String address = etaddress.getText().toString();
                String time = ettime.getText().toString();



                dbManager.update("UPDATE CUSTOMER_LIST SET time = '"+time+"' WHERE name = '"+name+"';");
                dbManager.update("UPDATE CUSTOMER_LIST SET address = '"+address+"' WHERE name = '"+name+"';");

                            tvResult.setText(dbManager.PrintData());


                            Toast.makeText(getApplicationContext(), "수정 되었습니다", Toast.LENGTH_SHORT).show();


                            Intent newintent = new Intent(TimmerActivity.this, CustomerActivity.class);



                newintent.putExtra("name",name);

                TimmerActivity.this.startActivity(newintent);
                TimmerActivity.this.onStop();


            }
        });


    }

}
