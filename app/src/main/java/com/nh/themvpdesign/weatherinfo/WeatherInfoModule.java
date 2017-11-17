package com.nh.themvpdesign.weatherinfo;

import android.support.v4.app.FragmentManager;

import com.nh.themvpdesign.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by dell pc on 12-11-2017.
 */
@Module
public abstract class WeatherInfoModule {

    @Provides
    @ActivityScope
    public static WeatherInfoContract.Presenter providePresenter(WeatherInfoPresenter weatherInfoPresenter){
        return weatherInfoPresenter;
    }

    @Provides
    @ActivityScope
    public static FragmentManager provideFragmentManager(WeatherInfoActivity activity){
        return  activity.getSupportFragmentManager();
    }

    @ContributesAndroidInjector
    abstract WeatherInfoFragment provideAuthenticationFragment();
}
