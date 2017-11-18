package com.nh.themvpdesign.weatherinfo;

import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import com.nh.themvpdesign.R;
import com.nh.themvpdesign.data.NetworkService;
import com.nh.themvpdesign.databinding.ActivityAuthenticationBinding;
import com.nh.themvpdesign.models.WeatherData;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class WeatherInfoActivity extends FragmentActivity implements WeatherInfoContract.View,View.OnClickListener,HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    NetworkService networkService;

    @Inject
    Lazy<WeatherInfoContract.Presenter> presenterProvider;

    @Inject
    FragmentManager fragmentManager;

    @Inject
    WeatherInfoFragment fragment;

    ActivityAuthenticationBinding binding;
    WeatherInfoContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_authentication);
        binding.button.setOnClickListener(this);
        addFragment();
        presenter = (WeatherInfoContract.Presenter) getLastCustomNonConfigurationInstance();

        if (presenter == null) {
            presenter = presenterProvider.get();
        }
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return presenter;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(presenter.getWeatherData() != null){
            fragment.setWeatherData(presenter.getWeatherData().getConsolidatedWeathers());
        }
        presenter.takeView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.dropView();
    }


    @Override
    public void GithubRepos(WeatherData response) {
        fragment.setWeatherData(response.getConsolidatedWeathers());
    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void appendedName(String name) {

    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        switch (viewId){

            case R.id.button:
                presenter.getGithubRepos("prkmathur");
                break;
        }

    }
    protected void addFragment(){

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(binding.container.getId(), fragment);
        fragmentTransaction.commit();

    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
