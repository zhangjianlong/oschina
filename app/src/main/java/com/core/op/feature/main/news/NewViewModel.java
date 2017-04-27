package com.core.op.feature.main.news;


import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.core.op.BR;
import com.core.op.R;
import com.core.op.bindingadapter.common.ItemView;
import com.core.op.databinding.FrgNewBinding;
import com.core.op.feature.main.news.active.ActiveFragment;
import com.core.op.feature.main.news.blog.BlogFragment;
import com.core.op.feature.main.news.info.InfoFragment;
import com.core.op.feature.main.news.question.QuestionFragment;
import com.core.op.lib.base.BFViewModel;
import com.core.op.lib.di.PerActivity;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

@PerActivity
public class NewViewModel extends BFViewModel<FrgNewBinding> {

    private final RxAppCompatActivity activity;

    RxFragment fragment;

    public FragmentManager fragmentManager;

    public final String title;

    public final ObservableField<Integer> selectPosition = new ObservableField<>(0);

    public final List<Fragment> fragments = new ArrayList<>();

    public final List<String> titles = new ArrayList<>();

    @Inject
    public NewViewModel(RxAppCompatActivity activity) {
        this.activity = activity;
        title = activity.getString(R.string.app_bottom_menu_new);
        titles.addAll(Arrays.asList(activity.getResources().getStringArray(R.array.new_tabs)));
        fragments.add(InfoFragment.instance());
        fragments.add(BlogFragment.instance());
        fragments.add(QuestionFragment.instance());
        fragments.add(ActiveFragment.instance());
    }

    public void setFragment(RxFragment fragment) {
        this.fragment = fragment;
        fragmentManager = fragment.getChildFragmentManager();
    }

    @Override
    public void afterViews() {
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }
}