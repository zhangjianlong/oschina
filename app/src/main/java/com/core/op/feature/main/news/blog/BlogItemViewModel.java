package com.core.op.feature.main.news.blog;

import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ImageSpan;

import com.core.op.R;
import com.core.op.feature.detail.blog.BlogDetailActivity;
import com.core.op.feature.detail.news.NewsDetailActivity;
import com.core.op.lib.base.BViewModel;
import com.core.op.lib.command.ReplyCommand;
import com.core.op.lib.di.PerActivity;
import com.core.op.lib.utils.DateUtil;
import com.domain.bean.Blog;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import javax.inject.Inject;

/**
 * @author op
 * @version 1.0
 * @description
 * @createDate 2016/11/16
 */
@PerActivity
public class BlogItemViewModel extends BViewModel {

    RxAppCompatActivity activity;

    public SpannableStringBuilder spannable;

    public String author;

    public Blog blog;

    public ObservableField<Integer> bodyVisible = new ObservableField<>();

    public final ReplyCommand itemClick = new ReplyCommand(() -> {
        BlogDetailActivity.instance(activity, blog.getId());
    });

    public BlogItemViewModel() {

    }

    public BlogItemViewModel(RxAppCompatActivity activity, Blog blog) {
        this.activity = activity;

        this.blog = blog;

        spannable = new SpannableStringBuilder("");

        if (blog.isOriginal()) {
            spannable.append("[icon] ");
            Drawable originate = activity.getResources().getDrawable(R.drawable.ic_label_originate);
            if (originate != null) {
                originate.setBounds(0, 0, originate.getIntrinsicWidth(), originate.getIntrinsicHeight());
            }
            ImageSpan imageSpan = new ImageSpan(originate, ImageSpan.ALIGN_BOTTOM);
            spannable.setSpan(imageSpan, 0, 6, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }

        if (blog.isRecommend()) {
            spannable.append("[icon] ");
            Drawable recommend = activity.getResources().getDrawable(R.drawable.ic_label_recommend);
            if (recommend != null) {
                recommend.setBounds(0, 0, recommend.getIntrinsicWidth(), recommend.getIntrinsicHeight());
            }
            ImageSpan imageSpan = new ImageSpan(recommend, ImageSpan.ALIGN_BOTTOM);
            if (blog.isOriginal()) {
                spannable.setSpan(imageSpan, 7, 13, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            } else {
                spannable.setSpan(imageSpan, 0, 6, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            }
        }
        spannable.append(blog.getTitle());

        author = blog.getAuthor();
        if (!TextUtils.isEmpty(author)) {
            author = author.trim();
            author = (author.length() > 9 ? author.substring(0, 9) : author) +
                    "  " + DateUtil.formatSomeAgo(blog.getPubDate().trim());
        }
    }

}
