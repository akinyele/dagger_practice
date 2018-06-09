package com.akinyele.daggerpactice.app.di.module;

import com.akinyele.daggerpactice.app.di.GithubApplicationScope;
import com.akinyele.daggerpactice.app.networks.GithubService;
import com.akinyele.daggerpactice.app.di.module.NetworkModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author akiny.
 * Created 2/28/2018.
 */


@Module(includes = {NetworkModule.class})
public class GithubServiceModule {

    @Provides
    @GithubApplicationScope
    public GithubService getGithubService(Retrofit retrofit) {
        return retrofit.create(GithubService.class);
    }


    @Provides
    @GithubApplicationScope
    public Retrofit getRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    @GithubApplicationScope
    public Gson getGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        //gsonBuilder.registerTypeAdapter(Dat.Class,  new DateTimeFormatter())
        return gsonBuilder.create();
    }

}
