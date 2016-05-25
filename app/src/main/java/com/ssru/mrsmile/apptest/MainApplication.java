package com.ssru.mrsmile.apptest;

import android.app.Application;
import com.ssru.mrsmile.apptest.manager.Contextor;

/**
 * Created by Mr.Smile on 5/20/2016.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //Initialize thing(s) here
        Contextor.getInstance().init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
