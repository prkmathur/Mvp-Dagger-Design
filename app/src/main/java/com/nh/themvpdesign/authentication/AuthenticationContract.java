package com.nh.themvpdesign.authentication;

/**
 * Created by dell pc on 11-11-2017.
 */

public class AuthenticationContract {

    interface View {

        void isLogin();

        void onResponse();

        void appendedName(String name);
    }

    interface Presenter {

        void login();

        void register();

        void takeView(View view);

        void dropView();

        void appendNamWithDepartment(String name);

    }

}
