package com.akinyele.daggerpactice.app.di.module;

import android.content.Context;

import com.akinyele.daggerpactice.app.di.ApplicationContextQualifier;
import com.akinyele.daggerpactice.app.di.GithubApplicationScope;
import com.akinyele.daggerpactice.app.di.module.ContextModule;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * @author akiny.
 *         Created 2/28/2018.
 */


@Module(includes = {ContextModule.class})
public class NetworkModule {

    @Provides
    @GithubApplicationScope
    public HttpLoggingInterceptor getLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.tag("OkHttp").d(message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }


    @Provides
    @GithubApplicationScope
    public OkHttpClient getOkHttpClicent(Cache cache, HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .cache(cache)
                .build();
    }

    @Provides
    @GithubApplicationScope
    public Cache getCache(File cacheFile) {
        return new Cache(cacheFile, 10 * 1000 * 1000); // 10 MB cache
    }

    @Provides
    @GithubApplicationScope
    public File getFile(@ApplicationContextQualifier Context context) {
        File cacheFile = new File(context.getCacheDir(), "okHttp_cache");
        cacheFile.mkdir();

        return cacheFile;
    }


}
