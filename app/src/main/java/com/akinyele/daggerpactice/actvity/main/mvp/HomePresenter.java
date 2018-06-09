package com.akinyele.daggerpactice.actvity.main.mvp;


import android.util.Log;

import com.akinyele.daggerpactice.actvity.repos.ReposActivity;
import com.akinyele.daggerpactice.app.networks.models.GithubRepo;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import rx.Subscription;

/**
 * This class acts as the connector between the view's observables(because we are using RxJava)
 * To our data observable.
 * <p>
 * Our presenter responds to the life cycle of the view's life cycle
 */

public class HomePresenter {

    private static final String TAG = "HomePresenter";


    private HomeModel homeModel;
    private HomeView mHomeView;

    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public HomePresenter(HomeView homeView, HomeModel model) {
        homeModel = model;
        mHomeView = homeView;
    }

    public void onCreate() {
        mCompositeDisposable.add(observeLookUpBtn());
        //mCompositeDisposable.add(loadFromSaveState());
    }

    public void onDestroy() {
        mCompositeDisposable.dispose();
    }

//    private Subscription loadFromSaveState() {
//        return homeModel.getReposFromSavedState()
//                .subscribe(
//                        githubRepos -> {
//                            mHomeView.showMessage("Look up Btn Clicked - \n" + githubRepos);
//                        }
//                );
//    }

    public Disposable observeLookUpBtn() {
        return mHomeView.observerLookUpBtn()
                .doOnNext((__) -> mHomeView.showProgressBar(true)) // only get executed on the onNext call
                .map(__ -> mHomeView.getUserName())
                .observeOn(Schedulers.io())
                .switchMap(username -> homeModel.getRepos(username))
                // Adding a retry() here would retry the network call if the it failed
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(githubRepos -> {
                    //mHomeView.showMessage("lookupButtonClicked - \n " + githubRepos);
                    homeModel.startReposListActivity(githubRepos);
                })
                .doOnEach(__ -> mHomeView.showProgressBar(false)) // get executed for all of the observable methods
                //.doOnComplete(() -> Log.d(TAG, "observeLookUpBtn: onComplete"))
                .doOnError(throwable -> Log.e(TAG, "observeLookUpBtn: onError", throwable))
                .retry() // if the view fails then retry() makes the observer resubscribe to the button.
                .subscribe();
//                .subscribeWith(
//                        new DisposableObserver<List<GithubRepo>>() {
//                            @Override
//                            public void onNext(List<GithubRepo> githubRepos) {
//                                Log.d(TAG, "onNext: ");
//                                mHomeView.showMessage("Lookup Button Clicked");
//                                //mHomeView.showMessage(githubRepos);
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//                                Log.e(TAG, "onError: ", e);
//                            }
//
//                            @Override
//                            public void onComplete() {
//                                Log.d(TAG, "onComplete: ");
//                            }
//                        }
//                );
    }
}
