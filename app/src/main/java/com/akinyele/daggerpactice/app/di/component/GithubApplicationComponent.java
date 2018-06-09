package com.akinyele.daggerpactice.app.di.component;

import com.akinyele.daggerpactice.app.di.GithubApplicationScope;
import com.akinyele.daggerpactice.app.di.module.ActivityContextModule;
import com.akinyele.daggerpactice.app.di.module.GithubServiceModule;
import com.akinyele.daggerpactice.app.di.module.PicassoModule;
import com.akinyele.daggerpactice.app.networks.GithubService;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * @author akiny.
 *         Created 2/28/2018.
 */

@GithubApplicationScope
@Component(modules = {GithubServiceModule.class, PicassoModule.class, ActivityContextModule.class})
public interface GithubApplicationComponent {

    Picasso getPicasso();

    GithubService getGithubService();

}
