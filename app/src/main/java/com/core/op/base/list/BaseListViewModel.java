package com.core.op.base.list;


import android.databinding.ObservableBoolean;
import android.support.v4.app.FragmentManager;

import com.core.op.R;
import com.core.op.bindingadapter.common.ItemViewSelector;
import com.core.op.databinding.FrgBaselistBinding;
import com.core.op.lib.base.BFViewModel;
import com.core.op.lib.base.BViewModel;
import com.core.op.lib.command.ReplyCommand;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseListViewModel<T extends BViewModel> extends BFViewModel<FrgBaselistBinding> {

    protected final RxAppCompatActivity activity;
    protected FragmentManager fragmentManager;

    public final List<T> itemViewModel = new ArrayList<>();

    public final ItemViewSelector<T> itemView = itemView();

    public final ObservableBoolean isRefreshing = new ObservableBoolean(false);

    public final ReplyCommand<Integer> onLoadMoreCommand = new ReplyCommand<>((p) -> {
        loadMore();
    });

    public final ReplyCommand onRefreshCommand = new ReplyCommand<>(() -> {
        refresh();
    });

    public BaseListViewModel(RxAppCompatActivity activity) {
        this.activity = activity;
    }

    @Override
    public void afterViews() {
        binding.swipeRefreshLayout.setColorSchemeResources(R.color.app_theme_colorPrimary);
    }

    public abstract void loadMore();

    public abstract void refresh();

    public abstract ItemViewSelector<T> itemView();

}