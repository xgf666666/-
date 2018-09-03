package com.microple.jademall.common;



import android.graphics.Point;

import com.microple.jademall.bean.AccountIinfo;
import com.microple.jademall.bean.Address;
import com.microple.jademall.bean.Ask;
import com.microple.jademall.bean.AskDetail;
import com.microple.jademall.bean.AskType;
import com.microple.jademall.bean.Assert;
import com.microple.jademall.bean.Category;
import com.microple.jademall.bean.Emeralds;
import com.microple.jademall.bean.EmeraldsDetail;
import com.microple.jademall.bean.FirstImage;
import com.microple.jademall.bean.Goods;
import com.microple.jademall.bean.GoodsDetail;
import com.microple.jademall.bean.HandImage;
import com.microple.jademall.bean.ImageDetail;
import com.microple.jademall.bean.IntergrationDetail;
import com.microple.jademall.bean.Label;
import com.microple.jademall.bean.Login;
import com.microple.jademall.bean.MessageDetail;
import com.microple.jademall.bean.MyMessage;
import com.microple.jademall.bean.PersonInfo;
import com.microple.jademall.bean.PointDetail;
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
    /**
     * 收货地址
     */
    @POST("Receive/address_list")
    Observable<BaseResponseEntity<Address>> getAddress(@Header("token") String token);
    /**
     * 添加收货地址
     */
    @FormUrlEncoded
    @POST("Receive/add_address")
    Observable<BaseResponseEntity<Object>> addAddress(@Header("token") String token,@Field("receiver") String receiver,@Field("phone") String phone,@Field("address") String address);
    /**
     * 编辑收货地址
     */
    @FormUrlEncoded
    @POST("Receive/edit_address")
    Observable<BaseResponseEntity<Object>> editAddress(@Header("token") String token,@Field("address_id") String address_id,@Field("receiver")String receiver,@Field("phone") String phone,@Field("address") String address);
    /**
     * 设置默认地址
     */
    @FormUrlEncoded
    @POST("Receive/set_default")
    Observable<BaseResponseEntity<Object>> SettingAddress(@Header("token") String token,@Field("address_id") String address_id);
    /**
     * 删除地址
     */
    @FormUrlEncoded
    @POST("Receive/dele_address")
    Observable<BaseResponseEntity<Object>> DelAddress(@Header("token") String token,@Field("address_id") String address_id);
    /**
     * 忘记密码
     */
    @FormUrlEncoded
    @POST("user_api/forgetPwd")
    Observable<BaseResponseEntity<Object>> forgetPW(@Field("phone") String phone,@Field("phone_code")String phone_code,@Field("pwd") String pwd);
    /**
     * 我的资产
     */
    @POST("user_center/assets")
    Observable<BaseResponseEntity<Assert>> getMyAssert(@Header("token") String token);
    /**
     * 积分明细
     */
    @POST("user_center/user_points")
    Observable<BaseResponseEntity<PointDetail>> getPointDetail(@Header("token") String token);
    /**
     * 积分详情
     */
    @FormUrlEncoded
    @POST("user_center/point_detail")
    Observable<BaseResponseEntity<IntergrationDetail>> getIntergrationDetail(@Header("token") String token,@Field("up_id")String up_id);
    /**
     * 翡翠柜
     */
    @POST("user_center/cabinet")
    Observable<BaseResponseEntity<Emeralds>> getEmeralds(@Header("token") String token);
    /**
     * 翡翠柜详情
     */
    @FormUrlEncoded
    @POST("user_center/cabinet_detail")
    Observable<BaseResponseEntity<EmeraldsDetail>> getEmeraldsDetail(@Header("token") String token, @Field("ct_id")String ct_id);
    /**
     * 兑换积分
     */
    @FormUrlEncoded
    @POST("user_center/exchange")
    Observable<BaseResponseEntity<Object>> exchange(@Header("token") String token, @Field("ct_id")String ct_id);
    /**
     * 积分转账
     */
    @POST("user_center/account_info")
    Observable<BaseResponseEntity<AccountIinfo>> getAccount(@Header("token") String token);
    /**
     * 兑换积分
     */
    @FormUrlEncoded
    @POST("user_center/transfer_account")
    Observable<BaseResponseEntity<Object>> push(@Header("token") String token, @Field("to_user")String to_user,@Field("points")String points);
    /**
     * 修改头像
     */
    @FormUrlEncoded
    @POST("User_center/modify_headImg")
    Observable<BaseResponseEntity<HandImage>> setHandImage(@Header("token") String token, @Field("head_img")String head_img);
    /**
     * 消息列表
     */
    @POST("message/msg_list")
    Observable<BaseResponseEntity<MyMessage>> getMessage(@Header("token") String token);
    /**
     * 消息详情
     */
    @FormUrlEncoded
    @POST("message/msg_detail")
    Observable<BaseResponseEntity<MessageDetail>> getMessageDetail(@Header("token") String token, @Field("msg_id") String msg_id);
    /**
     * 常见问题分类
     */
    @POST("common/problem_type")
    Observable<BaseResponseEntity<AskType>> getAskType();
    /**
     * 常见问题
     */
    @FormUrlEncoded
    @POST("common/common_problem")
    Observable<BaseResponseEntity<Ask>> getAsk(@Field("pt_id") String pt_id);
    /**
     * 常见问题答案
     */
    @FormUrlEncoded
    @POST("common/answer")
    Observable<BaseResponseEntity<AskDetail>> getAskDetail(@Field("pt_id") String pt_id);







}




