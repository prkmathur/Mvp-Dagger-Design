package com.nh.themvpdesign.authentication;

/**
 * Created by dell pc on 11-11-2017.
 */

public class AuthenticationContract {

    interface View {

        void GithubRepos(String response);

        void onError(String error);

        void appendedName(String name);
    }

    interface Presenter {

        void getGithubRepos(String username);

        void takeView(View view);

        void dropView();

        void appendNamWithDepartment(String name);

    }

}
