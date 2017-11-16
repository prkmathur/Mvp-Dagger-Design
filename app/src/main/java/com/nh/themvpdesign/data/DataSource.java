package com.nh.themvpdesign.data;

/**
 * Created by dell pc on 12-11-2017.
 */

public interface DataSource {

    public interface getgithubRepo{

        void githubRepoResponse(String response);

        void networkError(String error);
    }

    void getGithubRepos(String username, getgithubRepo callback);

}
