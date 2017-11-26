package com.nh.themvpdesign;

import android.test.mock.MockDialogInterface;

import com.nh.themvpdesign.data.DataRepository;
import com.nh.themvpdesign.models.ConsolidatedWeather;
import com.nh.themvpdesign.models.WeatherData;
import com.nh.themvpdesign.weatherinfo.WeatherInfoContract;
import com.nh.themvpdesign.weatherinfo.WeatherInfoPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by dell pc on 26-11-2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class WeatherInfoPresenterTest {

    @Mock
    private DataRepository dataRepository;

    @Mock
    private WeatherInfoContract.View view;

    @Captor
    private ArgumentCaptor<WeatherData> weatherDataArgumentCaptor;

    @Mock
    WeatherData weatherData;

    private WeatherInfoPresenter weatherInfoPresenter;

    private ArrayList<ConsolidatedWeather> consolidatedWeather;

    @Before
    public void intiateTest(){
        weatherInfoPresenter = new WeatherInfoPresenter(dataRepository);
        weatherInfoPresenter.takeView(view);
        ConsolidatedWeather consolidatedWeatherdata = new ConsolidatedWeather();
        consolidatedWeatherdata.setId(new Long(2323));
        consolidatedWeather = new ArrayList<ConsolidatedWeather>();
        consolidatedWeather.add(consolidatedWeatherdata);
    }

    @Test
    public void testgithubRepoResponse(){

        when(weatherData.getConsolidatedWeathers()).thenReturn(consolidatedWeather);

        weatherInfoPresenter.githubRepoResponse(weatherData);

        verify(view).GithubRepos(weatherDataArgumentCaptor.capture());

        assertEquals(new Long(2323),weatherDataArgumentCaptor.getValue().getConsolidatedWeathers().get(0).getId());
    }

    @Test
    public void testgithubRepoResponseError(){

        when(weatherData.getConsolidatedWeathers()).thenReturn(null);

        weatherInfoPresenter.githubRepoResponse(weatherData);

        verify(view).onError(R.string.error_message);
    }


}
