package com.core.op.feature.main.news.question;

import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ImageSpan;

import com.core.op.R;
import com.core.op.feature.detail.blog.BlogDetailActivity;
import com.core.op.feature.detail.question.QuesDetailActivity;
import com.core.op.feature.detail.question.frg.QuesDetailFragment;
import com.core.op.lib.base.BViewModel;
import com.core.op.lib.command.ReplyCommand;
import com.core.op.lib.di.PerActivity;
import com.core.op.lib.utils.DateUtil;
import com.domain.bean.Blog;
import com.domain.bean.Question;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import static android.R.attr.author;

/**
 * @author op
 * @version 1.0
 * @description
 * @createDate 2016/11/16
 */
@PerActivity
public class QuestionItemViewModel extends BViewModel {

    RxAppCompatActivity activity;

    public SpannableStringBuilder spannable;


    public Question question;

    public String author;

    public final ReplyCommand itemClick = new ReplyCommand(() -> {
        QuesDetailActivity.instance(activity, question.getId());
    });

    public QuestionItemViewModel() {

    }

    public QuestionItemViewModel(RxAppCompatActivity activity, Question question) {
        this.activity = activity;
        this.question = question;

        author = question.getAuthor();
        if (!TextUtils.isEmpty(author)) {
            author = author.trim();
            author = (author.length() > 9 ? author.substring(0, 9) : author) +
                    "  " + DateUtil.formatSomeAgo(question.getPubDate().trim());
        }
    }

}
