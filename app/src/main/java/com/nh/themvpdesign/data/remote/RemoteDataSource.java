package com.nh.themvpdesign.data.remote;

import android.content.SharedPreferences;

import com.nh.themvpdesign.data.DataSource;
import com.nh.themvpdesign.data.NetworkService;

import javax.inject.Inject;

/**
 * Created by dell pc on 12-11-2017.
 */

public class RemoteDataSource implements DataSource {

    @Inject
    NetworkService  networkService;

    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    public RemoteDataSource() {
    }

    @Override
    public void getGithubRepos() {

    }
}
