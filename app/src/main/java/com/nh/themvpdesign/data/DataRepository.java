package com.nh.themvpdesign.data;

import android.content.Context;

import com.nh.themvpdesign.data.remote.RemoteDataSource;
import com.nh.themvpdesign.models.WeatherData;

import javax.inject.Inject;

/**
 * Created by dell pc on 12-11-2017.
 */


// ni553f

public class DataRepository implements DataSource {

    private RemoteDataSource remoteDataSource;

    @Inject
    public DataRepository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public void getGithubRepos(String username,final getgithubRepo callback) {

        remoteDataSource.getGithubRepos(username, new getgithubRepo() {

            @Override
            public void githubRepoResponse(WeatherData response) {
                callback.githubRepoResponse(response);
            }

            @Override
            public void networkError(String error) {
                callback.networkError(error);
            }
        });

    }

}
