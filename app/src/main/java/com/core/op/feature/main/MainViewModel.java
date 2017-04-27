package com.core.op.feature.main;


import android.databinding.ObservableField;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.core.op.R;
import com.core.op.bindingadapter.bottomnavigation.NavigationRes;
import com.core.op.bindingadapter.bottomnavigation.ViewBindingAdapter;
import com.core.op.databinding.ActMainBinding;
import com.core.op.feature.main.explore.ExploreFragment;
import com.core.op.feature.main.news.NewFragment;
import com.core.op.feature.main.tweet.TweetPagerFragment;
import com.core.op.lib.base.BAViewModel;
import com.core.op.lib.command.ReplyCommand;
import com.core.op.lib.di.PerActivity;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

@PerActivity
public class MainViewModel extends BAViewModel<ActMainBinding> {

    private RxAppCompatActivity activity;

    public ObservableField<String> title = new ObservableField<>();

    public final FragmentManager fragmentManager;

    public final ObservableField<Integer> selectPosition = new ObservableField<>(0);

    public final List<Fragment> fragments = new ArrayList<>();

    public final NavigationRes navigation = NavigationRes.of(R.array.tab_colors, R.menu.bottom_navigation_main).setAccent(R.color.app_theme_colorPrimary);

    public final ReplyCommand<ViewBindingAdapter.NavigationDataWrapper> selectedCommand = new ReplyCommand<>(p -> {
        switch (p.position) {
            case 0:
                title.set(activity.getString(R.string.app_bottom_menu_new));
                break;
            case 1:
                title.set(activity.getString(R.string.app_bottom_menu_tweet));
                break;
            case 2:
                title.set(activity.getString(R.string.app_bottom_menu_explore));
                break;
        }
        selectPosition.set(p.position);
    });

    @Inject
    public MainViewModel(RxAppCompatActivity activity) {
        this.activity = activity;
        fragmentManager = activity.getSupportFragmentManager();
        fragments.add(new NewFragment());
        fragments.add(new TweetPagerFragment());
        fragments.add(new ExploreFragment());
        title.set(activity.getString(R.string.app_bottom_menu_new));
    }

    @Override
    public void afterViews() {
    }
}