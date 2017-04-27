package com.core.op.data;

import com.core.op.data.api.BaseResponse;
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
import com.domain.bean.UserV2;
import com.domain.bean.base.PageBean;

import okhttp3.MultipartBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author op
 * @version 1.0
 * @description
 * @createDate 2016/8/8
 */

public interface ApiClient {

    @GET("action/apiv2/banner")
    Observable<BaseResponse<PageBean<Banner>>> getBanner(@Query("catalog") String catalog);

    @GET("action/apiv2/news")
    Observable<BaseResponse<PageBean<News>>> getNews(@Query("pageToken") String pageToken);

    @GET("action/apiv2/blog")
    Observable<BaseResponse<PageBean<Blog>>> getBlog(@Query("catalog") String catalog, @Query("pageToken") String pageToken);

    @GET("action/apiv2/question")
    Observable<BaseResponse<PageBean<Question>>> getQuestion(@Query("catalog") String catalog, @Query("pageToken") String pageToken);

    @GET("action/apiv2/event")
    Observable<BaseResponse<PageBean<Event>>> getEvent(@Query("pageToken") String pageToken);

    @GET("action/apiv2/tweets")
    Observable<BaseResponse<PageBean<Tweet>>> getTweet(@Query("type") String tag, @Query("pageToken") String pageToken);

    @GET("action/apiv2/tweets")
    Observable<BaseResponse<PageBean<Tweet>>> getUserTweet(@Query("authorId") String authorId, @Query("pageToken") String pageToken);

    @GET("action/apiv2/user_info")
    Observable<BaseResponse<UserV2>> getUserInfo();

    @Multipart
    @POST("action/apiv2/user_edit_portrait")
    Observable<BaseResponse<UserV2>> uploadUserHead(@Part MultipartBody.Part file);

    @GET("action/apiv2/news")
    Observable<BaseResponse<NewsDetail>> getNewsDetail(@Query("id") String id);

    @GET("action/apiv2/blog")
    Observable<BaseResponse<BlogDetail>> getBlogDetail(@Query("id") String id);

    @GET("action/apiv2/question")
    Observable<BaseResponse<QuestionDetail>> getQuestionDetail(@Query("id") String id);

    @GET("action/apiv2/event")
    Observable<BaseResponse<EventDetail>> getEventDetail(@Query("id") String id);

}

