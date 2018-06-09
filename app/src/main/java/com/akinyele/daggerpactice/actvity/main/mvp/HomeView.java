package com.akinyele.daggerpactice.actvity.main.mvp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.akinyele.daggerpactice.R;
import com.akinyele.daggerpactice.actvity.main.HomeActivity;
import com.jakewharton.rxbinding2.view.RxView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;


/**
 * The view acts as the container for all the view and is only used to
 * update the views. It doesn't not contain any
 */
@SuppressLint("ViewConstructor")
public class HomeView extends FrameLayout {


    @BindView(R.id.editText_user_name)
    EditText usernameEditText;

    @BindView(R.id.btn_lookup_user)
    Button lookUpUserBtn;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    public HomeView(@NonNull Activity homeActivity) {
        super(homeActivity);
        inflate(getContext(), R.layout.activity_main, this);
        ButterKnife.bind(this);
    }


    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    public Observable<Object> observerLookUpBtn() {
        return RxView.clicks(lookUpUserBtn);
    }


    public String getUserName() {
        return usernameEditText.getText().toString();
    }

    public void showProgressBar(boolean loading) {
        if (loading) {
            mProgressBar.setVisibility(VISIBLE);
        } else {
            mProgressBar.setVisibility(GONE);
        }
    }

}
