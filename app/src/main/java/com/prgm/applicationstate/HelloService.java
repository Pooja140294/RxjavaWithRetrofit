package com.prgm.applicationstate;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class HelloService extends Service {

    IBinder iBinder;

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("**ON-CREATE--SERVICE==", "ON-CREATE");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("**ON-START_COMMAND--SERVICE==", "ON-START_COMMAND");

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        Log.d("**ON-BIND--SERVICE==", "ON-BIND");

        return iBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {

        Log.d("**ON-UNBIND--SERVICE==", "ON-UNBIND");

        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);

        Log.d("**ON-REBIND--SERVICE==", "ON-REBIND");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d("**ON-DESTROY--SERVICE==", "ON-DESTROY");

    }
}
