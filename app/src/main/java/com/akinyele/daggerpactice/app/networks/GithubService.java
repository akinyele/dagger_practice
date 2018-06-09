package com.akinyele.daggerpactice.app.networks;

import com.akinyele.daggerpactice.app.networks.models.GithubRepo;
import com.akinyele.daggerpactice.app.networks.models.GithubUser;
import com.akinyele.daggerpactice.ext.Constants;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * @author akiny.
 * Created 2/25/2018.
 */

public interface GithubService {

    @GET("users/{username}/repos")
    Observable<List<GithubRepo>> getReposForUser(@Path("username") String username);

    @Headers({"Authorization: " + Constants.USER_TOKEN})
    @GET("repositories")
    Call<List<GithubRepo>> getAllRepost();

    @GET("users/{username}")
    Call<GithubUser> getUser(@Path("username") String username);

}
