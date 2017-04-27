package com.core.op.feature.main.news;

import android.databinding.ObservableField;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.core.op.R;
import com.core.op.base.BaseFragment;
import com.core.op.databinding.FrgNewBinding;
import com.core.op.di.components.MainComponent;
import com.core.op.lib.utils.inject.AfterViews;
import com.core.op.lib.utils.inject.BeforeViews;
import com.core.op.lib.utils.inject.RootView;

import java.util.ArrayList;
import java.util.List;

import static com.core.op.R.id.viewPager;

@RootView(R.layout.frg_new)
public final class NewFragment extends BaseFragment<NewViewModel, FrgNewBinding> {

    public static NewFragment instance() {
        return new NewFragment();
    }

    @BeforeViews
    void beforViews() {
        getComponent(MainComponent.class).inject(this);
    }

    @AfterViews
    void afterViews() {
        binding.viewPager.setOffscreenPageLimit(3);
    }
}
