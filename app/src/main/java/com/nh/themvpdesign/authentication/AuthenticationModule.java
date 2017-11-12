package com.nh.themvpdesign.authentication;

import android.support.v4.app.FragmentManager;

import com.nh.themvpdesign.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by dell pc on 12-11-2017.
 */
@Module
public abstract class AuthenticationModule {

    @Provides
    @ActivityScope
    public static AuthenticationContract.Presenter providePresenter(AuthenticationPresenter authenticationPresenter){
        return authenticationPresenter;
    }

    @Provides
    @ActivityScope
    public static FragmentManager provideFragmentManager(AuthenticationActivity activity){
        return  activity.getSupportFragmentManager();
    }

    @ContributesAndroidInjector
    abstract AuthenticationFragment provideAuthenticationFragment();
}
