package com.nh.themvpdesign.data.remote;

import android.content.SharedPreferences;

import com.nh.themvpdesign.data.DataSource;
import com.nh.themvpdesign.data.NetworkService;
import com.nh.themvpdesign.models.GithubRepo;

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


    private NetworkService  networkService;

    private SharedPreferences sharedPreferences;

    @Inject
    public RemoteDataSource(NetworkService  networkService,SharedPreferences sharedPreferences) {
        this.networkService = networkService;
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public void getGithubRepos(String username, final getgithubRepo callback) {

        Call<List<GithubRepo>> listCall =  networkService.getAllRepos();
        listCall.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                Timber.i(response.body().toString());
                callback.githubRepoResponse(response.body().toString());
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
                Timber.i(t.toString());
                callback.networkError(t.toString());
            }
        });

    }
}
