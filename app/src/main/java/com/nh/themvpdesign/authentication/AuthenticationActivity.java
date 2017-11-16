package com.nh.themvpdesign.authentication;

import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.nh.themvpdesign.R;
import com.nh.themvpdesign.data.NetworkService;
import com.nh.themvpdesign.databinding.ActivityAuthenticationBinding;
import com.nh.themvpdesign.models.GithubRepo;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;
import dagger.android.support.HasSupportFragmentInjector;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class AuthenticationActivity extends FragmentActivity implements AuthenticationContract.View,View.OnClickListener,HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    NetworkService networkService;

    @Inject
    AuthenticationContract.Presenter presenter;

    @Inject
    FragmentManager fragmentManager;

    @Inject
    SharedPreferences sharedPreferences;

    ActivityAuthenticationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_authentication);
        binding.button.setOnClickListener(this);
        addFragment();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.takeView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.dropView();
    }


    @Override
    public void GithubRepos(String response) {
        binding.editText2.setText(response);
    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void appendedName(String name) {
        binding.editText2.setText(name);
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
        AuthenticationFragment fragment = new AuthenticationFragment();
        fragmentTransaction.add(binding.container.getId(), fragment);
        fragmentTransaction.commit();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
