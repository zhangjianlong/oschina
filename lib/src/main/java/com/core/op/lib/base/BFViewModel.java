package com.core.op.lib.base;

import android.support.v4.app.FragmentManager;

import com.trello.rxlifecycle.components.support.RxFragment;

/**
 * @author op
 * @version 1.0
 * @description
 * @createDate 2016/7/21
 */
public abstract class BFViewModel<T> extends BViewModel<T> {

    protected RxFragment fragment;

    protected FragmentManager fragmentManager;

    public abstract void afterViews();

    public void setFragment(RxFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }
}
