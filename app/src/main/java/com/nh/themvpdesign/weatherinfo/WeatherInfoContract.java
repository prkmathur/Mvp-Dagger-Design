package com.nh.themvpdesign.weatherinfo;

import com.nh.themvpdesign.models.WeatherData;

/**
 * Created by dell pc on 11-11-2017.
 */

public class WeatherInfoContract {

    public interface View {

        void GithubRepos(WeatherData response);

        void onError(int RId);

        void appendedName(String name);
    }

    interface Presenter {

        void getGithubRepos(String username);

        void takeView(View view);

        void dropView();

        WeatherData getWeatherData();

        void appendNamWithDepartment(String name);

    }

}
