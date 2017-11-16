package com.nh.themvpdesign.data;

/**
 * Created by dell pc on 12-11-2017.
 */

public interface DataSource {

    interface getgithubRepo{

        void githubRepoResponse();

        void networkError();
    }

    void getGithubRepos();

}
