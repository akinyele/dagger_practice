package com.akinyele.daggerpactice.actvity.repos.mvp.views;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.akinyele.daggerpactice.R;
import com.akinyele.daggerpactice.actvity.main.HomeActivity;
import com.akinyele.daggerpactice.app.networks.models.GithubRepo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author akiny.
 * Created 2/25/2018.
 */

public class ReposAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    Context mContext;
    List<GithubRepo> mGithubRepos;
    private Picasso mPicasso;

    @Inject
    public ReposAdapter(Context context, Picasso picasso) {
        mContext = context;
        mGithubRepos = new ArrayList<>();
        mPicasso = picasso;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, null);
        RepositoriesView repositoriesView = new RepositoriesView(itemView);

        return repositoriesView;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof RepositoriesView) {
            RepositoriesView mHolder = ((RepositoriesView) holder);

            GithubRepo githubRepo = mGithubRepos.get(position);
            mPicasso.load(githubRepo.getOwner().getAvatar_url())
                    .into(mHolder.mReposImage);
        }
    }

    @Override
    public int getItemCount() {
        return mGithubRepos.size();
    }


    public void swapRepos(List<GithubRepo> repos) {
        this.mGithubRepos = repos;
        notifyDataSetChanged();
    }


    class RepositoriesView extends RecyclerView.ViewHolder {

        @BindView(R.id.media_image)
        ImageView mReposImage;

        public RepositoriesView(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
