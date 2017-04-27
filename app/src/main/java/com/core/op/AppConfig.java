package com.core.op;

import android.os.Environment;

import java.io.File;

/**
 * @author op
 * @version 1.0
 * @description
 * @createDate 2016/12/1
 */
public class AppConfig {

    /*第三方qq登陆*/
    public static final String QQ = "qq";
    public static final String APP_QQ_KEY = "1105860442";//QQ APPID

    /*第三方微信登陆*/
    public static final String WECHAT = "wechat";
    public static final String WEICHAT_APPID = "wxa8213dc827399101";//微信appID
    public static final String BUNDLE_KEY_OPENIDINFO = "bundle_key_openid_info";

    /*第三方微博登陆*/
    public static final String WEIBO = "weibo";

    /*登陆成功后发送广播的Action*/
    public static final String INTENT_ACTION_USER_CHANGE = "net.oschina.action.USER_CHANGE";//改变用户
    public static final String INTENT_ACTION_LOGOUT = "net.oschina.action.LOGOUT";//用户登出

    /*CacheKey*/
    public static final String CACHE_USERINFO = "CACHE_USERINFO";

    /*文件存放地址*/
    public final static String FILE_SAVE_PATH = "oschina" + File.separator;
}
