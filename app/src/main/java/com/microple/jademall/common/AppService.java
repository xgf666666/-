package com.microple.jademall.common;



import android.graphics.Point;

import com.microple.jademall.bean.AccountIinfo;
import com.microple.jademall.bean.Address;
import com.microple.jademall.bean.Ask;
import com.microple.jademall.bean.AskDetail;
import com.microple.jademall.bean.AskType;
import com.microple.jademall.bean.Assert;
import com.microple.jademall.bean.Category;
import com.microple.jademall.bean.Collection;
import com.microple.jademall.bean.CustiomerDetail;
import com.microple.jademall.bean.Customer;
import com.microple.jademall.bean.DetailShare;
import com.microple.jademall.bean.Emeralds;
import com.microple.jademall.bean.EmeraldsDetail;
import com.microple.jademall.bean.FirstImage;
import com.microple.jademall.bean.Goods;
import com.microple.jademall.bean.GoodsDetail;
import com.microple.jademall.bean.HandImage;
import com.microple.jademall.bean.ImOrder;
import com.microple.jademall.bean.Image;
import com.microple.jademall.bean.ImageDetail;
import com.microple.jademall.bean.IntergrationDetail;
import com.microple.jademall.bean.Label;
import com.microple.jademall.bean.LiveDetail;
import com.microple.jademall.bean.LiveGoods;
import com.microple.jademall.bean.LiveList;
import com.microple.jademall.bean.LiveMessage;
import com.microple.jademall.bean.LiveShare;
import com.microple.jademall.bean.Login;
import com.microple.jademall.bean.MessageDetail;
import com.microple.jademall.bean.MyMessage;
import com.microple.jademall.bean.Note;
import com.microple.jademall.bean.Order;
import com.microple.jademall.bean.OrderDetail;
import com.microple.jademall.bean.Pay;
import com.microple.jademall.bean.PersonInfo;
import com.microple.jademall.bean.Pick;
import com.microple.jademall.bean.PointDetail;
import com.microple.jademall.bean.Profit;
import com.microple.jademall.bean.Record;
import com.microple.jademall.bean.RecordDetail;
import com.microple.jademall.bean.Search;
import com.microple.jademall.bean.SearchResult;
import com.microple.jademall.bean.Share;
import com.microple.jademall.bean.Shop;
import com.microple.jademall.bean.Team;
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
    Observable<BaseResponseEntity<GoodsDetail>> getGoodsDetail(@Header("token")String token,@Field("goods_sn") String goods_sn);
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
     * 搜索
     */
    @FormUrlEncoded
    @POST("search/search")
    Observable<BaseResponseEntity<SearchResult>> getResult(@Field("keyword") String keyword);
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
     * 微信登录
     */
    @FormUrlEncoded
    @POST("user_api/wx_login")
    Observable<BaseResponseEntity<Login>> threeLogin(@Field("openid") String openid);
    /**
     * 绑定手机号
     */
    @FormUrlEncoded
    @POST("user_api/bind_phone")
    Observable<BaseResponseEntity<Login>> bindPhone(@Field("openid") String openid,@Field("phone") String phone,@Field("phone_code") String phone_code,@Field("code") String code,@Field("nickname") String nickname,@Field("head_img") String head_img);
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
    /**
     * 入驻协议
     */
    @POST("user_center/enter_protocol")
    Observable<BaseResponseEntity<Note>> getNote(@Header("token") String token);
    /**
     * 入驻申请记录列表
     */
    @POST("user_center/apply_list")
    Observable<BaseResponseEntity<Record>> getRecord(@Header("token") String token);
    /**
     * 商家申请记录详情
     */
    @FormUrlEncoded
    @POST("user_center/apply_record")
    Observable<BaseResponseEntity<RecordDetail>> getRecordDetail(@Header("token") String token, @Field("supplier_id") String supplier_id);
    /**
     * 入驻申请
     */
    @FormUrlEncoded
    @POST("user_center/enter_apply")
    Observable<BaseResponseEntity<Object>> apply(@Header("token") String token, @Field("supplier_name") String supplier_name,@Field("email")String email,@Field("phone")String phone,@Field("inviter")String inviter,@Field("license") String license,@Field("attach")String attach);
    /**
     * 意见反馈
     */
    @FormUrlEncoded
    @POST("user_center/feedback")
    Observable<BaseResponseEntity<Object>> getFeedBack(@Header("token") String token, @Field("content") String content);
    /**
     * 上传图片
     */
    @FormUrlEncoded
    @POST("Common/imgUp")
    Observable<BaseResponseEntity<Image>> getImage(@Field("upload_img") String upload_img);
    /**
     * 收藏列表
     */
    @POST("user_center/collect_list")
    Observable<BaseResponseEntity<Collection>> getCollection(@Header("token") String token);
    /**
     * 收藏
     */
    @FormUrlEncoded
    @POST("Collect/collect")
    Observable<BaseResponseEntity<Object>> collection(@Header("token") String token,@Field("goods_id")String goods_id);
    /**
     * 订单列表
     */
    @FormUrlEncoded
    @POST("Order/order_list")
    Observable<BaseResponseEntity<Order>> getOrder(@Header("token") String token, @Field("order_status") String order_status);
    /**
     * 订单详情
     */
    @FormUrlEncoded
    @POST("Order/order_detail")
    Observable<BaseResponseEntity<OrderDetail>> getOrderDetail(@Header("token") String token, @Field("order_id") String order_id);
    /**
     * 确认收货
     */
    @FormUrlEncoded
    @POST("Order/confirm_order")
    Observable<BaseResponseEntity<Object>> sureDetail(@Header("token") String token, @Field("order_id") String order_id);
    /**
     * 取消订单
     */
    @FormUrlEncoded
    @POST("Order/cancel_order")
    Observable<BaseResponseEntity<Object>> exitDetail(@Header("token") String token, @Field("order_id") String order_id);
    /**
     * 申请售后
     */
    @FormUrlEncoded
    @POST("Order/returns")
    Observable<BaseResponseEntity<Object>> ApplyCus(@Header("token") String token, @Field("order_id") String order_id,@Field("goods_id") String goods_id,@Field("reason") String reason,@Field("desc") String desc,@Field("refunds")String refunds);
    /**
     * 售后列表
     */
    @POST("Order/returns_list")
    Observable<BaseResponseEntity<Customer>> getCustomer(@Header("token") String token);
    /**
     * 售后详情
     */
    @FormUrlEncoded
    @POST("Order/returns_detail")
    Observable<BaseResponseEntity<CustiomerDetail>> customerDetail(@Header("token") String token, @Field("as_id") String as_id);
    /**
     * 提交邮寄信息
     */
    @FormUrlEncoded
    @POST("Order/send_back")
    Observable<BaseResponseEntity<Object>> sendBack(@Header("token") String token, @Field("as_id") String as_id,@Field("shipping_name")String shipping_name,@Field("shipping_code")String shipping_code);
    /**
     * 购物袋信息
     */
    @POST("shopp/shopp_bag")
    Observable<BaseResponseEntity<Shop>> shopping(@Header("token") String token);
    /**
     * 删除购物袋商品
     */
    @FormUrlEncoded
    @POST("shopp/dele_shopp")
    Observable<BaseResponseEntity<Object>> delShopping(@Header("token") String token,@Field("sb_id")String sb_id);
    /**
     * 加入购物袋
     */
    @FormUrlEncoded
    @POST("Shopp/addShopp")
    Observable<BaseResponseEntity<Object>> addShopping(@Header("token") String token,@Field("goods_id")String goods_id);
    /**
     * 购物袋提示
     */
    @POST("shopp/shopp_tips")
    Observable<BaseResponseEntity<Shop>> updateShopping(@Header("token") String token);
    /**
     * 我的团队跟二级团队
     */
    @FormUrlEncoded
    @POST("user_center/distribute")
    Observable<BaseResponseEntity<Team>> team(@Header("token") String token, @Field("user_id") String user_id);
    /**
     * 翡翠积分收益
     */
    @FormUrlEncoded
    @POST("user_center/profit")
    Observable<BaseResponseEntity<Profit>> profit(@Header("token") String token, @Field("ct_id") String ct_id, @Field("goods_id") String goods_id);

    /**
     * 提货
     */
    @FormUrlEncoded
    @POST("user_center/pick_up")
    Observable<BaseResponseEntity<Pick>> pick(@Header("token") String token, @Field("ct_id") String ct_id);

    /**
     * 立即下单
     */
    @FormUrlEncoded
    @POST("Order/addOrder")
    Observable<BaseResponseEntity<ImOrder>> imOrder(@Header("token") String token, @Field("sb_id") String sb_id, @Field("goods_id")String goods_id);
    /**
     * 发起支付
     */
    @FormUrlEncoded
    @POST("pay/pay")
    Observable<BaseResponseEntity<Pay>> pay(@Header("token") String token, @Field("send") String send, @Field("live")String live,@Field("cabinet")String cabinet,@Field("address_id")String address_id,@Field("pay_type") String pay_type,@Field("trade_password")String trade_password);
    /**
     * 商品详情分享
     */
    @FormUrlEncoded
    @POST("common/goods_share")
    Observable<BaseResponseEntity<DetailShare>> detailShare(@Field("goods_sn")String goods_sn);
    /**
     * 直播列表
     */
    @POST("live/live_list")
    Observable<BaseResponseEntity<LiveList>> liveList(@Header("token")String token);
    /**
     * 直播详情
     */
    @FormUrlEncoded
    @POST("live/live_detail")
    Observable<BaseResponseEntity<LiveDetail>> liveDetail(@Header("token") String token, @Field("live_id")String live_id);
    /**
     * 直播信息
     */
    @ FormUrlEncoded
    @POST("common/live_info")
    Observable<BaseResponseEntity<LiveMessage>> liveMessage( @Field("live_id")String live_id);
    /**
     * 直播间商品
     */

    @FormUrlEncoded
    @POST("live/live_goods")
    Observable<BaseResponseEntity<LiveGoods>> liveGoods(@Field("live_id")String live_id);
    /**
     * 预约直播
     */
    @FormUrlEncoded
    @POST("user_center/order_live")
    Observable<BaseResponseEntity<Object>> liveYuyue(@Header("token") String token,@Field("live_id")String live_id);
    /**
     * 直播分享
     */
    @FormUrlEncoded
    @POST("common/live_share")
    Observable<BaseResponseEntity<LiveShare>> liveShare(@Field("live_id")String live_id);
    /**
     * 直播分享
     */
    @POST("user_center/share")
    Observable<BaseResponseEntity<Share>> myShare(@Header("token") String token);


}





