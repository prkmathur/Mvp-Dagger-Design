package com.nh.themvpdesign.data;

import com.nh.themvpdesign.models.WeatherData;

import java.util.ArrayList;

/**
 * Created by dell pc on 12-11-2017.
 */

public interface DataSource {

    public interface getgithubRepo {

        void githubRepoResponse(WeatherData weatherData);

        void networkError(String error);
    }

    void getGithubRepos(String username, getgithubRepo callback);

}
