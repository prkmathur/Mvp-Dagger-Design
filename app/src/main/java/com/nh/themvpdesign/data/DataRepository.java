package com.nh.themvpdesign.data;

import javax.inject.Inject;
import javax.naming.Context;

/**
 * Created by dell pc on 12-11-2017.
 */

public class DataRepository implements DataSource {


    @Inject
    public DataRepository(Context context) {
    }

    @Override
    public void getGithubRepos() {

    }
}
