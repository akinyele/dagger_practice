package com.akinyele.daggerpactice.actvity.repos;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.akinyele.daggerpactice.R;
import com.akinyele.daggerpactice.actvity.repos.di.DaggerReposComponent;
import com.akinyele.daggerpactice.actvity.repos.di.ReposModule;
import com.akinyele.daggerpactice.actvity.repos.mvp.ReposPresenter;
import com.akinyele.daggerpactice.actvity.repos.mvp.views.ReposView;
import com.akinyele.daggerpactice.app.GithubApplication;
import com.akinyele.daggerpactice.actvity.repos.mvp.views.ReposAdapter;
import com.akinyele.daggerpactice.app.networks.GithubService;
import com.akinyele.daggerpactice.app.networks.models.GithubRepo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReposActivity extends AppCompatActivity {

    private static final String TAG = "ReposActivity";

    public static final String EXTRA_GITHUB_REPO_LIST = "githubRepos";

    public static void start(Context context, List<GithubRepo> githubRepos) {
        Log.d(TAG, "start: " + githubRepos);
        Intent intent = new Intent(context, ReposActivity.class);
        intent.putExtra(EXTRA_GITHUB_REPO_LIST, new ArrayList<>(githubRepos));
        context.startActivity(intent);
    }

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Inject
    GithubService mGithubService;

    @Inject
    ReposAdapter mReposAdapter;

    @Inject
    ReposView mReposView;

    @Inject
    ReposPresenter mReposPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerReposComponent.builder()
                .reposModule(new ReposModule(this))
                .githubApplicationComponent(GithubApplication.get(this).getComponent())
                .build().inject(this);

        setContentView(mReposView);
        ButterKnife.bind(this);
        mReposPresenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mReposPresenter.onDestroy();
    }


    public ReposAdapter getReposAdapter() {
        return mReposAdapter;
    }
}
