package com.nh.themvpdesign.di.modules;

import com.nh.themvpdesign.weatherinfo.WeatherInfoActivity;
import com.nh.themvpdesign.weatherinfo.WeatherInfoModule;
import com.nh.themvpdesign.di.scopes.ActivityScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by dell pc on 12-11-2017.
 */
@Module
public abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = WeatherInfoModule.class)
    abstract WeatherInfoActivity bindAuthenticationActivity();

}
