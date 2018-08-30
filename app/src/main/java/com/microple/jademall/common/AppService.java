package com.microple.jademall.common;



import com.microple.jademall.bean.Category;
import com.microple.jademall.bean.FirstImage;
import com.microple.jademall.bean.Goods;
import com.microple.jademall.bean.GoodsDetail;
import com.microple.jademall.bean.ImageDetail;
import com.microple.jademall.bean.Label;
import com.microple.jademall.bean.Login;
import com.microple.jademall.bean.PersonInfo;
import com.microple.jademall.bean.Search;
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
public interface AppService {
    /**
     * 首页轮播
     */
    @POST("Theme/getImages")
    Observable<BaseResponseEntity<List<FirstImage>>> getFirstImage();
    /**
     * 首页一级分类
     */
    @POST("Theme/getCategorys")
    Observable<BaseResponseEntity<List<Category>>> getCategory();
    /**
     * 首页商品列表
     */
    @FormUrlEncoded
    @POST("Theme/goods_list")
    Observable<BaseResponseEntity<Goods>> getGoodList(@Field("cat_id") int cat_id,@Field("page") int page,@Field("sort")String sort);
    /**
     * 商品详情
     */
    @FormUrlEncoded
    @POST("goods/goods_detail")
    Observable<BaseResponseEntity<GoodsDetail>> getGoodsDetail(@Field("goods_sn") String goods_sn);
    /**
     * 标签说明
     */
    @FormUrlEncoded
    @POST("goods/getLabel")
    Observable<BaseResponseEntity<Label>> getLabel(@Field("label_id") String label_id);
    /**
     * 获取产品图片
     */
    @FormUrlEncoded
    @POST("goods/goods_images")
    Observable<BaseResponseEntity<ImageDetail>> getImageDetail(@Field("goods_id") String goods_id);
    /**
     * 搜索页面
     */
    @POST("search/search_index")
    Observable<BaseResponseEntity<Search>> setSearch();
    /**
     * 发送验证码
     */
    @FormUrlEncoded
    @POST("user_api/sendSMS")
    Observable<BaseResponseEntity<Object>> getCode(@Field("phone") String phone);
    /**
     * 用户注册
     */
    @FormUrlEncoded
    @POST("user_api/register")
    Observable<BaseResponseEntity<Object>> register(@Field("phone") String phone,@Field("phone_code") String phone_code,@Field("pwd") String pwd,@Field("pwds") String pwds,@Field("code") String code);
    /**
     * 密码登录
     */
    @FormUrlEncoded
    @POST("user_api/login")
    Observable<BaseResponseEntity<Login>> pwLogin(@Field("phone") String phone,@Field("password")String password);
    /**
     * 快捷登录
     */
    @FormUrlEncoded
    @POST("user_api/sms_login")
    Observable<BaseResponseEntity<Login>> codeLogin(@Field("phone") String phone,@Field("phone_code")String phone_code);
    /**
     * 获取个人信息
     */
    @POST("user_center/getUserInfo")
    Observable<BaseResponseEntity<PersonInfo>> personInfo( @Header("token") String token);
    /**
     * 获取个人信息
     */
    @FormUrlEncoded
    @POST("User_center/set_nickname")
    Observable<BaseResponseEntity<Object>> setNickName( @Header("token") String token,@Field("nickname")String nickname);
    /**
     * 设置登录密码
     */
    @FormUrlEncoded
    @POST("user_center/setPassword")
    Observable<BaseResponseEntity<Object>> setPW( @Header("token") String token,@Field("phone_code")String phone_code,@Field("password")String password);
    /**
     * 设置交易密码
     */
    @FormUrlEncoded
    @POST("User_center/setTradePassword")
    Observable<BaseResponseEntity<Object>> setPayPW( @Header("token") String token,@Field("phone_code")String phone_code,@Field("password")String password);
    /**
     * 修改手机号码
     */
    @FormUrlEncoded
    @POST("User_center/change_phone")
    Observable<BaseResponseEntity<Object>> setPhone( @Header("token") String token,@Field("phone_code")String phone_code,@Field("phone") String phone);

}



