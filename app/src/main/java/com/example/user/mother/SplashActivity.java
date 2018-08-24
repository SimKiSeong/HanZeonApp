package com.example.user.mother;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.user.mother.MainActivity;

/**
 * Created by DBLAB-JU on 2018-01-20.
 */

public class SplashActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            Thread.sleep(2000);

        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        Intent intent=new Intent(this, Main2Activity.class);
        startActivity(intent);
        finish();



    }
}
