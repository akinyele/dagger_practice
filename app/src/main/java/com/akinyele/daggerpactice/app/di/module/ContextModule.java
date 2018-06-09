package com.akinyele.daggerpactice.app.di.module;

import android.content.Context;

import com.akinyele.daggerpactice.app.di.ApplicationContextQualifier;
import com.akinyele.daggerpactice.app.di.GithubApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * @author akiny.
 *         Created 2/28/2018.
 */

@Module
public class ContextModule {

    private final Context mContext;

    public ContextModule(Context context) {
        mContext = context.getApplicationContext();
    }


    @Provides
    @GithubApplicationScope
    @ApplicationContextQualifier
    public Context getContext() {
        return mContext;
    }
}

