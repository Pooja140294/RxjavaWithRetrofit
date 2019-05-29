package com.prgm.applicationstate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {

    Button btn_second, btn_third;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Log.d("**ON_CREATE-3-", "ON-CREATE");

        btn_second = (Button) findViewById(R.id.btn_second);
        btn_third = (Button) findViewById(R.id.btn_third);

        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main3Activity.this, Main2Activity.class));
            }
        });

        btn_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main3Activity.this, MainActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("**ON_START-3-", "ON-START");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("**ON_RESUME-3-", "ON-RESUME");

    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("**ON_PAUSE-3-", "ON-PAUSE");

    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("**ON_STOP-3-", "ON-STOP");

    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("**ON_RESTART-3-", "ON-RESTART");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("**ON_DESTROY-3-", "ON-DESTROY");

    }
}
