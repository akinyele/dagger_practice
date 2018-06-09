package com.akinyele.daggerpactice.actvity.repos.mvp;

import com.akinyele.daggerpactice.actvity.repos.mvp.views.ReposView;

import io.reactivex.disposables.CompositeDisposable;

public class ReposPresenter {


    private ReposModel mReposModel;
    private ReposView mReposView;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();


    public ReposPresenter(ReposView view, ReposModel model) {
        this.mReposModel = model;
        this.mReposView = view;
    }


    public void onCreate() {
        setIntentData();
    }

    public void onDestroy() {
        mCompositeDisposable.dispose();
    }

    public void setIntentData() {
        mReposView.setData(mReposModel.gitHubRepoIntent());
    }
}
