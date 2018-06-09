package com.akinyele.daggerpactice.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.akinyele.daggerpactice.app.di.component.DaggerGithubApplicationComponent;
import com.akinyele.daggerpactice.app.di.component.GithubApplicationComponent;
import com.akinyele.daggerpactice.app.di.module.ContextModule;
import com.akinyele.daggerpactice.app.networks.GithubService;
import com.squareup.picasso.Picasso;

import timber.log.Timber;

/**
 * @author akiny.
 * Created 2/25/2018.
 */

public class GithubApplication extends Application {


    private static GithubService mGithubService;
    private Picasso picasso;
    private GithubApplicationComponent component;


    public static GithubApplication get(Activity activity) {
        return (GithubApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        // Context
        Context context = this;


        component = DaggerGithubApplicationComponent
                .builder()
                .contextModule(new ContextModule(this))
                .build();

        // NETWORK GROUP

        // PICASSO
        picasso = component.getPicasso();

        // CLIENT
        mGithubService = component.getGithubService();
    }

    public Picasso getPicasso() {
        return picasso;
    }

    public GithubService getmGithubService() {
        return mGithubService;
    }


    public GithubApplicationComponent getComponent() {
        return component;
    }
}
