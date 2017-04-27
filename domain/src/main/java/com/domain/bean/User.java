package com.domain.bean;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * 登录用户实体类
 *
 * @author liux (http://my.oschina.net/liux)
 * @version 1.0
 * @created 2012-3-21
 */
@Root(name = "user", strict = false)
public class User extends Entity {

    public final static int RELATION_ACTION_DELETE = 0x00;// 取消关注
    public final static int RELATION_ACTION_ADD = 0x01;// 加关注

    @Deprecated
    public final static int RELATION_TYPE_BOTH = 0x01;// 双方互为粉丝
    @Deprecated
    public final static int RELATION_TYPE_FANS_HIM = 0x02;// 你单方面关注他
    @Deprecated
    public final static int RELATION_TYPE_NULL = 0x03;// 互不关注
    @Deprecated
    public final static int RELATION_TYPE_FANS_ME = 0x04;// 只有他关注我

    public final static int RELATION_TYPE_APIV2_BOTH = 0x01;// 双方互为粉丝
    public final static int RELATION_TYPE_APIV2_ONLY_FANS_HIM = 0x02;// 你单方面关注他
    public final static int RELATION_TYPE_APIV2_ONLY_FANS_ME = 0x03;// 只有他关注我
    public final static int RELATION_TYPE_APIV2_NULL = 0x04;// 互不关注

    @Element(name = "uid")
    private int id;

    @Element(name = "location", required = false)
    private String location;

    @Element(name = "name", required = false)
    private String name;

    @Element(name = "followers", required = false)
    private int followers;

    @Element(name = "fans", required = false)
    private int fans;

    @Element(name = "score", required = false)
    private int score;

    @Element(name = "portrait", required = false)
    private String portrait;

    @Element(name = "jointime", required = false)
    private String jointime;

    @Element(name = "gender", required = false)
    private String gender;

    @Element(name = "devplatform", required = false)
    private String devplatform;

    @Element(name = "expertise", required = false)
    private String expertise;

    @Element(name = "relation", required = false)
    private int relation;

    @Element(name = "latestonline", required = false)
    private String latestonline;

    @Element(name = "from", required = false)
    private String from;

    @Element(name = "favoritecount", required = false)
    private int favoritecount;

    private String account;

    private String pwd;

    private boolean isRememberMe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getJointime() {
        return jointime;
    }

    public void setJointime(String jointime) {
        this.jointime = jointime;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDevplatform() {
        return devplatform;
    }

    public void setDevplatform(String devplatform) {
        this.devplatform = devplatform;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public int getRelation() {
        return relation;
    }

    public void setRelation(int relation) {
        this.relation = relation;
    }

    public String getLatestonline() {
        return latestonline;
    }

    public void setLatestonline(String latestonline) {
        this.latestonline = latestonline;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getFavoritecount() {
        return favoritecount;
    }

    public void setFavoritecount(int favoritecount) {
        this.favoritecount = favoritecount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public boolean isRememberMe() {
        return isRememberMe;
    }

    public void setRememberMe(boolean isRememberMe) {
        this.isRememberMe = isRememberMe;
    }

    @Override
    public String toString() {
        return "User [uid=" + id + ", location=" + location + ", name=" + name
                + ", followers=" + followers + ", fans=" + fans + ", score="
                + score + ", portrait=" + portrait + ", jointime=" + jointime
                + ", gender=" + gender + ", devplatform=" + devplatform
                + ", expertise=" + expertise + ", relation=" + relation
                + ", latestonline=" + latestonline + ", from=" + from
                + ", favoritecount=" + favoritecount + ", account=" + account
                + ", pwd=" + pwd + ", isRememberMe=" + isRememberMe + "]";
    }
}
