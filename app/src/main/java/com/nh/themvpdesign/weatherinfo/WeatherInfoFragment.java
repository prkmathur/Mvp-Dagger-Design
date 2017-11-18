package com.nh.themvpdesign.weatherinfo;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nh.themvpdesign.R;
import com.nh.themvpdesign.adapters.WeatherInfoAdapter;
import com.nh.themvpdesign.databinding.FragmentAuthenticationBinding;
import com.nh.themvpdesign.models.ConsolidatedWeather;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */

public class WeatherInfoFragment extends DaggerFragment  {

    @Inject
    WeatherInfoContract.Presenter presenter;

    @Inject
    WeatherInfoAdapter weatherInfoAdapter;

    FragmentAuthenticationBinding binding;

    @Inject
    public WeatherInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(getLayoutInflater(),R.layout.fragment_authentication, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recylerWeatherData.setLayoutManager(layoutManager);
        binding.recylerWeatherData.setAdapter(weatherInfoAdapter);
    }


    public void setWeatherData(ArrayList<ConsolidatedWeather> weatherData){
        weatherInfoAdapter.setData(weatherData);
    }

}
