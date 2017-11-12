package com.nh.themvpdesign;

import android.app.Activity;
import android.app.Application;

import com.nh.themvpdesign.di.components.DaggerAppComponent;
import com.nh.themvpdesign.di.components.AppComponent;
import com.nh.themvpdesign.di.modules.AppModule;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;

/**
 * Created by dell pc on 10-11-2017.
 */

public class TheMvpDesignApplication extends Application implements HasActivityInjector{

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;


    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);

    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
