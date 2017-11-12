package com.nh.themvpdesign.authentication;

import javax.inject.Inject;

/**
 * Created by dell pc on 11-11-2017.
 */

public class AuthenticationPresenter implements AuthenticationContract.Presenter {

    AuthenticationContract.View view;

    @Inject
    public AuthenticationPresenter() {

    }

    @Override
    public void login() {

    }

    @Override
    public void register() {

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
}
