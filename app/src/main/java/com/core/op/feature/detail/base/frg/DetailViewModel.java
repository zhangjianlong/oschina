package com.core.op.feature.detail.base.frg;


import android.databinding.ObservableField;
import android.support.v4.app.FragmentManager;

import com.core.op.bindingadapter.common.ItemViewSelector;
import com.core.op.lib.base.BFViewModel;
import com.core.op.lib.di.PerActivity;
import com.domain.bean.NewsDetail;
import com.domain.bean.PrimaryBean;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static android.R.attr.data;

public abstract class DetailViewModel<Data extends PrimaryBean, T> extends BFViewModel<T> {

    public final RxAppCompatActivity activity;

    public DetailViewModel(RxAppCompatActivity activity) {
        this.activity = activity;
    }

    @Override
    public void afterViews() {

    }
}