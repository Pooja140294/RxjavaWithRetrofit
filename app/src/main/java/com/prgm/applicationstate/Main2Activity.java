package com.prgm.applicationstate;

import android.app.ActivityManager;
import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.prgm.applicationstate.fragments.Fragment2;
import com.prgm.applicationstate.fragments.Fragment_One;

import java.util.List;

public class Main2Activity extends FragmentActivity {

    Button btn_second, btn_third, btn_fragmentTransac, btn_fragment2;
    private final static String LOG_TAG_UI = "**LOG_TAG_UI";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Log.d("**ON_CREATE-2-Activity", "ON-CREATE");

        btn_second = (Button) findViewById(R.id.btn_second);
        btn_third = (Button) findViewById(R.id.btn_third);

        btn_fragmentTransac = (Button) findViewById(R.id.btn_fragmentTransac);
        btn_fragment2 = (Button) findViewById(R.id.btn_fragment2);

        printMatrix();

        btn_fragmentTransac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_One fragment_one = new Fragment_One();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.mainframe, fragment_one);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btn_fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment2 fragment_two = new Fragment2();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.mainframe, fragment_two);
                transaction.commit();
            }
        });



        setTitle("dev2qa.com - Target Activity.");

        // Click this button will destroy and recycle all activities.
        Button destroyPreviousActivityButton = (Button)findViewById(R.id.destroyPreviousActivityButton);
        destroyPreviousActivityButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();

                // Get activity manager.
                ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

                // Get AppTask list.
                List<ActivityManager.AppTask> appTaskList = activityManager.getAppTasks();

                if(appTaskList!=null)
                {
                    // Loop the list, destroy and recycle all activity in this activity stack.
                    int appTaskListSize = appTaskList.size();
                    for(int i = 0;i<appTaskListSize;i++)
                    {
                        ActivityManager.AppTask appTask = appTaskList.get(i);
                        ActivityManager.RecentTaskInfo recentTaskInfo = appTask.getTaskInfo();

                        ComponentName componentName = recentTaskInfo.baseActivity;

                        String baseActivityClassName = componentName.getClassName();

                        Log.d(LOG_TAG_UI, baseActivityClassName);

                        if("com.dev2qa.example.ActivityStateActivity".equals(baseActivityClassName))
                        {
                            appTask.finishAndRemoveTask();
                        }
                    }
                }
            }
        });

        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2Activity.this, Main3Activity.class));
            }
        });

        btn_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2Activity.this, MainActivity.class));
            }
        });
    }

    private void printMatrix() {

        for (int i = 0 ; i < 5 ; i++){

            for (int j = 0 ; j <= i ; j++){

                Log.d("**print", "*");
            }
        }
    }


    @Override
    protected void onStart() {
        super.onStart();

        Log.d("**ON_START-2-Activity", "ON-START");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("**ON_RESUME-2-Activity", "ON-RESUME");

    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("**ON_PAUSE-2-Activity", "ON-PAUSE");

    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("**ON_STOP-2-Activity", "ON-STOP");

    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("**ON_RESTART-2-Activity", "ON-RESTART");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("**ON_DESTROY-2-Activity", "ON-DESTROY");

    }

}
