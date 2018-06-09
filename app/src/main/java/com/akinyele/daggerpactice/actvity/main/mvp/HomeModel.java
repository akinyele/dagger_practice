package com.akinyele.daggerpactice.actvity.main.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;

import com.akinyele.daggerpactice.R;
import com.akinyele.daggerpactice.actvity.repos.ReposActivity;
import com.akinyele.daggerpactice.app.networks.GithubService;
import com.akinyele.daggerpactice.app.networks.models.GithubRepo;
import com.twistedequations.rxstate.RxSaveState;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * The model in the mvp architecture represents the data center.
 * This is where all the date that is "presenter" in the "view" gets generated from.
 */
public class HomeModel {

    private final String REPOLIST_STATE_KEY = "REPOLIST_STATE_KEY";
    private final GithubService githubService;
    private final Activity mHomeActivity;

    public HomeModel(Activity homeActivity, GithubService githubService) {
        this.githubService = githubService;
        mHomeActivity = homeActivity;
    }

    public Observable<List<GithubRepo>> getRepos(String userName) {
        return githubService.getReposForUser(userName);
    }


    public void saveRepoListState(List<GithubRepo> githubRepos) {

        RxSaveState.updateSaveState(mHomeActivity, bundle -> {
            bundle.putParcelableArrayList(REPOLIST_STATE_KEY, new ArrayList<>(githubRepos));
        });
    }

    public rx.Observable<List<GithubRepo>> getReposFromSavedState() {

        rx.Observable<List<GithubRepo>> gitHubRepo = RxSaveState
                .getSavedState(mHomeActivity)
                .map(bundle -> bundle.getParcelableArrayList(REPOLIST_STATE_KEY));

        return gitHubRepo;
    }

    public void startReposListActivity(List<GithubRepo> githubRepos) {
        ReposActivity.start(mHomeActivity, githubRepos);
    }

}
