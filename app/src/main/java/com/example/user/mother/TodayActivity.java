package com.example.user.mother;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class TodayActivity extends AppCompatActivity {

    static DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);

        dbManager = Main2Activity.dbManager;

        // DB에 저장 될 속성을 입력받는다
        final EditText etTitle = (EditText) findViewById(R.id.et_title);

        final EditText etstudyDate = (EditText) findViewById(R.id.et_studydate);


        etTitle.setInputType(0);

        etTitle.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                // TODO Auto-generated method stub

                etTitle.setInputType(1);

                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

                mgr.showSoftInput(etTitle, InputMethodManager.SHOW_IMPLICIT);

            }

        });








        // 쿼리 결과 입력
        final TextView tvResult = (TextView) findViewById(R.id.tv_result);

        // Insert
        Button btnInsert = (Button) findViewById(R.id.btn_insert);
        btnInsert.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // insert into 테이블명 values (값, 값, 값...);
                String title = etTitle.getText().toString();
                String name = "심퀴";
                String address = "주소";
                String state = "안전";
                String studydate = etstudyDate.getText().toString();


                if (!title.equals("") && title.length() > 0) {

                    Cursor cursor;
                    cursor = dbManager.kepcoNotice();
                    while (cursor.moveToNext()) {
                        int k_num;
                        String k_number;
                        String k_name;
                        String k_address;
                        String k_birth;
                        String k_time = "12";

                        k_num = cursor.getInt(0);
                        k_number = cursor.getString(1);
                        k_name = cursor.getString(2);
                        k_address = cursor.getString(3);
                        k_birth = cursor.getString(4);


                        if (k_number.equals(title)&k_birth.equals(studydate)) {

                            dbManager.insert("insert into CUSTOMER_LIST values(null, '" + k_name + "','" + k_address + "','"+ title + "','" + k_birth + "','" + state +"','" + k_time + "');");
                            tvResult.setText(dbManager.PrintData());


                            Toast.makeText(getApplicationContext(), "성공적으로 추가되었습니다", Toast.LENGTH_SHORT).show();

                            Intent newintent = new Intent(TodayActivity.this, Main2Activity.class);
                            TodayActivity.this.startActivity(newintent);
                            TodayActivity.this.onStop();
                            TodayActivity.this.onStop();

                        }else{
                            Toast.makeText(getApplicationContext(), "입력정보를 다시확인해주세요", Toast.LENGTH_SHORT).show();//Display toast if edittext is empty
                        }


                    }




                } else

                    Toast.makeText(getApplicationContext(), "입력정보를 다시확인해주세요", Toast.LENGTH_SHORT).show();//Display toast if edittext is empty





            }
        });

        /*
        // Update
        Button btnUpdate = (Button) findViewById(R.id.btn_update);
        btnUpdate.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // update 테이블명 where 조건 set 값;
                String title = etTitle.getText().toString();


                if (!title.equals("") && title.length() > 0) {

               //     dbManager.update("update STUDY_LIST set content = '" + content + "' where title = '" + title + "';");
                    tvResult.setText(dbManager.PrintData());
                    Toast.makeText(getApplicationContext(), "수정되었습니다.", Toast.LENGTH_SHORT).show();

                } else
                    Toast.makeText(getApplicationContext(), "수정하고 싶은 목록의 제목을 입력하고 내용을 입력하세요!", Toast.LENGTH_SHORT).show();//Display toast if edittext is empty
                Intent intent = new Intent(getApplicationContext(), TodayActivity.class);
            }
        });

        // Delete
        Button btnDelete = (Button) findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // delete from 테이블명 where 조건;
                String title = etTitle.getText().toString();

                if (!title.equals("") && title.length() > 0) {
                    dbManager.delete("delete from STUDY_LIST where title = '" + title + "';");


                    tvResult.setText(dbManager.PrintData());

                    Toast.makeText(getApplicationContext(), "삭제되었습니다.", Toast.LENGTH_SHORT).show();

                } else
                    Toast.makeText(getApplicationContext(), "삭제하고 싶은 목록의 제목을 입력해주세요!", Toast.LENGTH_SHORT).show();//Display toast if edittext is empty
                Intent intent = new Intent(getApplicationContext(), TodayActivity.class);
            }
        });


        // Select
        Button btnSelect = (Button) findViewById(R.id.btn_select);
        btnSelect.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                tvResult.setText( dbManager.PrintData() );
            }
        });

    */


    }


}