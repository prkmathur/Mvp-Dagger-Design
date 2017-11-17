package com.nh.themvpdesign.data;

import com.nh.themvpdesign.models.ConsolidatedWeather;
import com.nh.themvpdesign.models.GithubRepo;
import com.nh.themvpdesign.models.WeatherData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by dell pc on 11-11-2017.
 */

public interface NetworkService {

    @GET("users/{username}/repos")
    Call<List<GithubRepo>> getReposForUser(@Path("username") String username);

    @GET("location/{location}")
    Call<WeatherData> getWeatherForUser(@Path("location") String location);

    @GET("repositories")
    Call<List<GithubRepo>> getAllRepos();

}
