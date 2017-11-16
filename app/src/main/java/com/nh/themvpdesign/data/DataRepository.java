package com.nh.themvpdesign.data;

import android.content.Context;

import com.nh.themvpdesign.data.remote.RemoteDataSource;

import javax.inject.Inject;

/**
 * Created by dell pc on 12-11-2017.
 */

public class DataRepository implements DataSource {

    private Context context;

    private RemoteDataSource remoteDataSource;

    public DataRepository(Context context,RemoteDataSource remoteDataSource) {
        this.context = context;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public void getGithubRepos(String username,final getgithubRepo callback) {

        remoteDataSource.getGithubRepos(username, new getgithubRepo() {

            @Override
            public void githubRepoResponse(String response) {
                callback.githubRepoResponse(response);
            }

            @Override
            public void networkError(String error) {
                callback.networkError(error);
            }
        });

    }

}
