package com.akinyele.daggerpactice.app.di.module;

import android.content.Context;

import com.akinyele.daggerpactice.app.di.ApplicationContextQualifier;
import com.akinyele.daggerpactice.app.di.GithubApplicationScope;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * @author akiny.
 * Created 2/28/2018.
 */

@Module(includes = {ContextModule.class, NetworkModule.class})
public class PicassoModule {

    // PICASSO MODULE

    /*
     * Tell dagger that this is a dependency.
     */
    @Provides
    /*
     *Create only on instance of the picasso modules and the dependency cannot be used outside of this scope
     */
    @GithubApplicationScope
    public Picasso getPicasso(@ApplicationContextQualifier Context context, OkHttp3Downloader okHttp3Downloader) {
        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }

    @Provides
    @GithubApplicationScope
    public OkHttp3Downloader getDownloader(OkHttpClient okHttpClient) {
        return new OkHttp3Downloader(okHttpClient);
    }
}
