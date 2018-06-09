package com.akinyele.daggerpactice.actvity.main.di;

import android.app.Activity;
import android.content.Context;

import com.akinyele.daggerpactice.actvity.main.HomeActivity;
import com.akinyele.daggerpactice.actvity.main.mvp.HomeModel;
import com.akinyele.daggerpactice.actvity.main.mvp.HomePresenter;
import com.akinyele.daggerpactice.actvity.main.mvp.HomeView;
import com.akinyele.daggerpactice.app.networks.GithubService;

import dagger.Module;
import dagger.Provides;


/**
 * @author akiny.
 * Created 3/1/2018.
 * <p>
 * A module act as a suppply for the dagger components. This is how dagger knows how to
 * create the specific components that they depend on.
 * @Module - This annotation tells dagger that the specific class is a module.
 * @Provides - This annotation tell dagger that the specific method provides a dependency
 */

@Module
public class HomeModule {

    /**
     * External Dependency
     */
    private final Activity mActivity;

    /**
     * Public constructor used when creating the module to supply it with the external dependency.
     */
    public HomeModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @HomeScope
    Activity homeActivity() {
        return mActivity;
    }


    @Provides
    @HomeScope
    HomeView homeView(Activity activity) {
        return new HomeView(activity);
    }


    @Provides
    @HomeScope
    HomeModel HomeModel(Activity activity, GithubService githubService) {
        return new HomeModel(activity, githubService);
    }

    @Provides
    @HomeScope
    HomePresenter homePresenter(HomeView view, HomeModel model) {
        return new HomePresenter(view, model);
    }
}




