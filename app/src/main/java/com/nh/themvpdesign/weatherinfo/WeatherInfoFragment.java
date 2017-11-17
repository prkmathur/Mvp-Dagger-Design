package com.nh.themvpdesign.weatherinfo;


import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nh.themvpdesign.R;
import com.nh.themvpdesign.databinding.FragmentAuthenticationBinding;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */

public class WeatherInfoFragment extends DaggerFragment  {

    @Inject
    WeatherInfoContract.Presenter presenter;

    @Inject
    SharedPreferences sharedPreferences;

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        binding.presenterHashcode.setText("PresenterObject "+presenter.hashCode());

        binding.getLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNameLength();
            }
        });
    }

    private void showNameLength(){
        int length = sharedPreferences.getInt("LENGTH",0);
        binding.presenterHashcode.setText("PresenterObject "+presenter.hashCode() +  length);

    }

}
