package com.nh.themvpdesign.di.components;

import android.app.Application;

import com.nh.themvpdesign.TheMvpDesignApplication;
import com.nh.themvpdesign.di.modules.ActivityBuilder;
import com.nh.themvpdesign.di.modules.AppModule;
import com.nh.themvpdesign.di.scopes.ApplicationScope;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by dell pc on 11-11-2017.
 */
@ApplicationScope
@Component(modules = {AppModule.class, AndroidInjectionModule.class, ActivityBuilder.class})
public interface AppComponent {


    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

    void inject(TheMvpDesignApplication theMvpDesignApplication);

}
