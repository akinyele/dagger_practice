package com.akinyele.daggerpactice.app.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.akinyele.daggerpactice.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author akiny.
 *         Created 2/27/2018.
 */

public class RepositoriesView extends RecyclerView.ViewHolder {

    @BindView(R.id.media_image)
    ImageView mReposImage;

    public RepositoriesView(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
