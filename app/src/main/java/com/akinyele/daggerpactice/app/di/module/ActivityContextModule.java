package com.akinyele.daggerpactice.app.di.module;

import android.app.Activity;
import android.content.Context;

import com.akinyele.daggerpactice.app.di.GithubApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * @author akiny.
 *         Created 3/1/2018.
 */

@Module
public class ActivityContextModule {


    private final Activity mActivity;

    public ActivityContextModule(Activity context) {
        mActivity = context;
    }


    @Provides
    @GithubApplicationScope
    @Named("activity_context")
    public Context getActivity() {
        return mActivity;
    }
}
