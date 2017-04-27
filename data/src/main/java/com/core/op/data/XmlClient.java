package com.core.op.data;

import com.domain.bean.LoginUserBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * @author op
 * @version 1.0
 * @description TODO
 * @createDate 2016/12/2
 */


public interface XmlClient {

    @FormUrlEncoded
    @POST("action/api/openid_login")
    Observable<LoginUserBean> login(@Field("catalog") String catalog, @Field("openid_info") String openid_info);

    @FormUrlEncoded
    @POST("action/api/login_validate")
    Observable<LoginUserBean> userLogin(@Field("username") String username, @Field("pwd") String pwd, @Field("keep_login") String keep);

}
