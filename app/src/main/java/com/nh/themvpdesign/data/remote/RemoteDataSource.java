package com.nh.themvpdesign.data.remote;

import android.content.SharedPreferences;

import com.nh.themvpdesign.data.DataSource;
import com.nh.themvpdesign.data.NetworkService;
import com.nh.themvpdesign.models.ConsolidatedWeather;
import com.nh.themvpdesign.models.GithubRepo;
import com.nh.themvpdesign.models.WeatherData;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by dell pc on 12-11-2017.
 */

public class RemoteDataSource implements DataSource {

    private final NetworkService  networkService;

    private final SharedPreferences sharedPreferences;

       @Inject
    public RemoteDataSource(NetworkService  networkService,SharedPreferences sharedPreferences) {
        this.networkService = networkService;
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public void getGithubRepos(String username, final getgithubRepo callback) {

        Call<WeatherData> listCall =  networkService.getWeatherForUser("44418");
        listCall.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                Timber.i(response.body().toString());
                callback.githubRepoResponse(response.body());
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                Timber.i(t.toString());
                callback.networkError(t.toString());
            }
        });

    }
}
