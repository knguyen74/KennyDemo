package com.example.kenny.kennydemo;

import android.app.Application;

import com.example.kenny.kennydemo.util.UtilLog;

/**
 * Created by Kenny on 2/6/2017.
 */

public class KennyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setDebug(true);
    }
}
