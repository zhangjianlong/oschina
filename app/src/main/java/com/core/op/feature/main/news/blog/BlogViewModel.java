package com.core.op.feature.main.news.blog;


import android.support.v4.app.FragmentManager;

import com.core.op.BR;
import com.core.op.R;
import com.core.op.base.list.BaseListViewModel;
import com.core.op.bindingadapter.common.BaseItemViewSelector;
import com.core.op.bindingadapter.common.ItemView;
import com.core.op.bindingadapter.common.ItemViewSelector;
import com.core.op.databinding.FrgBlogBinding;
import com.core.op.feature.main.news.question.QuestionItemViewModel;
import com.core.op.lib.base.BFViewModel;
import com.core.op.lib.base.BViewModel;
import com.core.op.lib.di.PerActivity;
import com.domain.bean.Blog;
import com.domain.bean.base.PageBean;
import com.domain.interactor.main.BlogUseCase;
import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle.components.support.RxFragment;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;

import static android.R.attr.data;

@PerActivity
public class BlogViewModel extends BaseListViewModel<BlogItemViewModel> {

    RxFragment fragment;
    private FragmentManager fragmentManager;
    BlogUseCase useCase;

    PageBean<Blog> data;

    @Inject
    public BlogViewModel(RxAppCompatActivity activity,
                         @Named("BlogUseCase") BlogUseCase useCase) {
        super(activity);
        this.useCase = useCase;
    }

    @Override
    public void loadMore() {
        loadData(false, data == null ? "" : data.getNextPageToken());
    }

    @Override
    public void refresh() {
        loadData(true, "");
    }


    public void loadData(boolean isClean, String nextToken) {
        isRefreshing.set(true);
        useCase.setParams("1", nextToken);

        useCase.execute().compose(fragment.bindToLifecycle())
                .flatMap(d -> {
                    data = d;
                    if (isClean) {
                        itemViewModel.clear();
                        itemViewModel.add(new BlogItemViewModel());
                    }
                    return Observable.from(d.getItems());
                }).doOnNext(data -> itemViewModel.add(new BlogItemViewModel(activity, data)))
                .subscribe(data -> {
                }, e -> {
                    Logger.e(e, "info execute error");
                }, () -> {
                    isRefreshing.set(false);
                    binding.recyclerView.getAdapter().notifyDataSetChanged();
                });
    }

    @Override
    public ItemViewSelector<BlogItemViewModel> itemView() {
        return new BaseItemViewSelector<BlogItemViewModel>() {
            @Override
            public void select(ItemView itemView, int position, BlogItemViewModel item) {
                if (position == 0) {
                    itemView.set(BR.viewModel, R.layout.item_blog_radiogroup);
                } else {
                    itemView.set(BR.viewModel, R.layout.item_new_blog);
                }
            }

            @Override
            public int viewTypeCount() {
                return 2;
            }
        };
    }

    public void setFragment(RxFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void afterViews() {
        super.afterViews();
        refresh();
    }
}