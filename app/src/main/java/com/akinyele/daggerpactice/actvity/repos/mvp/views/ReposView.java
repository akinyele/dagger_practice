package com.akinyele.daggerpactice.actvity.repos.mvp.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.akinyele.daggerpactice.R;
import com.akinyele.daggerpactice.actvity.main.HomeActivity;
import com.akinyele.daggerpactice.actvity.main.di.DaggerHomeComponent;
import com.akinyele.daggerpactice.actvity.repos.ReposActivity;
import com.akinyele.daggerpactice.actvity.repos.di.DaggerReposComponent;
import com.akinyele.daggerpactice.actvity.repos.di.ReposModule;
import com.akinyele.daggerpactice.app.GithubApplication;
import com.akinyele.daggerpactice.app.networks.models.GithubRepo;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * The view acts as the container for all the view and is only used to
 * update the views. It doesnt not contain any
 */
public class ReposView extends FrameLayout {


    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    ReposActivity mHomeActivity;

    ReposAdapter mReposAdapter;

    public ReposView(@NonNull ReposActivity reposActivity) {
        super(reposActivity);
        this.mHomeActivity = reposActivity;
        inflate(getContext(), R.layout.activity_repos, this);
        ButterKnife.bind(this);

        this.mReposAdapter = reposActivity.getReposAdapter();

        mRecyclerView.setLayoutManager(new GridLayoutManager(mHomeActivity, 2));
        mRecyclerView.setAdapter(mReposAdapter);
    }

    public void showMessage(String message) {
        Toast.makeText(mHomeActivity, message, Toast.LENGTH_SHORT).show();
    }

    public void setData(List<GithubRepo> githubRepos) {
        mReposAdapter.swapRepos(githubRepos);
    }

}
