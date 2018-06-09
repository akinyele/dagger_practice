package com.akinyele.daggerpactice.actvity.repos.di;

import android.content.Context;

import com.akinyele.daggerpactice.actvity.main.HomeActivity;
import com.akinyele.daggerpactice.actvity.repos.ReposActivity;
import com.akinyele.daggerpactice.actvity.repos.mvp.ReposModel;
import com.akinyele.daggerpactice.actvity.repos.mvp.ReposPresenter;
import com.akinyele.daggerpactice.actvity.repos.mvp.views.ReposAdapter;
import com.akinyele.daggerpactice.actvity.repos.mvp.views.ReposView;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;


/**
 * @author akiny.
 * Created 3/1/2018.
 * <p>
 * A module act as a suppply for the dagger components. This is how dagger knows how to
 * create the specific components that they depend on.
 * @Module - This annotation tells dagger that the specific class is a module.
 * @Provides - This annotation tell dagger that the specific method provides a dependency
 */

@Module
public class ReposModule {

    /**
     * External Dependency
     */
    private final ReposActivity mActivityContext;

    /**
     * Public constructor used when creating the module to supply it with the external dependency.
     */
    public ReposModule(ReposActivity context) {
        this.mActivityContext = context;
    }

    @ReposScope
    @Provides
    ReposActivity getActivityContext() {
        return mActivityContext;
    }

    @ReposScope
    @Provides
    Context getContext() {
        return mActivityContext;
    }


    @ReposScope
    @Provides
    ReposView getReposView(ReposActivity homeActivity) {
        return new ReposView(homeActivity);
    }


    @ReposScope
    @Provides
    ReposPresenter reposPresenter(ReposView reposView, ReposModel model) {
        return new ReposPresenter(reposView, model);
    }

    @ReposScope
    @Provides
    ReposModel reposModel(ReposActivity reposActivity) {
        return new ReposModel(reposActivity);
    }

    @ReposScope
    @Provides
    ReposAdapter mReposAdapter(ReposActivity activity, Picasso picasso) {
        return new ReposAdapter(activity, picasso);
    }

}




