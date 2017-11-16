package com.nh.themvpdesign.di.modules;

import android.content.Context;
import android.content.SharedPreferences;

import com.nh.themvpdesign.data.DataRepository;
import com.nh.themvpdesign.data.NetworkService;
import com.nh.themvpdesign.data.remote.RemoteDataSource;
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
    public DataRepository provideDataRepository(Context context, NetworkService networkService, SharedPreferences sharedPreferences){
        return new DataRepository(context,new RemoteDataSource(networkService,sharedPreferences));
    }

}
