package com.nh.themvpdesign.weatherinfo;

import com.nh.themvpdesign.R;
import com.nh.themvpdesign.data.DataRepository;
import com.nh.themvpdesign.data.DataSource;
import com.nh.themvpdesign.models.WeatherData;

import javax.inject.Inject;

/**
 * Created by dell pc on 11-11-2017.
 */

public class WeatherInfoPresenter implements WeatherInfoContract.Presenter,DataSource.getgithubRepo {

    private DataRepository dataRepository;

    private WeatherInfoContract.View view;

    private WeatherData weatherData;

    @Inject
    public WeatherInfoPresenter(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public void getGithubRepos(String username) {
        dataRepository.getGithubRepos(username,this);
    }

    @Override
    public void takeView(WeatherInfoContract.View view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        view = null;
    }

    @Override
    public WeatherData getWeatherData() {
        return weatherData;
    }

    @Override
    public void appendNamWithDepartment(String name) {
        if(name == null || name.isEmpty()){
            return;
        }
        view.appendedName("Android - "+name);

    }

    /**
     * This will be response from Data Repository for our Git hub repos request.
     * @param response
     */
    @Override
    public void githubRepoResponse(WeatherData response) {

        if(response!= null && response.getConsolidatedWeathers() != null) {
            weatherData = response;
            if(view != null) {
                view.GithubRepos(response);
            }
        }else{
            view.onError(R.string.error_message);
        }
    }

    /**
     * This will be the error from Data Repository for all requests.
     * @param error
     */

    @Override
    public void networkError(String error) {
        if(view != null) {
            view.onError(R.string.error_message);
        }
    }
}
