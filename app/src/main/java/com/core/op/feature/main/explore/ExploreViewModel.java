package com.core.op.feature.main.explore;


import android.content.Intent;
import android.support.v4.app.FragmentManager;

import com.core.op.databinding.FrgExploreBinding;
import com.core.op.lib.base.BFViewModel;
import com.core.op.lib.command.ReplyCommand;
import com.core.op.lib.di.PerActivity;
import com.core.op.utils.CameraUtil;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle.components.support.RxFragment;

import javax.inject.Inject;

@PerActivity
public class ExploreViewModel extends BFViewModel<FrgExploreBinding> {

    private final RxAppCompatActivity activity;
    private FragmentManager fragmentManager;

    CameraUtil cameraUtil;

    @Inject
    public ExploreViewModel(RxAppCompatActivity activity) {
        this.activity = activity;
    }


    @Override
    public void afterViews() {
    }
}