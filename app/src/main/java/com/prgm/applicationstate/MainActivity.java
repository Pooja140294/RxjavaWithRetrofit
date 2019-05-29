package com.prgm.applicationstate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    Button btn_second, btn_third, btn_startService, btn_stopService, btn_getRetrofitResponse;

    // Log tag name.
    private final static String LOG_TAG_UI = "**LOG_TAG_UI";

    // Bundle state key.
    private final static String USER_INPUTTED_EMAIL = "USER_INPUTTED_EMAIL";

    // Email input text box.
    private EditText emailInputBoxEditText = null;

    Subscription subscription;
    APiClient aPiClient;

    RecyclerView recyclerView;

    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("**ON_CREATE-1-", "ON-CREATE");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        btn_second = (Button) findViewById(R.id.btn_second);
        btn_third = (Button) findViewById(R.id.btn_third);
        btn_startService = (Button) findViewById(R.id.btn_startService);
        btn_stopService = (Button) findViewById(R.id.btn_stopService);
        btn_getRetrofitResponse = (Button) findViewById(R.id.btn_getRetrofitResponse);

        emailInputBoxEditText = (EditText)findViewById(R.id.emailInputBox);

        recyclerAdapter = new RecyclerAdapter();
        recyclerView.setAdapter(recyclerAdapter);

        if(savedInstanceState!=null)
        {
            Log.d(LOG_TAG_UI, "Main activity onCreate savedInstanceState is not null.");
            // Retrieve activity instance state data.
            String email = savedInstanceState.getString(USER_INPUTTED_EMAIL);
            // Set the original email data in EditText view component.
            emailInputBoxEditText.setText(email);
        }else
        {
            Log.d(LOG_TAG_UI, "Main activity onCreate savedInstanceState is null.");
        }

        setTitle("dev2qa.com - Activity State Example");

        // Click this button to display second activity.
        Button startAnotherActivityButton = (Button)findViewById(R.id.startAnotherActivityButton);
        startAnotherActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });

        btn_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Main3Activity.class));
            }
        });

        btn_startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startService(new Intent(getBaseContext(), HelloService.class));

            }
        });

        btn_stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stopService(new Intent(getBaseContext(), HelloService.class));

            }
        });


        //get Retrofit Response

        btn_getRetrofitResponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getRetrofitResponse();
            }
        });

    }

    private void getRetrofitResponse() {

        subscription = APiClient.getContext()
                        .getApiClientResponse()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<List<RetrofitModel>>() {
                            @Override
                            public void onCompleted() {

                                Log.d("**ONCOMPLETED==", "on complete");
                            }

                            @Override
                            public void onError(Throwable e) {

                                Log.d("**ON_ERROR==", "on error");

                            }

                            @Override
                            public void onNext(List<RetrofitModel> retrofitModels) {

                                Log.d("**ON_NEXT==", "on next"+retrofitModels.size());

                                    recyclerAdapter.setGitHubRepos(retrofitModels);

                            }
                        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("**ON_START-1-", "ON-START");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("**ON_RESUME-1-", "ON-RESUME");

    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("**ON_PAUSE-1-", "ON-PAUSE");

    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("**ON_STOP-1-", "ON-STOP");

    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("**ON_RESTART-1-", "ON-RESTART");

    }

    @Override
    protected void onDestroy() {

        if (subscription != null && !subscription.isUnsubscribed()){

            subscription.isUnsubscribed();
        }
        super.onDestroy();

        Log.d("**ON_DESTROY-1-", "ON-DESTROY");

    }

    // This method will be invoked before onStop() method.
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String email = emailInputBoxEditText.getText().toString();
        outState.putString(USER_INPUTTED_EMAIL, email);
        Log.d(LOG_TAG_UI, "Main activity onSaveInstanceState.");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String email = savedInstanceState.getString(USER_INPUTTED_EMAIL);
        Log.d(LOG_TAG_UI, "Main activity onRestoreInstanceState.");
    }

}
