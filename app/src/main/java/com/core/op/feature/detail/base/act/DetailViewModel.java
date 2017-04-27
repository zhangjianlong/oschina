package com.core.op.feature.detail.base.act;


import android.databinding.ObservableField;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.core.op.R;
import com.core.op.base.BaseFragment;
import com.core.op.databinding.ActDetailBinding;
import com.core.op.lib.base.BAViewModel;
import com.core.op.lib.command.ReplyCommand;
import com.core.op.lib.di.PerActivity;
import com.core.op.lib.weight.EmptyLayout;
import com.domain.bean.PrimaryBean;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import javax.inject.Inject;

import rx.Observable;

import static android.R.attr.data;

public abstract class DetailViewModel<Data extends PrimaryBean> extends BAViewModel<ActDetailBinding> {

    protected final RxAppCompatActivity activity;

    protected long dataId;

    public Data data;

    public ObservableField<String> title = new ObservableField<>();

    public final ObservableField<Integer> errorVisible = new ObservableField<>(View.VISIBLE);

    public final ObservableField<Integer> errorType = new ObservableField<>();

    public final ReplyCommand layoutClick = new ReplyCommand(() -> {
        if (errorType.get() != EmptyLayout.HIDE_LAYOUT) {
            errorType.set(EmptyLayout.NETWORK_LOADING);
            loadData();
        }
    });

    public DetailViewModel(RxAppCompatActivity activity) {
        this.activity = activity;
        dataId = activity.getIntent().getExtras().getLong("id", 0);
        if (dataId == 0) activity.finish();
    }

    @Override
    public void afterViews() {
        loadData();
    }

    public long getDataId() {
        return data != null ? data.getId() : dataId;
    }

    protected abstract void loadData();

    /**
     * 获取显示界面的Fragment
     *
     * @return 继承自DetailFragment
     */
    protected abstract BaseFragment getDataViewFragment();

    protected void startAnim() {
        Animation animation = AnimationUtils.loadAnimation(activity, R.anim.anim_alpha_hide);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                errorVisible.set(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        binding.elError.startAnimation(animation);
    }
}