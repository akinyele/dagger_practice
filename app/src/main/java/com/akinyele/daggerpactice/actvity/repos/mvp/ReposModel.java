package com.akinyele.daggerpactice.actvity.repos.mvp;

import com.akinyele.daggerpactice.actvity.repos.ReposActivity;
import com.akinyele.daggerpactice.app.networks.models.GithubRepo;

import java.util.List;

public class ReposModel {

    private static final String TAG = "ReposModel";
    ReposActivity mReposActivity;

    public ReposModel(ReposActivity activity) {
        this.mReposActivity = activity;
    }

    public List<GithubRepo> gitHubRepoIntent() {
        return mReposActivity.getIntent().getParcelableArrayListExtra(ReposActivity.EXTRA_GITHUB_REPO_LIST);
    }




}
