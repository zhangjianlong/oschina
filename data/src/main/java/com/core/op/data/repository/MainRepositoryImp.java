package com.core.op.data.repository;

import com.core.op.data.ApiClient;
import com.core.op.data.api.transformer.ErrorTransformer;
import com.domain.bean.Banner;
import com.domain.bean.Blog;
import com.domain.bean.BlogDetail;
import com.domain.bean.Event;
import com.domain.bean.EventDetail;
import com.domain.bean.News;
import com.domain.bean.NewsDetail;
import com.domain.bean.Question;
import com.domain.bean.QuestionDetail;
import com.domain.bean.Tweet;
import com.domain.bean.base.PageBean;
import com.domain.repository.MainRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * @author op
 * @version 1.0
 * @description
 * @createDate 2016/10/11
 */
@Singleton
public class MainRepositoryImp implements MainRepository {

    ApiClient apiClient;

    @Inject
    public MainRepositoryImp(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public Observable<PageBean<News>> getNews(String pageToken) {
        return apiClient.getNews(pageToken).compose(new ErrorTransformer<>());
    }

    @Override
    public Observable<PageBean<Banner>> getBanner(String catalog) {
        return apiClient.getBanner(catalog).compose(new ErrorTransformer<>());
    }

    @Override
    public Observable<PageBean<Blog>> getBlog(String catalog, String pageToken) {
        return apiClient.getBlog(catalog, pageToken).compose(new ErrorTransformer<>());
    }


    @Override
    public Observable<PageBean<Question>> getQuestion(String catalog, String pageToken) {
        return apiClient.getQuestion(catalog, pageToken).compose(new ErrorTransformer<>());
    }

    @Override
    public Observable<PageBean<Event>> getEvent(String pageToken) {
        return apiClient.getEvent(pageToken).compose(new ErrorTransformer<>());
    }

    @Override
    public Observable<PageBean<Tweet>> getTweet(String tag, String pageToken) {
        return apiClient.getTweet(tag, pageToken).compose(new ErrorTransformer<>());
    }

    @Override
    public Observable<PageBean<Tweet>> getUserTweet(String authorId, String pageToken) {
        return apiClient.getUserTweet(authorId, pageToken).compose(new ErrorTransformer<>());
    }

    @Override
    public Observable<NewsDetail> getNewsDetail(String id) {
        return apiClient.getNewsDetail(id).compose(new ErrorTransformer<>());
    }

    @Override
    public Observable<BlogDetail> getBlogDetail(String id) {
        return apiClient.getBlogDetail(id).compose(new ErrorTransformer<>());
    }

    @Override
    public Observable<QuestionDetail> getQuestionDetail(String id) {
        return apiClient.getQuestionDetail(id).compose(new ErrorTransformer<>());
    }

    @Override
    public Observable<EventDetail> getEventDetail(String id) {
        return apiClient.getEventDetail(id).compose(new ErrorTransformer<>());
    }
}
