package com.nh.themvpdesign.di.modules;

import android.content.Context;

import com.nh.themvpdesign.data.DataRepository;
import com.nh.themvpdesign.di.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 16-Nov-17.
 */
@Module
public class RepositoryModule {

    @Provides
    @ApplicationScope
    public DataRepository provideDataRepository(Context context){
        return new DataRepository(context);
    }

}
