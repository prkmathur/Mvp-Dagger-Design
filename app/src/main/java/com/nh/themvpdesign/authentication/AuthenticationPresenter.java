package com.nh.themvpdesign.authentication;

import com.nh.themvpdesign.data.DataRepository;
import com.nh.themvpdesign.data.DataSource;

import javax.inject.Inject;

/**
 * Created by dell pc on 11-11-2017.
 */

public class AuthenticationPresenter implements AuthenticationContract.Presenter,DataSource.getgithubRepo {

    @Inject
    DataRepository dataRepository;

    private AuthenticationContract.View view;

    @Inject
    public AuthenticationPresenter() {

    }

    @Override
    public void getGithubRepos(String username) {
        dataRepository.getGithubRepos(username,this);
    }

    @Override
    public void takeView(AuthenticationContract.View view) {

        this.view = view;
    }

    @Override
    public void dropView() {
        view = null;
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
    public void githubRepoResponse(String response) {
        if(view != null) {
            view.GithubRepos(response);
        }
    }

    /**
     * This will be the error from Data Repository for all requests.
     * @param error
     */

    @Override
    public void networkError(String error) {
        if(view != null) {
            view.onError(error);
        }
    }
}
