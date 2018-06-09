package com.akinyele.daggerpactice.actvity.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.akinyele.daggerpactice.actvity.main.di.DaggerHomeComponent;
import com.akinyele.daggerpactice.actvity.main.di.HomeModule;
import com.akinyele.daggerpactice.actvity.main.mvp.HomeModel;
import com.akinyele.daggerpactice.actvity.main.mvp.HomePresenter;
import com.akinyele.daggerpactice.actvity.main.mvp.HomeView;
import com.akinyele.daggerpactice.app.GithubApplication;


import javax.inject.Inject;

import butterknife.ButterKnife;


/**
 * Dagger 2 APP used to learn dependency injection.
 * <p>
 * In layman terms dependency injection in the process of using constructor arguments to
 * pass in the dependencies for a class. From this a dependency tree can be built.
 */

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";


    @Inject
    HomeView mHomeView;

    @Inject
    HomePresenter mHomePresenter;

    @Inject
    HomeModel mHomeModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerHomeComponent.builder()
                .homeModule(new HomeModule(this))
                .githubApplicationComponent(GithubApplication.get(this).getComponent()) // Has to be set because its a dependency for the component.
                .build().inject(this);

        setContentView(mHomeView);
        ButterKnife.bind(this);
        mHomePresenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHomePresenter.onDestroy();
    }


}
