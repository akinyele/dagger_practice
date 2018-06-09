package com.akinyele.daggerpactice;

import com.akinyele.daggerpactice.actvity.main.mvp.HomeModel;
import com.akinyele.daggerpactice.actvity.main.mvp.HomePresenter;
import com.akinyele.daggerpactice.actvity.main.mvp.HomeView;
import com.akinyele.daggerpactice.app.networks.models.GithubRepo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by akiny on 5/23/2018.
 */
public class HomePresenterTesting {


    HomeView mHomeView;
    HomePresenter mHomePresnter;
    HomeModel mHomeModel;


    private List<GithubRepo> mGithubRepos = new ArrayList<>();

    @Before
    public void setUp() throws Exception {

        RxAndroidPlugins.setInitMainThreadSchedulerHandler(
                schedulerCallable -> Schedulers.trampoline()
        );

        /*
         *  Mocking the parameters that we are going to use.
         *  Can use Mocking annotations.
         */
        mHomeView = Mockito.mock(HomeView.class);
        mHomeModel = Mockito.mock(HomeModel.class);


        mHomePresnter = new HomePresenter(mHomeView, mHomeModel);

        /**
         *   Setting up the responses for the methods that we want
         *   to test.
         */

        //View Setup
        Mockito.when(mHomeView.getUserName()).thenReturn("akinyele");
        /*
         * NB - when mocking a button event we always want to use Observable.never()
         * when mocking button. Never implies that the button is still open but there will
         * never be an event.
         * If we use Observable.empty() this sends a complete event and this means the button is
         * deactivated.
         */
        Mockito.when(mHomeView.observerLookUpBtn()).thenReturn(Observable.never());
        //Model Setup
        //Mockito.when(mHomeModel.getRepos(Mockito.anyString())).thenReturn(Observable.just(mGithubRepos));
    }

    @Test
    public void testObserverLookUpBtn() {


        Mockito.when(mHomeView.observerLookUpBtn()).thenReturn(Observable.just("")); // This implies that the button is click instantaneously as the Activity Starts.
        Mockito.when(mHomeModel.getRepos(Mockito.eq("akinyele")))
                .thenReturn(Observable.just(mGithubRepos));

        /*
         * Testing to see if all the functions of observeLookupBtn
         * got executed as we expected
         */
        mHomePresnter.onCreate();// This method is needed to start the presenter.

        Mockito.verify(mHomeView, Mockito.times(1)).showProgressBar(true);
        Mockito.verify(mHomeView, Mockito.times(2)).showProgressBar(false);
        Mockito.verify(mHomeModel, Mockito.times(1)).getRepos("akinyele");
        Mockito.verify(mHomeModel, Mockito.times(1)).startReposListActivity(mGithubRepos);
    }
}
