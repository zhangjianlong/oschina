package com.core.op.feature.main.news.question;


import android.support.v4.app.FragmentManager;

import com.core.op.BR;
import com.core.op.R;
import com.core.op.base.list.BaseListFragment;
import com.core.op.base.list.BaseListViewModel;
import com.core.op.bindingadapter.common.BaseItemViewSelector;
import com.core.op.bindingadapter.common.ItemView;
import com.core.op.bindingadapter.common.ItemViewSelector;
import com.core.op.feature.main.news.blog.BlogItemViewModel;
import com.core.op.lib.base.BViewModel;
import com.core.op.lib.di.PerActivity;
import com.domain.bean.Question;
import com.domain.bean.base.PageBean;
import com.domain.interactor.main.QuestionUseCase;
import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle.components.support.RxFragment;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;

import static android.R.attr.data;

@PerActivity
public class QuestionViewModel extends BaseListViewModel<QuestionItemViewModel> {

    QuestionUseCase useCase;

    PageBean<Question> data;

    @Inject
    public QuestionViewModel(
            @Named("QuestionUseCase") QuestionUseCase useCase, RxAppCompatActivity activity) {
        super(activity);
        this.useCase = useCase;
    }

    public void setFragment(RxFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void afterViews() {
        super.afterViews();
        refresh();
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
                        itemViewModel.add(new QuestionItemViewModel());
                    }
                    return Observable.from(d.getItems());
                }).doOnNext(data -> itemViewModel.add(new QuestionItemViewModel(activity, data)))
                .subscribe(data -> {
                }, e -> {
                    Logger.e(e, "info execute error");
                }, () -> {
                    isRefreshing.set(false);
                    binding.recyclerView.getAdapter().notifyDataSetChanged();
                });
    }

    @Override
    public ItemViewSelector<QuestionItemViewModel> itemView() {
        return new BaseItemViewSelector<QuestionItemViewModel>() {
            @Override
            public void select(ItemView itemView, int position, QuestionItemViewModel item) {
                if (position == 0) {
                    itemView.set(BR.viewModel, R.layout.item_question_radiogroup);
                } else {
                    itemView.set(BR.viewModel, R.layout.item_new_question);
                }
            }

            @Override
            public int viewTypeCount() {
                return 2;
            }
        };
    }
}