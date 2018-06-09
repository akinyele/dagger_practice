package com.akinyele.daggerpactice;

import android.content.Context;

import com.akinyele.daggerpactice.Utils.Log;
import com.akinyele.daggerpactice.actvity.repos.ReposActivity;
import com.akinyele.daggerpactice.actvity.repos.mvp.ReposModel;
import com.akinyele.daggerpactice.actvity.repos.mvp.ReposPresenter;
import com.akinyele.daggerpactice.actvity.repos.mvp.views.ReposView;
import com.akinyele.daggerpactice.app.networks.models.GithubRepo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by akiny on 5/23/2018.
 */
public class ReposPresenterTesting {

    @Mock
    ReposView mReposView;
    @Mock
    ReposModel mReposModel;
    @Mock
    Context mContext;
    @Mock
    Log mLog;

    ReposPresenter mReposPresenter;


    private List<GithubRepo> mGithubRepos = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        RxAndroidPlugins.setInitMainThreadSchedulerHandler(
                schedulerCallable -> Schedulers.trampoline()
        );

        mReposModel = Mockito.mock(ReposModel.class);
        mLog = Mockito.mock(Log.class);

        mReposPresenter = new ReposPresenter(mReposView, mReposModel);
       //Mockito.when(mReposModel.gitHubRepoIntent()).thenReturn(mGithubRepos);
    }


    @Test
    public void testAdapterCalling() {
        mReposPresenter.onCreate();
        Mockito.verify(mReposView, Mockito.times(1)).setData(mGithubRepos);
    }


}
