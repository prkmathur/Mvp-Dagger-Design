package com.nh.themvpdesign.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.fatboyindustrial.gsonjodatime.DateTimeConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.nh.themvpdesign.data.NetworkService;
import com.nh.themvpdesign.di.scopes.ApplicationScope;
import com.squareup.picasso.Picasso;

import org.joda.time.DateTime;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by dell pc on 11-11-2017.
 */
@Module
public class AppModule {

    @Provides
    @ApplicationScope
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @ApplicationScope
    public SharedPreferences provideSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @ApplicationScope
    public File provideCacheFile(Context context){
        File cacheFile = new File(context.getCacheDir(),"okhttp_cache");
        cacheFile.mkdir();
        return cacheFile;
    }

    @Provides
    @ApplicationScope
    public Cache provideCache(File cacheFile){
        return new Cache(cacheFile, 10 * 1000 * 1000);
    }

    @Provides
    @ApplicationScope
    public HttpLoggingInterceptor provideHttpLoggingInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return interceptor;
    }

    @Provides
    @ApplicationScope
    public OkHttpClient provideOkHttpclient(Cache cache , HttpLoggingInterceptor httpLoggingInterceptor){
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .cache(cache)
                .connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .build();
    }

    @Provides
    @ApplicationScope
    public NetworkService getNetworkService(Retrofit retrofit){
        return retrofit.create(NetworkService.class);
    }

    @Provides
    @ApplicationScope
    public Gson provideGson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(DateTime.class,new DateTimeConverter());
        return gsonBuilder.create();
    }


    @Provides
    @ApplicationScope
    public Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson){
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }

    @Provides
    @ApplicationScope
    public OkHttp3Downloader provideOkHttp3Downloader(OkHttpClient okHttpClient){
        return new OkHttp3Downloader(okHttpClient);
    }

    @Provides
    @ApplicationScope
    public Picasso providePicasso(Context context, OkHttp3Downloader okHttp3Downloader){
        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }

}
